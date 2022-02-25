package com.example.demo.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

public class AuthorAndBookStreamDemo {

	public static void main(String[] args) {

		List<Author> authors = getAuthors();

		// 列印所有年齡小於18的作家名字，並且注意去重

		authors.stream() // 1.把集合轉換成流
				.distinct() // 2.去重
				// 使用lamda可以省略匿名類、實現方法，只用參數+方法主體
				.filter(new Predicate<Author>() {
					@Override
					public boolean test(Author author) {
						return author.getAge() < 18;
					}
				}).forEach(new Consumer<Author>() {
					@Override
					public void accept(Author author) {
						System.out.printf("作家:%s,年齡:%d\n", author.getName(), author.getAge());
					}
				});

		System.out.println();

		authors.stream() // 1.把集合轉換成流
				.distinct() // 2.去重
				// 使用lamda可以省略匿名類、實現方法，只用參數+方法主體
				// 這裡的方法主體即為實作方法
				// 既然傳入實作方法，filter會呼叫Predicate的test方法
				// test根據這裡傳入的方法主體來執行找出年齡小於18的作家
				.filter(author -> author.getAge() < 18)
				.forEach(author -> System.out.printf("作家:%s,年齡:%d\n", author.getName(), author.getAge()));
	}

	public static List<Author> getAuthors() {

		Author author1 = new Author(4L, "蒙多", 33, "一個從菜刀中明悟哲理的祖安人", null);
		Author author2 = new Author(3L, "亞拉索", 15, "狂風也追逐不上他的思考速度", null);
		Author author3 = new Author(1L, "易", 14, "是這個世界在限制他的思維", null);
		Author author4 = new Author(1L, "易", 14, "是這個世界在限制他的思維", null);

		Author author5 = new Author(3L, "易", 14, "是這個世界在限制他的思維", null);
		Author author6 = new Author(3L, "易", 14, "是這個世界在限制他的思維", null);
		Author author7 = new Author(1L, "易", 14, "是這個世界在限制他的思維", null);
		Author author8 = new Author(1L, "易", 14, "是這個世界在限制他的思維", null);

		// 每個作者有多本書
		List<Book> book1 = new ArrayList<>();
		List<Book> book2 = new ArrayList<>();
		List<Book> book3 = new ArrayList<>();

		book1.add(new Book(1L, "刀的兩側是光明與黑暗", "哲學,愛情", 88, "用一把刀劃分了愛恨"));
		book1.add(new Book(2L, "一個人不能死在同一把刀下", "個人成長,愛情", 99, "講述如何從失敗中明悟真理"));

		book2.add(new Book(3L, "那風吹不到的地方", "哲學", 85, "帶你用思維去領略世界的盡頭"));
		book2.add(new Book(3L, "那風吹不到的地方", "哲學", 85, "帶你用思維去領略世界的盡頭"));
		book2.add(new Book(4L, "吹或不吹", "愛情,個人傳記", 56, "一個哲學家的戀愛觀注定很難把他所在的時代理解"));

		book3.add(new Book(5L, "你的劍就是我的劍", "愛情", 56, "無法想像一個武者能對他的伴侶這麼寬容"));
		book3.add(new Book(6L, "風與劍", "個人傳記", 100, "兩個哲學家靈魂和肉體的碰撞會激起怎麼樣的火花呢?"));
		book3.add(new Book(6L, "風與劍", "個人傳記", 100, "兩個哲學家靈魂和肉體的碰撞會激起怎麼樣的火花呢?"));

		author1.setBooks(book1);
		author2.setBooks(book2);
		author3.setBooks(book3);
		author4.setBooks(book3);

		List<Author> authorList = new ArrayList<>(
				Arrays.asList(author1, author2, author3, author4, author5, author6, author7, author8));

		return authorList;
	}

}

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
class Author implements Comparable<Author> {

	private Long id;

	private String name;

	private Integer age;

	// 簡介
	private String intro;

	// 作品
	private List<Book> books;

	@Override
	public int compareTo(Author author) {
		return -(this.getAge() - author.getAge());
	}
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
class Book {

	private Long id;

	private String name;

	// 分類
	private String category;

	// 評分
	private Integer score;

	// 簡介
	private String intro;

}