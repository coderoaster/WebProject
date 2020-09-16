package com.jsplec.mango.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.mango.dto.MGDto;



public class MGSearchDao {
	
	DataSource dataSource;
	int store_id;
	public MGSearchDao() {
		try{
			Context context = new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/mango_db");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MGDto searchRestaurant(String seq) {
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
				String address2[] = address.split("지번");
				dto =new MGDto(id_store, store_name, rating, R_gu, address2[0] , tel, kind, open_time, holiday, menu, category_food, image_food);
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
	
	public ArrayList<MGDto> searchReview(String seq_restaurant) {
		ArrayList<MGDto> dtos = new ArrayList<MGDto>();
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultset = null;
		try { 
			connection = dataSource.getConnection();
			String query ="select r.seq, m.name, r.id_store, r.date, r.evaluation, r.contents, m.image from mango_db.member as m, review as r\n" + 
					"where r.id_member = m.id_user and r.id_store = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(seq_restaurant));
			resultset = preparedStatement.executeQuery();
			
			while (resultset.next()) {
				int id_review = resultset.getInt("r.seq");
				int id_store = resultset.getInt("r.id_store");
				String kakaoName = resultset.getString("m.name");
				String date = resultset.getString("r.date");
				String evaluation = resultset.getString("evaluation");
				String contents = resultset.getString("contents");
				String kakaoImage = resultset.getString("m.image");
				MGDto dto = new MGDto(kakaoName, kakaoImage, id_store, id_review, date, evaluation, contents);
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
	
	public ArrayList<MGDto> search(String search, int table_num) {
		ArrayList<MGDto> dtos = new ArrayList<MGDto>();
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			String query ="select seq, R_name, R_gu, R_dong, category, kind, img, rating  from s_restaurants where R_name like '%"+search+"%' or category like '%"+search+"%' or addr like '%"+search+"%' order by rating desc limit "+((table_num - 1) * 10)  + " , 10";
			preparedStatement =connection.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				int id_store = resultset.getInt("seq");
				String store_name = resultset.getString("R_name");
				String R_gu = resultset.getString("R_gu");
				String r_dong = resultset.getString("R_dong");
				String category_food = resultset.getString("category");
				String kind = resultset.getString("kind");
				String image_food = resultset.getString("img");
				Double rating = resultset.getDouble("rating");
				store_id = id_store;
				MGDto dto = new MGDto(id_store, store_name, rating, image_food, category_food, kind, R_gu, r_dong);
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
	
	public int reviewcount() {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultset = null;
		int reviewcount = 0 ;
		try {
			connection = dataSource.getConnection();
			String query ="SELECT count(*) FROM review where R_seq =" + store_id;
			preparedStatement =connection.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			resultset.next();
				reviewcount = resultset.getInt(1);		
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
		return reviewcount;
	}
	
	public int tablecount(String search) {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultset = null;
		int tablecount = 0 ;
		try {
			connection = dataSource.getConnection();
			String query ="SELECT count(*) FROM s_restaurants where R_name like '%"+search+"%' or category like '%"+search+"%' or addr like '%"+search+"%'";
			preparedStatement =connection.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			resultset.next();
				tablecount = resultset.getInt(1);		
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
		return tablecount;
	}
	public void addr(String bName, String bTitle, String bContent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection =dataSource.getConnection();
			String query = "INSERT INTO `mango_db`.`s_restaurants` (`category`, `R_name`, `R_gu`, `R_dong`, `addr`, `tel`, `kind`, `rating`, `open_time`, `holiday`, `menu`, `r_code`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			System.out.println(bName);
			preparedStatement.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement!=null)preparedStatement.close();
				if(connection!=null)connection.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		
		}
	}
}