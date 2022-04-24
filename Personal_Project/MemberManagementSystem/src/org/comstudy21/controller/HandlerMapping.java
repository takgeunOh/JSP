package org.comstudy21.controller;

import java.util.Hashtable;

import org.comstudy21.saramcontroller.DeleteController;
import org.comstudy21.saramcontroller.DetailController;
import org.comstudy21.saramcontroller.InputController;
import org.comstudy21.saramcontroller.ListController;
import org.comstudy21.saramcontroller.RealDetailController;
import org.comstudy21.saramcontroller.SaramController;
import org.comstudy21.saramcontroller.ModifyController;

public class HandlerMapping {
	Hashtable<String, SaramController> map = new Hashtable<String, SaramController>();
	public HandlerMapping() 
	{
		map.put("/list", new ListController());
		map.put("/input", new InputController());
		map.put("/predetail", new DetailController());
		map.put("/detail", new RealDetailController());
		map.put("/modify", new ModifyController());
		map.put("/resultmodify", new ModifyController());
		map.put("/predelete", new DeleteController());
		map.put("/delete", new DeleteController());
	}
	
	public SaramController getController(String path) {
		return map.get(path);
	}
}
