package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;

public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("btn_login")!=null) {
			// login.jsp페이지 버튼 이벤트가 발생했을 때
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			LoginBean loginBean = new LoginBean();
			// LoginBean 클래스는 index.jsp클래스에서 필요한 데이터들을 효율적으로 가져올 수 있게 해줌. (게터세터)
			
			loginBean.setId(id);
			loginBean.setPw(pw);
			
			LoginDao loginDao = new LoginDao();
			
			String authorize = loginDao.authorizeLogin(loginBean);
			
			if(authorize.equals("SUCCESS LOGIN")) {
				HttpSession session = request.getSession();
				session.setAttribute("login", loginBean.getId());
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
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
				request.setAttribute("WrongLoginMsg", authorize);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
}
