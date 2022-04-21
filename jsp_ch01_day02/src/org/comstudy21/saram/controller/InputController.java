package org.comstudy21.saram.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.saram.model.SaramDao;
import org.comstudy21.saram.model.SaramDto;

public class InputController extends HttpServlet {
	ServletContext application;
	SaramDao saramDao = new SaramDao();
	
	@Override
	public void init() throws ServletException {
		application = getServletContext();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewName = "/WEB-INF/views/saram_input.jsp";
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		System.out.println("POST 요청 시 호출");
		// 전달된 파라미터를 받아서 처리 하자.
		String no = req.getParameter("no");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		SaramDto dto = new SaramDto(Integer.parseInt(no), name, phone, email);
		
		saramDao.insert(dto);
		
		resp.sendRedirect("list.saram");
	}
}
