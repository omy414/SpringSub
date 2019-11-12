package com.oh.sol;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oh.sol.menu.MenuDAO;
import com.oh.sol.menu.Menus;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MenuDAO mDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest req) {
		mDAO.getMenu(req);
		
		return "index";
	}
	
	//produces 는 안써도되긴하는데 안되는 자리도있어서 써야함 받아서 xml로 보낸다 라는 것
	@RequestMapping(value = "/menu.get", method = RequestMethod.GET, produces = "application/xml; charset=utf-8")
	public @ResponseBody Menus menuGet() { //Menus 를 응답한단 소리
		
		return mDAO.getMenuXML();
	}
	
}
