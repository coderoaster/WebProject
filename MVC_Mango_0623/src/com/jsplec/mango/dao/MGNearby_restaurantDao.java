package com.jsplec.mango.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.mango.dto.MGDto;

public class MGNearby_restaurantDao {
	
	DataSource dataSource;
	int store_id;
	public MGNearby_restaurantDao() {
		try{
			Context context = new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/mango_db");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MGDto> nearbyRestaurant(String seq,String addr) {
		ArrayList<MGDto> dtos = new ArrayList<MGDto>();
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultset = null;
		int seqnum = Integer.parseInt(seq);
		try {
			connection = dataSource.getConnection();
			String query ="SELECT seq, R_name, rating, R_gu, addr, tel, kind, open_time, holiday, menu, category, img FROM mango_db.s_restaurants where seq NOT IN ("+seqnum+") and addr like'%"+addr+"%'order by rating desc limit 4";
			preparedStatement = connection.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			
			while (resultset.next()) {
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
				MGDto dto =new MGDto(id_store, store_name, rating, R_gu, address2[0], tel, kind, open_time, holiday, menu, category_food, image_food);
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
