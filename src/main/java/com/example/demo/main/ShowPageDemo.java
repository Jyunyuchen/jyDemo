package com.example.demo.main;

import java.util.ArrayList;
import java.util.List;

public class ShowPageDemo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Integer currPage = 8;
		list.add(currPage);

		for (int i = 1; i <= 3; i++) {
			if (currPage - i > 0) {
				list.add(0, currPage - i);
			}
			list.add(currPage + i);
		}

		System.out.println(list);
	}

}
