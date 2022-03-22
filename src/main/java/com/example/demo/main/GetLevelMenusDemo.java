package com.example.demo.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.BeanUtils;

import com.example.demo.main.model.LevelMenu;
import com.example.demo.main.vo.LevelMenusVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetLevelMenusDemo {

	public static void main(String[] args) {

		List<LevelMenu> levelMenus = LevelMenu.gatLevelMenu();

		// 1.先獲取一級菜單
		List<LevelMenusVO> levelOne = levelMenus.stream().filter(levelMenu -> levelMenu.getParentId() == 0)
				.map(levelMenu -> {
					LevelMenusVO lmVO = new LevelMenusVO();
					BeanUtils.copyProperties(levelMenu, lmVO);
					return lmVO;
				}).collect(Collectors.toList());

		
		
		// 2.篩選出非一級菜單
		List<LevelMenu> all = levelMenus.stream().filter(levelMenu -> levelMenu.getParentId() != 0)
				.collect(Collectors.toList());
		
		recursionBuildLevelMenu(levelOne, all);
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(levelOne);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void recursionBuildLevelMenu(List<LevelMenusVO> levelOne, List<LevelMenu> all) {

		List<LevelMenusVO> childList = null;
		List<LevelMenu> pendingRemoveElement = null;
		// 3.獲取子菜單
		for (LevelMenusVO leOne : levelOne) {
			childList = new ArrayList<>();
			pendingRemoveElement = new ArrayList<>(); 
			for (LevelMenu allMenu : all) {
				//System.out.println("leOne.getId() ===> " + leOne.getId());
				//System.out.println("allMenu.getParentId() ===> " + allMenu.getParentId());
				if (leOne.getId().equals(allMenu.getParentId())) {
					LevelMenusVO lmVO = new LevelMenusVO();
					BeanUtils.copyProperties(allMenu, lmVO);
					pendingRemoveElement.add(allMenu);
					childList.add(lmVO);
				}
			}
			all.removeAll(pendingRemoveElement);
			leOne.setChildList(childList);
			if (childList.size() > 0) {
				recursionBuildLevelMenu(childList, all);
			}
		}

		
	}

}
