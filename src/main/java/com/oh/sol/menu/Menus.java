package com.oh.sol.menu;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//테이블을 표현해줄 객체
//@XmlRootElement
public class Menus {
	private List<Menu> menu;
	
	public Menus() {
		// TODO Auto-generated constructor stub
	}

	public List<Menu> getMenu() {
		return menu;
	}
	
	//@XmlElement
	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "Menus [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public Menus(List<Menu> menu) {
		super();
		this.menu = menu;
	}
	
}
