package com.jsplec.mango.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.mango.cookie.CookieBox;

public class MGDeleteCookieCommand implements MGCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CookieBox cookieBox = new CookieBox(request);
		cookieBox.existsCookies(cookieBox, request, response);
	}
}
