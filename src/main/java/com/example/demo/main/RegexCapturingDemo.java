package com.example.demo.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCapturingDemo {

	public static void main(String[] args) {
		
		/*
		 * 是否匹配給定的字串
		 */
		String email = "johannisber@gmail.com";
		
		Pattern pattern = Pattern.compile("\\w{1,}@\\w{1,}(.\\w{1,}){1,2}");
		Matcher matcher = pattern.matcher(email);
		System.out.println("是否有匹配到?" + matcher.matches());
		
		
		/*
		 * 抓取匹配到的字串
		 */
		pattern = Pattern.compile("\\w{1,}");
		matcher = pattern.matcher(email);
		while (matcher.find()) {
		  System.out.println(matcher.group(0));
		}
		
		/*
		 * 加上「\\G」表示要分組
		 * 括號起來的的相同位置為一個group
		 * 例如 name1 跟 name2 為一個group
		 * gil 跟 orit 為一個group
		 */
		String line = "name1=gil;name2=orit;";
		Pattern p = Pattern.compile("\\G(\\w+)=(\\w+);");
		Matcher m = p.matcher(line);
		while (m.find()) {
		   //System.out.println(m.group(0));
		   //System.out.println(m.group(2));
		}

	}

}
