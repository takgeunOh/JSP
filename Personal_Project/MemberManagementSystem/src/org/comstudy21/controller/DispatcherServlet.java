package org.comstudy21.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.saramcontroller.SaramController;

public class DispatcherServlet extends HttpServlet {
	private HandlerMapping handlerMapping = new HandlerMapping();
	private ViewResolver viewResolver = new ViewResolver();
	private void process(HttpServletRequest req, HttpServletResponse resp) {
		// path 만들어준다. 어떤 path? 핸들러를 안내해줄 수 있는 path
		// 어떻게? 컨텍스트 경로와 uri 경로를 이용해서..
		String ctxPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		int beginIndex = ctxPath.length();	// /부터 나올 것
		int endIndex = reqUri.indexOf(".");
		String path = reqUri.substring(beginIndex, endIndex);
		System.out.println("Dispatcher > ctxPath : " + ctxPath);
		System.out.println("Dispatcher > reqUri : " + reqUri);
		System.out.println("Dispatcher > path : " + path);
		// /list
		// /input
		// /detail
		// /realdetail
		// /premodify
		// /modify
		// /finalmodify
		// /predelete
		// /delete
		
		if(path.equals("/resultmodify"))
			req.setAttribute("resultmodifyFlag", 0);
		else
			req.setAttribute("resultmodifyFlag", null);
		
		SaramController controller = handlerMapping.getController(path);
		System.out.println("Dispatcher > controller : " + controller);
		// org.comstudy21.saramcontroller.ListController@3a4b4e99
		ModelAndView modelAndView = controller.request(req, resp);
		System.out.println("Dispatcher > viewName : " + modelAndView.getViewName());
		System.out.println("Dispatcher > isRedirect : " + modelAndView.isRedirect());
		// saram_list
		// false
		// saram_input
		// true
		viewResolver.forward(req, resp, modelAndView);
		// isRedirect가 false면 forward를 하고, true면 forward를 하지 않고 redirect 할듯
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
}
