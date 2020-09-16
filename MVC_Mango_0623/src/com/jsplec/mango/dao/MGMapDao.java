package com.jsplec.mango.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.mango.dto.MGDto;



public class MGMapDao {
	
	DataSource dataSource;
	public MGMapDao() {
		try{
			Context context = new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/mango_db");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MGDto> Mapaddress(String search, int table_num) {
		ArrayList<MGDto> dtos = new ArrayList<MGDto>();
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			String query ="select addr from s_restaurants where R_name like '%"+search+"%' or category like '%"+search+"%' or addr like '%"+search+"%' limit "+((table_num - 1) * 10)  + " , 10";
			preparedStatement =connection.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				String address = resultset.getString("addr");
				String address2[] = address.split("지번");
				MGDto dto = new MGDto();
				dto.setAddress(address2[1]);
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
	
	public ArrayList<MGDto> Mapname(String search, int table_num) {
		ArrayList<MGDto> dtos = new ArrayList<MGDto>();
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			String query ="select R_name from s_restaurants where R_name like '%"+search+"%' or category like '%"+search+"%' or addr like '%"+search+"%' limit "+((table_num - 1) * 10)  + " , 10";
			preparedStatement =connection.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				String store_name = resultset.getString("R_name");
				MGDto dto = new MGDto();
				dto.setStore_name(store_name);
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

