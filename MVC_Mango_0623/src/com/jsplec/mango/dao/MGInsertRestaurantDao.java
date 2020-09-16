package com.jsplec.mango.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MGInsertRestaurantDao {
	DataSource dataSource;
	
	public MGInsertRestaurantDao() {
		try{
			Context context = new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/mango_db");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertRestaurant(String category, String R_name, String addr, String tel, String kind, String open_time, String holiday, String img) {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		
		try {
			connection = dataSource.getConnection();
			//	?에 값을 담으려면 preparedStatement 사용 해야함
			String query = "insert into s_restaurants(category, R_name, addr, tel, kind, open_time, holiday, img) values(?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, category);	
			preparedStatement.setString(2, R_name);	
			preparedStatement.setString(3, addr);
			preparedStatement.setString(4, tel);
			preparedStatement.setString(5, kind);
			preparedStatement.setString(6, open_time);
			preparedStatement.setString(7, holiday);
			preparedStatement.setString(8, img);
			
			preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement !=null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
