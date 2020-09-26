package com.jwblog.web.menu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwblog.web.menu.model.MenuVO;
import com.jwblog.web.menu.service.MenuService;

@RestController
@RequestMapping(value = "/restMenu")
public class RestMenuController {

	private static final Logger logger = LoggerFactory.getLogger(RestMenuController.class);
	
	@Inject
	private MenuService menuService;
	
	@RequestMapping(value = "/getMenuList", method = RequestMethod.POST)
	public Map<String, Object> getMenuList(Model model) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			result.put("menuList", menuService.getMenuList());
			result.put("status", "OK");
		} catch (Exception e) {
			// TODO: handle exception
			result.put("status", "False");
			logger.info(e.getMessage());
		}
		
		return result;
	}
	
	@RequestMapping(value = "/saveMenu", method = RequestMethod.POST)
	public Map<String, Object> saveMenu(MenuVO menuVO) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			menuService.saveMenu(menuVO);
			result.put("status", "OK");
		} catch (Exception e) {
			// TODO: handle exception
			result.put("status", "False");
			logger.info(e.getMessage());
		}
		
		return result;
	}
	
	@RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
	public Map<String, Object> updateMenu(MenuVO menuVO) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			menuService.updateMenu(menuVO);
			result.put("status", "OK");
		} catch (Exception e) {
			// TODO: handle exception
			result.put("status", "False");
			logger.info(e.getMessage());
		}
		
		return result;
		
	}
	@RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
	public Map<String, Object> deleteMenu(@RequestParam("code") String code) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			menuService.deleteMenu(code);
			result.put("status", "OK");
		} catch (Exception e) {
			// TODO: handle exception
			result.put("status", "False");
			logger.info(e.getMessage());
		}
		
		return result;
	}
}
