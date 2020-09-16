package com.jsplec.mango.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.websocket.Session;

public class MGReviewInsertDao {
	DataSource dataSource;
	
	public MGReviewInsertDao() {
		try{
			Context context = new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/mango_db");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertreview(int member_id_user, String content, String image, String rating, String user_img, String user_name,  int r_seq) {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		
		try {
			connection = dataSource.getConnection();
			//	?에 값을 담으려면 preparedStatement 사용 해야함
			String query = "insert into review(member_id_user, content, image, rating, r_seq, user_img, user_name, date) values(?,?,?,?,?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, member_id_user);	
			preparedStatement.setString(2, content);	
			preparedStatement.setString(3, image);
			preparedStatement.setString(4, rating);
			preparedStatement.setInt(5, r_seq);
			preparedStatement.setString(6, user_img);
			preparedStatement.setString(7, user_name);
			System.out.println(member_id_user);
			System.out.println(content);
			System.out.println(user_img);
			System.out.println(rating);
			System.out.println(r_seq);
			System.out.println(user_name);
			
			
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
