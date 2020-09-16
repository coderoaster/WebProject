package com.jsplec.mango.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.mango.dto.MGDto;

public class MGToplistDao {
	
	DataSource dataSource;
	int store_id;
	public MGToplistDao() {
		try{
			Context context = new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/mango_db");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MGDto> searchToplist(String rest_category, String rest_addr, int table_num) {
		ArrayList<MGDto> dtos = new ArrayList<MGDto>();
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query ="select seq, R_name, addr, img, rating  from mango_db.s_restaurants where category like '%"+rest_category+"%' and addr like '%"+rest_addr+"%' order by rating desc limit "+((table_num - 1) * 10)  + " , 10";
			preparedStatement =connection.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				int id_store = resultset.getInt("seq");
				String store_name = resultset.getString("R_name");
				String address = resultset.getString("addr");
				String image_food = resultset.getString("img");
				Double rating = resultset.getDouble("rating");
				store_id = id_store;
				MGDto dto = new MGDto(id_store, store_name, rating, image_food, address);
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
			String query ="SELECT count(*) FROM review where id_store =" + store_id;
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
	
	public int tablecount(String rest_category, String rest_addr) {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultset = null;
		int tablecount = 0 ;
		try {
			connection = dataSource.getConnection();
			String query ="SELECT count(*) FROM mango_db.s_restaurants where category like '%"+rest_category+"%' and addr like '%"+rest_addr+"%'";
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
}
