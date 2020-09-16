package com.jsplec.mango.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.mango.cookie.CookieBox;
import com.jsplec.mango.dao.MGCookieListDao;
import com.jsplec.mango.dto.MGDto;

public class MGLoadCookieListCommand implements MGCommand {
	ArrayList<String> arr;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				try {
					CookieBox cookieBox = new CookieBox(request);
					
				    arr = new ArrayList<String>();
				    Cookie[] cookie_arr = cookieBox.getCookies();
				    System.out.println("쿠키 불러옴");
				    for(int i=1; i<cookie_arr.length; i++) {
				    	arr.add(cookieBox.getCookieValue(cookie_arr[i]));
				    }
				    
				} catch (Exception e) {
					System.out.println(e);
				}
				//쿠키에 저장된 seq로 음식점 불러오기
				MGCookieListDao cdao = new MGCookieListDao();
				ArrayList<MGDto> dtos = cdao.search(arr);
				request.setAttribute("cookie_list", dtos);
				request.setAttribute("cookie_Cnt", arr.size());
	}

}
