package org.comstudy21.saram.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.saram.model.SaramDao;
import org.comstudy21.saram.model.SaramDto;

public class DetailController extends HttpServlet {
	ServletContext application;
	SaramDto SelectDto = new SaramDto();
	SaramDao dao = new SaramDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		//System.out.println("no => " + no);
		
		// Dao에서 검색
		SelectDto = dao.selectByNo(no);
		req.setAttribute("saramDetail", SelectDto);
		
		// detail 페이지로 forward
		String viewName = "/WEB-INF/views/saram_detail.jsp";
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}
}
