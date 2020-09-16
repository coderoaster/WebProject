package com.jsplec.mango.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.mango.dto.MGDto;

public class MGLoginDao {

	DataSource dataSource;
	public MGLoginDao() {
		try{
			Context context = new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/mango_db");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sign(String kakaoId, String kakaoName, String kakaoImage) {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		
		try {
			connection = dataSource.getConnection();
			//	?에 값을 담으려면 preparedStatement 사용 해야함
			String query = "insert into mango_db.member(id_user, name, image) values(?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, Integer.parseInt(kakaoId));	
			preparedStatement.setString(2, kakaoName);	
			preparedStatement.setString(3, kakaoImage);
			
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
	
	public MGDto login(String origin_kakaoId) {
		MGDto dto = new MGDto();
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet =null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select id_user, name, image from mango_db.member where id_user = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(origin_kakaoId));
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				int kakaoId = resultSet.getInt("id_user");
				String kakaoName = resultSet.getString("name");
				String kakaoImage = resultSet.getString("image");
				dto = new MGDto(kakaoId, kakaoName, kakaoImage);
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet !=null) resultSet.close();
				if(preparedStatement !=null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
}


