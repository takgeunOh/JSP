package org.comstudy21.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//isRedirect가 false면 forward를 하고, true면 forward를 하지 않고 redirect 할듯

public class ViewResolver {
	// 접두어와 접미사를 구해서 인자로 받은 뷰네임과 합칠 것
	private String prefix = "/WEB-INF/views/";
	private String suffix = ".jsp";
	private String viewName = "/WEB-INF/views/saram_list.jsp";
	
	// req, resp, modelAndView(saram_list, false)
	public void forward(HttpServletRequest req, HttpServletResponse resp, ModelAndView modelAndView) {
		boolean isRedirect = modelAndView.isRedirect();
		viewName = modelAndView.getViewName();
		System.out.println("viewResolver > isRedirect : " + isRedirect);		// false
		System.out.println("viewResolver > viewName : " + viewName);		// saram_list
		
		if(isRedirect) {
			try {
				resp.sendRedirect(viewName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher view = req.getRequestDispatcher(prefix + viewName + suffix );		// 알맞은 jsp 경로를 가리키도록 한다.
			// RequestDispatcher 는 현재 request에 담긴 정보를 저장하고 있다가
			// 그 다음 페이지 이후에도 해당 정보를 볼 수 있게 계속 저장하는 기능.
			// forward 방식으로 페이지 전환 기능을 할거니까 당연히 계속 저장해놔야한다.
			// forward 방식은 다음 이동한 URL로 요청정보를 그대로 전달하기 때문
			System.out.println("ViewResolver Full ViewName : " + prefix + viewName + suffix);
			try {
				view.forward(req, resp);
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
