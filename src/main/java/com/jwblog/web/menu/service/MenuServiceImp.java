package com.jwblog.web.menu.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jwblog.web.menu.dao.MenuDAO;
import com.jwblog.web.menu.model.MenuVO;

@Service
public class MenuServiceImp implements MenuService {
	@Inject 
	private MenuDAO menuDAO;
	
	@Override public List<MenuVO> getMenuList() throws Exception { 
		return menuDAO.getMenuList(); 
		} 
	@Override public void saveMenu(MenuVO menuVO) throws Exception { 
		menuDAO.saveMenu(menuVO); 
		} 
	@Override public void updateMenu(MenuVO menuVO) throws Exception { 
		menuDAO.updateMenu(menuVO); 
		} 
	@Override public void deleteMenu(String code) throws Exception { 
		menuDAO.deleteMenu(code); 
		}
}
