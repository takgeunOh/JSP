package org.comstudy21.controller;

public class ModelAndView {
	// 모델앤뷰에서는 뷰이름과 다이렉트 여부 정보를 저장할 것.
	// 실행 초기에는 리스트를 먼저 보여줄거니까 디폴트로는 리스트에 맞춰주자.
	private String viewName = "list";
	private boolean isRedirect = false;
	
	public ModelAndView() {
		this("/list", false);
	}

	public ModelAndView(String viewName, boolean isRedirect) {
		this.viewName = viewName;
		this.isRedirect = isRedirect;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
	
}
