package org.comstudy21.saramcontroller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.controller.ModelAndView;
import org.comstudy21.model.MemberDto;

public class InputController extends SaramController {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		// POST 방식으로 넘어오니까 이전 페이지에서 요청한 정보는 그대로 넘어온다.
		String no = req.getParameter("no");	// getParameter 자체가 String으로 넘어옴.
		String id = req.getParameter("name");
		String pw = req.getParameter("phone");
		String email = req.getParameter("email");
		String regidate = req.getParameter("regidate");
		
		System.out.println("InputController > no : " + no);
		MemberDto dto = new MemberDto(Integer.parseInt(no), id, pw, email, regidate);
		saramDao.insert(dto);
	}
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView modelAndView = new ModelAndView("list.saram", true);
		if("GET".equals(req.getMethod())) {
			// doGet(req, resp);
			modelAndView = new ModelAndView("saram_input", false);
			// saram_input 초기 진입 시 get방식으로 들어오고 다시 한번 더 saram_input 으로 들어오게 하기 위함.
			// 입력 받을 땐 reDirect 필요 없으므로 false
		}
		else {
			try {
				doPost(req, resp);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return modelAndView;
	}

}
