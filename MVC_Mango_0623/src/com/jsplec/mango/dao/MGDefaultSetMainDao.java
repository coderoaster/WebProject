package com.jsplec.mango.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.mango.dto.MGDto;



public class MGDefaultSetMainDao {
	
	DataSource dataSource;
	int store_id;
	public MGDefaultSetMainDao() {
		try{
			Context context = new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/mango_db");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MGDto> search_rating() {
		ArrayList<MGDto> dtos = new ArrayList<MGDto>();
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			String query ="SELECT seq, R_name, R_gu, R_dong, category, kind, img, rating FROM mango_db.s_restaurants order by rating desc limit 8";
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
//	
//	public ArrayList<MGDto> search_local() {
//		ArrayList<MGDto> dtos = new ArrayList<MGDto>();
//		Connection connection = null;
//		PreparedStatement preparedStatement =null;
//		ResultSet resultset = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query ="SELECT seq, R_name, R_dong, category, kind, img, rating FROM mango_db.s_restaurants order by rating desc limit 8";
//			preparedStatement =connection.prepareStatement(query);
//			resultset = preparedStatement.executeQuery();
//			while (resultset.next()) {
//				int id_store = resultset.getInt("seq");
//				String store_name = resultset.getString("R_name");
//				String r_dong = resultset.getString("R_dong");
//				String category_food = resultset.getString("category");
//				String kind = resultset.getString("kind");
//				String image_food = resultset.getString("img");
//				Double rating = resultset.getDouble("rating");
//				System.out.println(store_name);
//				MGDto dto = new MGDto(id_store, store_name, rating, image_food, category_food, kind, r_dong);
//				dtos.add(dto);
//			}
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(resultset !=null) resultset.close();
//				if(preparedStatement !=null) preparedStatement.close();
//				if(connection !=null) connection.close();
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//		}
//		return dtos;
//	}
//	
//	public ArrayList<MGDto> search_menu() {
//		ArrayList<MGDto> dtos = new ArrayList<MGDto>();
//		Connection connection = null;
//		PreparedStatement preparedStatement =null;
//		ResultSet resultset = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query ="SELECT seq, R_name, R_dong, category, kind, img, rating FROM mango_db.s_restaurants order by rating desc limit 8";
//			preparedStatement =connection.prepareStatement(query);
//			resultset = preparedStatement.executeQuery();
//			while (resultset.next()) {
//				int id_store = resultset.getInt("seq");
//				String store_name = resultset.getString("R_name");
//				String r_dong = resultset.getString("R_dong");
//				String category_food = resultset.getString("category");
//				String kind = resultset.getString("kind");
//				String image_food = resultset.getString("img");
//				Double rating = resultset.getDouble("rating");
//				System.out.println(store_name);
//				MGDto dto = new MGDto(id_store, store_name, rating, image_food, category_food, kind, r_dong);
//				dtos.add(dto);
//			}
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(resultset !=null) resultset.close();
//				if(preparedStatement !=null) preparedStatement.close();
//				if(connection !=null) connection.close();
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//		}
//		return dtos;
//	}
	
	
}