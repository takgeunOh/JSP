package org.comstudy21.saramcontroller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.controller.ModelAndView;
import org.comstudy21.model.MemberDao;
import org.comstudy21.model.MemberDto;

public class DeleteController extends SaramController {
	// 삭제페이지 최초 진입 시 GET 방식으로 진입하고
	// 삭제할 번호 입력한 후 POST 방식으로 삭제페이지 재진입해서 삭제 후 list로 진입
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		list = saramDao.selectAll();
		
		req.setAttribute("deletelist", list);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		// 여기서 실질적인 삭제가 이루어질 것.
		// 삭제번호 넣기
		saramDao.delete(req.getParameter("no"));
	}
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("DeleteController에서의 접근 방식 : " + req.getMethod());
		
		if("GET".equals(req.getMethod())) {
			doGet(req, resp);
			modelAndView = new ModelAndView("saram_predelete", false);
		} else {
			doPost(req, resp);
			modelAndView = new ModelAndView("saram_delete", false);
		}
		
		return modelAndView;
	}

}
