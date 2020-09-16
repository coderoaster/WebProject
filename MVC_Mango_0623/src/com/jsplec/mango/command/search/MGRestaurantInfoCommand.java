package com.jsplec.mango.command.search;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.mango.command.MGCommand;
import com.jsplec.mango.cookie.CookieBox;
import com.jsplec.mango.dao.MGCookieListDao;
import com.jsplec.mango.dao.MGNearby_restaurantDao;
import com.jsplec.mango.dao.MGReviewListDao;
import com.jsplec.mango.dao.MGSearchDao;
import com.jsplec.mango.dao.MGSearchReviewDao;
import com.jsplec.mango.dto.MGDto;

public class MGRestaurantInfoCommand implements MGCommand {
	ArrayList<String> arr;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//식당의 번호값으로 데이터 베이스에서 식당의 정보를 받아옴
		String seq = request.getParameter("seq");
		
	    
		MGSearchDao dao = new MGSearchDao();
		MGDto dto = dao.searchRestaurant(seq);
		request.setAttribute("restaurant_info", dto);
		CookieBox cookieBox = new CookieBox(request);
		
		try {
			Cookie cookie_seq = CookieBox.createCookie("recent_seq"+seq, seq, "/", 24*60*60);
			response.addCookie(cookie_seq);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//식당의 주소를 길을 기준으로 두개로 나
		String address = dao.searchRestaurant(seq).getAddress();
		String address1[] = address.split("길");
		
		
		//길앞의 식당주소를 새로운 변수에 담
		String addr = address1[0];
		
		//식당 주소를 이용하여 주변 식당정보 받아오기
		MGNearby_restaurantDao dao2 = new MGNearby_restaurantDao();
		ArrayList<MGDto> dto2 = dao2.nearbyRestaurant(seq, addr);
		request.setAttribute("nearby", dto2);
		MGSearchReviewDao dao3 = new MGSearchReviewDao();
		dao3.searchReview(seq);
		request.setAttribute("review", dao3.searchReview(seq));
		
		//음식점 화면 리뷰 리스트 불러오기
		MGReviewListDao rdao = new MGReviewListDao();
		int storeId = dto.getId_store();
		ArrayList<MGDto> reviewList = rdao.reviewList(storeId);
		request.setAttribute("review_info", reviewList);
		
		
	}

}
