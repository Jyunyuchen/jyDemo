package com.example.demo.main;

import java.io.File;

public class RecursiveFileDemo {

	public static final String BASE_PATH = "C:\\Users\\jy\\eclipse202109\\demo\\file";

	private static String appendDir = "";

	public static void main(String[] args) {

		appendDir = BASE_PATH;
		recursiveFile(appendDir);
	}

	public static void recursiveFile(String dirName) {
//		System.out.println(dirName);
		File rootDir = new File(dirName);
		String[] names = rootDir.list();
	
		/*
		 * 如果names的length等於0則表示遍歷到該層的最後了
		 */
		if(names != null && names.length == 0) {
			System.out.println("===========沒有資料夾了===========");
		}

		/*
		 * 如果null則表示已遍歷到最後了(沒有下一個資料夾了) 
		 * 就從根路徑開始遍歷下一個資料夾
		 */
		if (names == null) {
			dirName = dirName.substring(dirName.lastIndexOf("\\"));
			dirName = BASE_PATH + dirName;
			System.out.println("names is null, dirName==> " + dirName);
			rootDir = new File(dirName);
			names = rootDir.list();
		}

		if (names != null && names.length > 0) {
			System.out.println(dirName);
			for (String name : names) {
				System.out.println("資料夾==> " + name);
				appendDir += "\\" + name;
				System.out.println("==> " + appendDir);
				recursiveFile(appendDir);
			}
		}
	}

}
