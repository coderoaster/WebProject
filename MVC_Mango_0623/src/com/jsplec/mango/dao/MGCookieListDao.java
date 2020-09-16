package com.jsplec.mango.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.mango.dto.MGDto;



public class MGCookieListDao {
	
	DataSource dataSource;
	public MGCookieListDao() {
		try{
			Context context = new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/mango_db");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MGDto> search(ArrayList<String> seq_list) {
		ArrayList<MGDto> dtos = new ArrayList<MGDto>();
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			int cnt=0;
			
			while(cnt < seq_list.size()) {
				String query ="select seq, R_name, R_gu, R_dong, category, kind, img, rating  from s_restaurants where seq = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(seq_list.get(cnt)));
				resultset = preparedStatement.executeQuery();
				
				if (resultset.next()) {	
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
//					System.out.println("저장되었음" + dtos.get(cnt).getStore_name());
					cnt++;
				}
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