package com.jsplec.mango.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.mango.command.MGCommand;
import com.jsplec.mango.command.MGDeleteCookieCommand;
import com.jsplec.mango.command.MGMemberSignCommand;
import com.jsplec.mango.command.review.MGReviewClickCommand;
import com.jsplec.mango.command.review.MGReviewInfoCommand;
import com.jsplec.mango.command.review.MGReviewInsertCommand;
import com.jsplec.mango.command.search.MGDefaultSetMain;
import com.jsplec.mango.command.search.MGRestaurantInfoCommand;
import com.jsplec.mango.command.search.MGSearchCommand;
import com.jsplec.mango.command.search.MGToplistCommand;
import com.jsplec.mango.dao.MGDefaultSetMainDao;
import com.jsplec.mango.command.MGInsertRestaurantCommand;
import com.jsplec.mango.command.MGLoadCookieListCommand;

/**
 * Servlet implementation class BdrontController
 */
@WebServlet("*.do")
public class MGController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MGController() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo()");
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		String viewPage = null;
		String page_name = null;
		String seq = null;
		MGCommand command = null;
		MGCommand command2 = null;
		
		switch(com) {
		case("/restaurants.do"):
			command = new MGRestaurantInfoCommand();
			command.execute(request, response);
			command2 = new MGLoadCookieListCommand();
			command2.execute(request, response);
			viewPage="restaurants.jsp";
			break;
		case("/login.do"):
			/*
			 * page_name = request.getParameter("page_name"); seq =
			 * request.getParameter("seq");
			 */
			command = new MGMemberSignCommand();
			command.execute(request, response);
			command2 = new MGLoadCookieListCommand();
			command2.execute(request, response);
			viewPage = "main.do";
			/* viewPage = page_name + ".do?page_name=" + page_name + "&seq=" + seq; */
			break;			
		case("/logout.do"):
			page_name = request.getParameter("page_name");
			seq = request.getParameter("seq");
			viewPage = "logout.jsp?page_name=" + page_name + "&seq=" + seq;
			break;
		case("/search.do"):
			command = new MGSearchCommand();
			command.execute(request, response);
			command2 = new MGLoadCookieListCommand();
			command2.execute(request, response);
			viewPage = "search.jsp";
			break;
		case("/top_lists.do"):
			command = new MGToplistCommand();
			command.execute(request, response);
			command2 = new MGLoadCookieListCommand();
			command2.execute(request, response);
			viewPage = "top_lists.jsp";
			break;
		case("/top_listsMain.do"):
			command = new MGToplistCommand();
			command.execute(request, response);
			command2 = new MGLoadCookieListCommand();
			command2.execute(request, response);
			viewPage = "top_listsMain.jsp";
			break;
		case("/insertRestaurants.do"):
			command = new MGInsertRestaurantCommand();
			command.execute(request, response);
			command2 = new MGLoadCookieListCommand();
			command2.execute(request, response);
			viewPage="main.do";
			break;
		case("/main.do"):
			command = new MGDefaultSetMain();
			command.execute(request, response);
			command2 = new MGLoadCookieListCommand();
			command2.execute(request, response);
			viewPage="MangoMain.jsp";
			break;
		case("/Reviewinfo.do"):
			command = new MGReviewInfoCommand();
			command.execute(request, response);
			command2 = new MGLoadCookieListCommand();
			command2.execute(request, response);
			viewPage="Reviewinsert.jsp";
			break;
		case("/reviewinsert.do"):
			seq = request.getParameter("seq");
			command = new MGReviewInsertCommand();
			command.execute(request, response);
			command2 = new MGLoadCookieListCommand();
			command2.execute(request, response);
			viewPage="ReviewInsertSuccess.jsp?seq =" + seq;
			break;
		case("/reviewclick.do"):
			command = new MGReviewClickCommand();
			command.execute(request, response);
			command2 = new MGLoadCookieListCommand();
			command2.execute(request, response);
			viewPage = "ReviewClick.jsp";
			break;
		case("/deleteCookie.do"):
			page_name = request.getParameter("page_name");
			seq = request.getParameter("seq");
			command = new MGDeleteCookieCommand();
			command.execute(request, response);
			viewPage = page_name + ".do?seq=" + seq;
			break;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	
	}
}
