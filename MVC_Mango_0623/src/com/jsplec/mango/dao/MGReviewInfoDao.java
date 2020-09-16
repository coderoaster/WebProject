package com.jsplec.mango.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.mango.dto.MGDto;

public class MGReviewInfoDao {
	DataSource dataSource;
	int store_id;
	public MGReviewInfoDao() {
		try{
			Context context = new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/mango_db");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MGDto reviewRestaurant(String seq) {
		MGDto dto = new MGDto();
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query ="select seq, R_name, rating, R_gu, addr, tel, kind, open_time, holiday, menu, category, img from s_restaurants where seq = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(seq));
			resultset = preparedStatement.executeQuery();
			
			if (resultset.next()) {
				int id_store = resultset.getInt("seq");
				String store_name = resultset.getString("R_name");
				Double rating = resultset.getDouble("rating");
				String R_gu = resultset.getString("R_gu");
				String address = resultset.getString("addr");
				String tel = resultset.getString("tel");
				String kind = resultset.getString("kind");
				String open_time = resultset.getString("open_time");
				String holiday = resultset.getString("holiday");
				String menu = resultset.getString("menu");
				String category_food = resultset.getString("category");
				String image_food = resultset.getString("img");
				dto =new MGDto(id_store, store_name, rating, R_gu, address, tel, kind, open_time, holiday, menu, category_food, image_food);
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
		return dto;

	}
}