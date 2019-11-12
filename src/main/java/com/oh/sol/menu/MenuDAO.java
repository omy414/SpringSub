package com.oh.sol.menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuDAO {
	@Autowired
	private SqlSession ss;
	
	public void getMenu(HttpServletRequest req) {
		List<Menu> menus = ss.getMapper(MenuMapper.class).getMenu(); //객체에 넣어서 처리
		
		req.setAttribute("menus", menus);
		
		//그 사이트 내에서만 사용가능
		//req.attribute
		//req.session.attribute
		//cookie
		
		//DB에 있는 데이터를 외부에서 쓰게 해주려면?
		//AJAX서버
	}
	
	public Menus getMenuXML() {
		List<Menu> menus = ss.getMapper(MenuMapper.class).getMenu(); //객체에 넣어서 처리
		
		return new Menus(menus);
	}
}
