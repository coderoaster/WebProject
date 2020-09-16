package com.jsplec.mango.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.mango.dto.MGDto;
import com.mysql.cj.util.StringUtils;

public class MGReviewListDao {
	
	DataSource dataSource;
	int store_id;
	public MGReviewListDao() {
		try{
			Context context = new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/mango_db");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
//	리뷰 슬라이드에서 리스트 받아오는 메소드	
	public ArrayList<MGDto> reviewList(int storeId){
		ArrayList<Integer> member_id_user = new ArrayList<Integer>();
		ArrayList<String> review_contents = new ArrayList<String>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> review_evaluation = new ArrayList<String>();
		ArrayList<String> review_image = new ArrayList<String>();
		ArrayList<String> member_name = new ArrayList<String>();
		ArrayList<String> member_image = new ArrayList<String>();
		ArrayList<MGDto> dtos = new ArrayList<MGDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			
//			유저id, 내용, 날짜, 평가, 리뷰 이미지 가져오기
			String query ="select member_id_user, content, date, rating, image from review where r_seq = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, storeId);
			resultset = preparedStatement.executeQuery();
			
			while (resultset.next()) {
				member_id_user.add(resultset.getInt("member_id_user"));
				review_contents.add(resultset.getString("content"));
				date.add(new SimpleDateFormat("yyyy/MM/dd").format(resultset.getTimestamp("date")));
				review_evaluation.add(resultset.getString("rating"));
				review_image.add(resultset.getString("image"));
			}
			
//			유저 이름, 프로필 사진 가져오기
			query = "select name, image from mango_db.member where id_user = ?";
			for(int i = 0; i < member_id_user.size(); i++) {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, member_id_user.get(i));
				resultset = preparedStatement.executeQuery();
				
				while (resultset.next()) {
					member_name.add(resultset.getString("name"));
					member_image.add(resultset.getString("image"));
				}
			}
			for(int i = 0; i < member_id_user.size(); i++) {
				MGDto dto = new MGDto(review_contents.get(i), date.get(i), review_evaluation.get(i), review_image.get(i), member_name.get(i), member_image.get(i));
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
	
	public MGDto reviewClick(int seq_review) {
		int r_seq = 0;
		int member_id_user = 0;
		String store_name = new String();
		String review_contents = new String();	
		String date = new String();
		String review_evaluation = new String();
		String review_image = new String();
		String member_name = new String();
		String member_image = new String();
		MGDto dto = new MGDto();
		
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
//			클릭한 리뷰의 가게 id, 유저 id, 내용, 날짜, 평가, 리뷰 이미지 가져오기
			String query ="select r_seq, member_id_user, content, date, rating, image from review where seq_review = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, seq_review);
			resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				r_seq = resultset.getInt("r_seq");
				member_id_user = resultset.getInt("member_id_user");
				review_contents = resultset.getString("content");
				date = new SimpleDateFormat("yyyy/MM/dd").format(resultset.getTimestamp("date"));
				review_evaluation = resultset.getString("rating");
				review_image = resultset.getString("image");
			}
			preparedStatement.close();
			resultset.close();
			
//			가게 이름 가져오기
			query ="select R_name from s_restaurants where seq = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, r_seq);
			resultset = preparedStatement.executeQuery();
				
			if(resultset.next()) {
				store_name = resultset.getString("R_name");
			}
			
			preparedStatement.close();
			resultset.close();
			
//			유저 이름, 프로필사진 가져오기
			query = "select name, image from mango_db.member where id_user = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, member_id_user);
			resultset = preparedStatement.executeQuery();
			
			if(resultset.next()) {
				member_name = resultset.getString("name");
				member_image = resultset.getString("image");
			}
			dto = new MGDto(store_name, review_contents, date, review_evaluation, review_image, member_name, member_image, r_seq);
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



