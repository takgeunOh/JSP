package org.comstudy21.saram.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.saram.model.SaramDao;
import org.comstudy21.saram.model.SaramDto;

public class DeleteController extends HttpServlet{

	SaramDao dao = new SaramDao();
	SaramDto SelectDto = new SaramDto();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		
		System.out.println("delete_no => " + no);
		
		SelectDto = dao.selectByNo(no);
		dao.delete(SelectDto);
		req.setAttribute("saramDelete", SelectDto);
		
		// resp.sendRedirect("list.saram");
		
		String path = "/WEB-INF/views/saram_delete.jsp";
		RequestDispatcher view = req.getRequestDispatcher(path);
		view.forward(req, resp);
	}
	
	/*
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		
		System.out.println("delete_no => " + no);
		SelectDto = dao.selectByNo(no);
		dao.delete(SelectDto);
		req.setAttribute("saramDelete", SelectDto);
		
		resp.sendRedirect("list.saram");
	}
	*/
}
