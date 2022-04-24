package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDao;

public class RegisterController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String registerValidate = "";
		if(request.getParameter("btn_register")!=null) {
			// 회원가입 버튼 눌렀을 때
			int no = Integer.parseInt(request.getParameter("txt_no"));
			String id = request.getParameter("txt_id");
			String pw = request.getParameter("txt_pw");
			String email = request.getParameter("txt_email");
			String regidate = request.getParameter("text_regidate");
			
			RegisterBean registerBean = new RegisterBean();
			
			registerBean.setNo(no);
			registerBean.setId(id);
			registerBean.setPw(pw);
			registerBean.setEmail(email);
			registerBean.setRegidate(regidate);
			
			RegisterDao registerdao = new RegisterDao();
			
			registerValidate = registerdao.authorizeRegister(registerBean);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			request.setAttribute("RegisterErrorMsg", registerValidate);
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			try {
				rd.include(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
