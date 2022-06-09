package com.example.demo.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		//practise01();
		//practise02();
		//practise03();
		practise04();
	}

	/**
	 * 取一個不存在的key會發生什麼事
	 */
	private static void practise04() {
		Map<String, String> map = new HashMap<>();
		map.put("TestKey","TestValue");
		String dwqdwq = map.get("dwqdwq");
		System.out.println(dwqdwq);
	}

	/*
	 * 計算一個字串中各有幾個字元
	 */
	private static void practise03() {
		String  str = "aaabbbbccac";
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if(map.containsKey(c)) {
				//如果有重複的字元，取出value將value+1
				Integer value = map.get(c);
				map.put(c, ++value);
			}
			else {
				map.put(c, 1);
			}
		}
		
		//key保存在set裡面
		Set<Character> set = map.keySet();
		for (Character key : set) {
			System.out.println("key=" + key + " : " + "value=" + map.get(key));
		}
		
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
