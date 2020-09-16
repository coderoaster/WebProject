package com.jsplec.mango.command.search;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.mango.dao.MGSearchDao;
import com.jsplec.mango.command.MGCommand;
import com.jsplec.mango.dao.MGMapDao;
import com.jsplec.mango.dto.MGDto;
import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;


public class MGSearchCommand implements MGCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String search = request.getParameter("search");
		System.out.println(search);
		
		int page = 0;
		if(request.getParameter("page") == null) {
			page = 1;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
		}				
		MGSearchDao dao = new MGSearchDao();
		ArrayList<MGDto>  dtos = dao.search(search, page);
		int num = dao.tablecount(search);
		
		MGMapDao mdao = new MGMapDao();
		ArrayList<MGDto> mapaddress = mdao.Mapaddress(search, page);		
		ArrayList<MGDto> mapname = mdao.Mapname(search, page);
		request.setAttribute("mapname", mapname);
		request.setAttribute("mapaddress", mapaddress);
		request.setAttribute("search", search);
		request.setAttribute("list", dtos);			
		request.setAttribute("reviewcount", dao.reviewcount());
		request.setAttribute("restaurantnum", num);
	}

}
