package com.example.demo.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		//practise01();
		practise02();
	}

	/**
	 * 使用EntrySet獲取key與value
	 */
	private static void practise02() {
		Map<String, Integer> map = new HashMap<>();
		map.put("王小明", 185);
		map.put("林小華", 175);
		map.put("趙小李", 190);
		
		//把map中的Entry(key-value對)保存在set中
		Set<Entry<String, Integer>> set = map.entrySet();
		for (Entry<String, Integer> entry : set) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("key=" + key + " : " + "value=" + value);
		}
	}

	/**
	 * 透過key獲取value
	 *  
	 */
	private static void practise01() {
		Map<String, Integer> map = new HashMap<>();
		map.put("王小明", 185);
		map.put("林小華", 175);
		map.put("趙小李", 190);
		
		//key保存在set裡面
		Set<String> set = map.keySet();
		for (String key : set) {
			System.out.println("key=" + key + " : " + "value=" + map.get(key));
		}
		
	}
	
	

}
