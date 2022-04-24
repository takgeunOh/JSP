package org.comstudy21.saramcontroller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.controller.ModelAndView;
import org.comstudy21.model.MemberDto;

public class ListController extends SaramController {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		// 겟방식으로 요청할 때 리스트를 보낼 것.
		ArrayList<MemberDto> saramList = saramDao.selectAll();
		req.setAttribute("saramList", saramList);
		// 이 속성이름은 뷰네임으로 쓰일 것.
		// 속성이름을 가져왔을 때 값으로 리스트를 반환
	}
	
	@Override
	public ModelAndView request(HttpServletRequest req, HttpServletResponse resp) {
		// 조회할 때는 Get 방식으로
		doGet(req, resp);
		
		return new ModelAndView("saram_list", false);
	}

}
