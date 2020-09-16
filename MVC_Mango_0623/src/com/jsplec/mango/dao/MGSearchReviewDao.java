package com.jsplec.mango.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.mango.dto.MGDto;

public class MGSearchReviewDao {
	DataSource dataSource;

	
	public MGSearchReviewDao() {
		try{
			Context context = new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/mango_db");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<MGDto> searchReview(String seq_restaurant) {
		ArrayList<MGDto> dtos = new ArrayList<MGDto>();
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultset = null;
		try { 
			connection = dataSource.getConnection();
			String query ="SELECT seq_review, member_id_user, content, date, rating, image, user_img, user_name, r_seq FROM mango_db.review where r_seq = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(seq_restaurant));
			resultset = preparedStatement.executeQuery();
			
			while (resultset.next()) {
				int id_review = resultset.getInt("seq_review");
				int kakaoId = resultset.getInt("member_id_user");
				int id_store = resultset.getInt("r_seq");
				String kakaoName = resultset.getString("user_name");
				String date = resultset.getString("date");
				String evaluation = resultset.getString("rating");
				String contents = resultset.getString("content");
				String kakaoImage = resultset.getString("user_img");
				String review_image = resultset.getString("image");
				MGDto dto = new MGDto(kakaoId, kakaoName, kakaoImage, id_store, id_review, date, evaluation, contents, review_image);
				dtos.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultset !=null) resultset.close();
				if(preparedStatement !=null) preparedStatement.close();
				if(connection !=null) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return dtos;
	}

}
