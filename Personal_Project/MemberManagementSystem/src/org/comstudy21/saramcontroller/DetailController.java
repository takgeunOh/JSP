package org.comstudy21.saramcontroller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.controller.ModelAndView;
import org.comstudy21.model.MemberDto;

public class DetailController extends SaramController{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		//String no_str = req.getParameter("no");
		//SaramDto detail_dto = saramDao.selectByNo(no_str);
		ArrayList<MemberDto> preDetail_list = saramDao.selectAll();
		//req.setAttribute("detail_dto", detail_dto);			// 이제 이거는 jsp에서 써먹을 것.
		req.setAttribute("all_dto", preDetail_list);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {

		ModelAndView modelAndView = new ModelAndView("saram_list", true);
		// 처음 검색할 때 사람리스트로 이동하면서 redirect 여부는 true. (왜냐면 리스트는 항상 갱신되어야하니까?)
		// 검색버튼을 눌렀을 때에는 POST 방식으로 페이지 넘어가면서 saram_detail로 가게 하고
		// redirect 여부는 false
		
		System.out.println("DetailController GET 방식 여부 : " + req.getMethod());
		if("GET".equals(req.getMethod())) {
			doGet(req, resp);
			modelAndView = new ModelAndView("saram_predetail", false);
		} else {
			doPost(req, resp);
			modelAndView = new ModelAndView("saram_detail", false);
		}
		return modelAndView;
	}

}
