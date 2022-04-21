package org.comstudy21.saram;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaramStrListController extends HttpServlet {
	ArrayList<String> dataList = new ArrayList<String>();
	{
		dataList.add("홍길동-프로그래머");
		dataList.add("김길동-기획자");
		dataList.add("이길동-디자이너");
		dataList.add("박길동-DBA");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet - SaramController");
		
		req.setAttribute("message",  "Hello world");		
		// req라는 참조값은 request라는 이름으로 바뀌고, resp -> response로 이름이 바뀐다.
		// getAttribute와 키값을 이용하면 값을 뷰페이지에서 불러올 수 있다.
		req.setAttribute("user", "HONG");
		req.setAttribute("dataList", dataList);	// saram_list.jsp에서 dataList 사용
		
		String viewName = "/WEB-INF/views/saram_list.jsp";
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}
	
	// list.saram이라는 주소를 타고 들어오면 doGet이 실행되게 하는 것이 주소의 역할
	// 근데 여기를 실행하는 것이 아니라 다른 JSP 파일을 보여지게 해줄 수 있다. (포워드)
}
