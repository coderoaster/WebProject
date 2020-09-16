package com.jsplec.mango.command.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.mango.command.MGCommand;
import com.jsplec.mango.dao.MGReviewListDao;
import com.jsplec.mango.dto.MGDto;

public class MGReviewClickCommand implements MGCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq_review = Integer.parseInt(request.getParameter("seq_review"));
		MGReviewListDao rdao = new MGReviewListDao();
		MGDto dto = rdao.reviewClick(seq_review);
		request.setAttribute("review_click", dto);

		
	}

}
