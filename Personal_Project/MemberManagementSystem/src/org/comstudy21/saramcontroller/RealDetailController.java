package org.comstudy21.saramcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.controller.ModelAndView;
import org.comstudy21.model.MemberDto;

public class RealDetailController extends SaramController{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		String no_str = req.getParameter("no");
		MemberDto detail_dto = saramDao.selectByNo(no_str);
		req.setAttribute("detail_dto", detail_dto);			// 이제 이거는 jsp에서 써먹을 것.
	}
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView modelAndView = new ModelAndView("saram_detail", false);
		
		doGet(req, resp);
		
		return modelAndView;
	}

}
