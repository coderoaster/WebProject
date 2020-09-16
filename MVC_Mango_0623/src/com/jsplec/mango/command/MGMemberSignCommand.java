package com.jsplec.mango.command;


import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.jsplec.mango.dao.MGSearchDao;
import com.jsplec.mango.dao.MGLoginDao;
import com.jsplec.mango.dto.MGDto;

public class MGMemberSignCommand implements MGCommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String kakaoId = request.getParameter("kakaoId");
		String kakaoName = request.getParameter("kakaoName");
		String kakaoImage = request.getParameter("kakaoImage");
		
		//	DB 연결 
		MGLoginDao ldao = new MGLoginDao();
		//	회원가입 DB Insert
		ldao.sign(kakaoId, kakaoName, kakaoImage);
		MGDto dto = ldao.login(kakaoId);
		request.setAttribute("kakaoId", dto.getKakaoId());
		request.setAttribute("kakaoName", dto.getKakaoName());
		request.setAttribute("kakaoImage", dto.getKakaoImage());

	}
//	public void loginSession() {
//		MGDao dao = new MGDao();
//		MGDto dto = dao.login(kakaoId);
//		session.setAttribute("kakaoId", dto.getKakaoId());
//		session.setAttribute("kakaoName", dto.getKakaoName());
//		session.setAttribute("kakaoImage", dto.getKakaoImage());
//	}
	
}
