package org.comstudy21.saramcontroller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.controller.ModelAndView;
import org.comstudy21.model.MemberDao;
import org.comstudy21.model.MemberDto;

public class ModifyController extends SaramController {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<MemberDto> list = saramDao.selectAll();
		req.setAttribute("updateList", list);
	}
	
	protected void doPost1(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String no = req.getParameter("no");
		System.out.println("ModifyController 포스트1 방식 no : " + req.getParameter("no"));
		
		MemberDto dto = saramDao.selectByNo(no);
		MemberDto resultDto = new MemberDto(dto.getNo(), dto.getId(), dto.getPw(), dto.getEmail(), dto.getRegidate());

		req.setAttribute("detail_dto", resultDto);
	}
	
	protected void doPost2(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String no = req.getParameter("no");
		System.out.println("ModifyController 포스트2 방식 no : " + req.getParameter("no"));
		
		MemberDto resultDto = new MemberDto(Integer.parseInt(req.getParameter("no")), req.getParameter("id"), req.getParameter("pw"), req.getParameter("email"), req.getParameter("regidate"));

		saramDao.update(resultDto);
		
		ArrayList<MemberDto> list = saramDao.selectAll();
		req.setAttribute("updateDto", resultDto);
		req.setAttribute("updateList", list);
	}
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView modelAndView = new ModelAndView("list.saram", true);
		// 수정 버튼 클릭 시 상단에는 데이터 목록을 보여주고
		// 하단에는 입력폼을 넣자.
		// 그리고 수정완료 버튼 클릭 시 반영해주고 목록으로 넘어가도록.
		
		// 데이터 목록 보여줄 때에는 GET 방식
		// 입력받고 수정완료 버튼 누를 때에는 POST 방식
		System.out.println("ModifyController req.getMethod : " + req.getMethod());
		// 처음 들어갈 땐 겟방식
		// 수정 버튼 눌럿을 땐 포스트 방식
		// 수정 데이터 입력 후 수정완료 버튼 눌렀을 땐 포스트 방식
		if("GET".equals(req.getMethod())) {
			doGet(req, resp);
			modelAndView = new ModelAndView("saram_premodify", false);
		} else if ("POST".equals(req.getMethod()) && req.getAttribute("resultmodifyFlag")==null) {
			try {
				doPost1(req, resp);
				modelAndView = new ModelAndView("saram_modify", false);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("POST".equals(req.getMethod()) && req.getAttribute("resultmodifyFlag")!=null) {
			try {
				doPost2(req, resp);
				modelAndView = new ModelAndView("saram_finalmodify", false);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return modelAndView;
	}

}
