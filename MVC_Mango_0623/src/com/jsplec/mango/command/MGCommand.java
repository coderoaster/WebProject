package com.jsplec.mango.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface MGCommand {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;  
	
	
}
