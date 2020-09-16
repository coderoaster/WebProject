package com.jsplec.mango.command.search;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.mango.command.MGCommand;
import com.jsplec.mango.dao.MGMapDao;
import com.jsplec.mango.dao.MGSearchDao;
import com.jsplec.mango.dao.MGToplistDao;
import com.jsplec.mango.dto.MGDto;

public class MGToplistCommand implements MGCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String rest_category = request.getParameter("rest_category");
				String rest_addr = request.getParameter("rest_addr");
				String title = request.getParameter("title");
				int page = 0;
				if(request.getParameter("page") == null) {
					page = 1;
				}else {
					page = Integer.parseInt(request.getParameter("page"));
				}				
				MGToplistDao tdao = new MGToplistDao();
//				ArrayList<MGDto>  dtos = tdao.searchToplist(rest_name, rest_category, rest_addr, page);
//				int num = tdao.tablecount(rest_name, rest_category, rest_addr);
				ArrayList<MGDto>  dtos = tdao.searchToplist(rest_category, rest_addr, page);
				int num = tdao.tablecount(rest_category, rest_addr);
				
				request.setAttribute("list", dtos);			
				request.setAttribute("rest_category", rest_category);			
				request.setAttribute("rest_addr", rest_addr);			
//				request.setAttribute("reviewcount", tdao.reviewcount());
				request.setAttribute("restaurantnum", num);
				request.setAttribute("title", title);
	}

}
