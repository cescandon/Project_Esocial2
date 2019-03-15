package com.esocial.web_util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class StylesController {
	
	@RequestMapping(value = "/css/main", method = RequestMethod.GET)
	public String mainCSS() {
		return "/WEB-INF/views/css/main_css.jsp";
	}
	
	@RequestMapping(value = "/css/cards", method = RequestMethod.GET)
	public String formsCSS() {
		return "/WEB-INF/views/css/cards_css.jsp";
	}
	
	@RequestMapping(value = "/css/forms", method = RequestMethod.GET)
	public String cardCSS() {
		
		return "/WEB-INF/views/css/forms_css.jsp";
	}

	@RequestMapping(value = "/css/tasks", method = RequestMethod.GET)
	public String signInCSS() {
		
		return "/WEB-INF/views/css/tasklist_css.jsp";
	}
	


}

//with the configuration we dont need prefix anymore "/WEB-INF/views/login.jsp"