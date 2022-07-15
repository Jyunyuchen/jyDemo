package com.example.demo;

import java.util.Date;
import java.util.Optional;

import javax.persistence.FetchType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Article;
import com.example.demo.Entity.Type;
import com.example.demo.Repository.ArticleRepository;

@SpringBootTest
public class ManyToManyTest {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Test
	void test01() {
		
		//建立兩篇文章
		Article article01 = new Article();
		article01.setAutohr("王小明");
		article01.setTitle("JAVA");
		article01.setCreateTime(new Date());
		
		Article article02 = new Article();
		article02.setAutohr("林小華");
		article02.setTitle("PHP");
		article02.setCreateTime(new Date());
		
		//建立兩個文章分類
		Type type01 = new Type();
		type01.setName("程式設計");
		
		Type type02 = new Type();
		type02.setName("小說");
		
		
		//建立關聯關係
		
		//兩篇文章各有兩個分類
		article01.getTypes().add(type01);
		article01.getTypes().add(type02);
		article02.getTypes().add(type01);
		article02.getTypes().add(type02);
		
		// 兩個分類各有兩篇文章
		type01.getArticles().add(article01);
		type01.getArticles().add(article02);
		type02.getArticles().add(article01);
		type02.getArticles().add(article02);
		
		
		articleRepository.save(article01);
		articleRepository.save(article02);
	}
	
	/**
	 * 根據文章ID級聯查詢
	 */
	@Test
	void test02() {
		
		Optional<Article> optionalArticle = articleRepository.findById(2);
		System.out.println("文章信息====>" + optionalArticle.get() + "\n");
		/*
		 * 要級聯獲取type資料的話，
		 * 需要在Article類別中的types加上「fetch = FetchType.EAGER」，
		 * 這樣Hibernate就會發join語句一次連分類信息一同獲取出來，
		 * 沒加的話，Hibernate只會select article這張表
		 */
		System.out.println("分類信息====>" + optionalArticle.get().getTypes() + "\n");
		
	}

}
