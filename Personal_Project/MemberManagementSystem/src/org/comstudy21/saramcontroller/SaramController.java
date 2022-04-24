package org.comstudy21.saramcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.controller.ModelAndView;
import org.comstudy21.controller.ViewResolver;
import org.comstudy21.model.MemberDao;

public abstract class SaramController {
	// 얘가 하는 역할은 어댑터 역할을 할 것.
	// 추상으로 만들어서 HandlerMapping에서 찾은 컨트롤러를 직접적으로 호출할 것.
	protected MemberDao saramDao = new MemberDao();
	protected ViewResolver viewResolver = new ViewResolver();
	public abstract ModelAndView request(HttpServletRequest req, HttpServletResponse resp);
}
