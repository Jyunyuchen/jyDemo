package com.example.demo.main.vo;

import java.util.List;

import lombok.Data;

@Data
public class LevelMenusVO {

	private Integer id;
	private String name;
	private List<LevelMenusVO> childList;
}
