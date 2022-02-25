package com.example.demo.main;

import java.util.Comparator;
import java.util.List;

public class RemoveDuplicatesArrayList {

	public static void main(String[] args) {
		List<Author> authors = AuthorAndBookStreamDemo.getAuthors();

		// 排序前
		authors.stream().forEach(author -> System.out.println(author.getId()));

		// 排序
		authors.sort((author1, author2) -> author1.getId().compareTo(author2.getId()));

		System.out.println();

		// 排序後
		authors.stream().forEach(author -> System.out.println(author.getId()));

		System.out.println();

		// 去重
		int i = 0;
		int j = 1;
		while (true) {

			if (j > authors.size() - 1) {
				break;
			}

			Long a1 = authors.get(i).getId();
			Long a2 = authors.get(j).getId();

			if (a1 == a2) {
				authors.remove(j);
			} else {
				i++;
				j++;
			}

		}

		// 去重後
		authors.stream().forEach(author -> System.out.println(author.getId()));

	}

}
