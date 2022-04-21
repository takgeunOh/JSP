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

public class ListController extends HttpServlet {
	ServletContext application;
	SaramDao saramDao = new SaramDao();
	@Override
	public void init() throws ServletException {
		application = getServletContext();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<SaramDto> saramList = (ArrayList<SaramDto>)saramDao.selectAll();
		req.setAttribute("saramList", saramList);
		
		String viewName = "/WEB-INF/views/saram_list.jsp";
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}
}
