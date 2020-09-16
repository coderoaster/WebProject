package com.jsplec.mango.command.search;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.mango.command.MGCommand;
import com.jsplec.mango.dao.MGDefaultSetMainDao;
import com.jsplec.mango.dao.MGMapDao;
import com.jsplec.mango.dao.MGSearchDao;
import com.jsplec.mango.dto.MGDto;

public class MGDefaultSetMain implements MGCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
				
		MGDefaultSetMainDao dao = new MGDefaultSetMainDao();
		ArrayList<MGDto>  dtos = dao.search_rating();
		request.setAttribute("rating_list", dtos);
//		request.setAttribute("local_list", dtos);
//		request.setAttribute("menu_list", dtos);
	}	
}