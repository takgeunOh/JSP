package org.comstudy21.saram;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServlretTest extends HttpServlet {
	// 브라우저에서 이것을 구동시킬 수 있는 것. (HttpServlet만 상속시키기만 해도)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		System.out.println("doGet - SaramController");
		PrintWriter out = resp.getWriter();
		// out.println();
		out.printf("<html><body>");
		out.printf("<h1>%s</h1>", "Hello world");
		out.printf("<h2>%s</h2>", "길동이의 회원 목록");
		out.printf("</body><html>");
		out.close();
	}
}
