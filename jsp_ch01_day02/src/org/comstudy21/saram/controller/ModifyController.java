package org.comstudy21.saram.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.saram.model.SaramDao;
import org.comstudy21.saram.model.SaramDto;

public class ModifyController extends HttpServlet{
	ServletContext application;
	SaramDto modifyDto = new SaramDto();
	SaramDto preModifyDto = new SaramDto();
	SaramDao dao = new SaramDao();
	List<SaramDto> list = new ArrayList<SaramDto>();
	
	String name;
	String phone;
	String email;
	@Override
	public void init() throws ServletException {
		application = getServletContext();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/saram_modify.jsp";
		RequestDispatcher view = req.getRequestDispatcher(path);
		view.forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		System.out.println("POST 요청 시 호출");
		
		String no = req.getParameter("no");
		// System.out.println("no" + no);	// 정상 출력 확인
		list = dao.selectAll();
		for(SaramDto dto : list) {
			if(dto.getNo()==Integer.parseInt(no)) {
				// 같은 no 발견했을 때 해당 no의 데이터 모두 추출
				name = req.getParameter("name");
				phone = req.getParameter("phone");
				email = req.getParameter("email");
				break;
			}
		}
		
		preModifyDto = new SaramDto(Integer.parseInt(no), name, phone, email);
		
		modifyDto = dao.update(preModifyDto);
		
		req.setAttribute("saramUpdate", modifyDto);
		
		// 수정 후 목록 갱신
		resp.sendRedirect("list.saram");
	}
}
