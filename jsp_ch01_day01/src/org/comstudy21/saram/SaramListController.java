package org.comstudy21.saram;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.comstudy21.saram.model.SaramDto;

public class SaramListController extends HttpServlet {
	ArrayList<SaramDto> saramList = new ArrayList<SaramDto>();
	{
		saramList.add(new SaramDto(1, "kim", "010-1111-1111", "kim@naver.com"));
		saramList.add(new SaramDto(2, "lee", "010-1111-1111", "lee@naver.com"));
		saramList.add(new SaramDto(3, "park", "010-1111-1111", "park@naver.com"));
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("saramList",  saramList);
		
		String viewName = "/WEB-INF/views/saram_list.jsp";
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}
}
