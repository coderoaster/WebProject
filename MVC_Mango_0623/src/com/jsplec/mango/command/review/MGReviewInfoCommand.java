package com.jsplec.mango.command.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.mango.command.MGCommand;
import com.jsplec.mango.dao.MGReviewInfoDao;
import com.jsplec.mango.dto.MGDto;

public class MGReviewInfoCommand implements MGCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String seq = request.getParameter("name");
		System.out.println(seq);
		MGReviewInfoDao dao = new MGReviewInfoDao();
		MGDto dto = dao.reviewRestaurant(seq);
		System.out.println(dto.getAddress());
		request.setAttribute("info", dto);
		request.setAttribute("seq", seq);
	}

}
