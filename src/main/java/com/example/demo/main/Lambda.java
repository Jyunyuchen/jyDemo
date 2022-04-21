package com.example.demo.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.el.TypeConverter;

import org.apache.xmlbeans.impl.xb.xmlconfig.NamespaceList.Member2.Item;
import org.aspectj.weaver.loadtime.Agent;

import com.fasterxml.jackson.core.sym.Name;

import ch.qos.logback.core.status.Status;
import net.bytebuddy.asm.Advice.Return;

public class Lambda {

	public static void main(String[] args) {

//		printNum(new IntPredicate() {
//			@Override
//			public boolean test(int value) {
//				return value % 2 == 0;
//			}
//		});

//		printNum(value->value % 2 == 0);

//		IntPredicate predicate = value -> value % 2 == 0;
//		printNum(predicate);

//------------------------------------------------------------
//		Integer num = typeConver(new Function<String, Integer>() {
//			@Override
//			public Integer apply(String str) {
//				return Integer.valueOf(str);
//			}
//		});
//		System.out.println(num+1);
//		
		//Integer num = typeConver(str -> Integer.valueOf(str));
		//System.out.println(num + 1);

//------------------------------------------------------------
		// List集合使用Stream
		listStream();

//------------------------------------------------------------		
		// array使用Stream
		//arrayStream();
		
//----------------------------------------------------------------
		// Map使用Stream
		//mapStream();

	} //end main
	
	
	/*
	 * List集合使用Stream
	 */
	public static void listStream() {
		List<Author> authors = AuthorAndBookStreamDemo.getAuthors();
		Stream<Author> stream = authors.stream();
		
		//印出作家名稱長度大於1的作家
//		authors.stream()
//		       .filter(author -> author.getName().length()>1)
//		       .forEach(author -> System.out.println(author.getName()));
		
		// map 將stream中的原本型態都轉換成另一個型態的集合
//		authors.stream()
//			    .map(new Function<Author, String>() {
//				@Override
//				public String apply(Author author) {
//					return author.getName();
//				}
//			}).forEach(System.out::println);
		
		// map 將stream中的原本型態都轉換成另一個型態的集合
		// lamda寫法
//		authors.stream()
//			   .map(author -> author.getName())
//			   .forEach(System.out::println);
//		
		
		
		// map 將stream中的原本型態都轉換成另一個型態的集合
		// lamda寫法
		// 收集成list
//		List<String> authorName = authors.stream()
//									  .map(author -> author.getName())
//									  .collect(Collectors.toList());
//		authorName.stream().forEach(System.out::println);
		
		
		// 將author中的年齡用map轉化出來，再用map把各個年齡+10
//		authors.stream()
//			   .map(author -> author.getAge())
//			   .map(age -> age +=10 )
//			   .forEach(System.out::println);
		
		// 去除重複，要先覆寫Equals方法，
		// 讓兩個author中各個屬性內容都相同，判定該兩個author物件為相同
//		authors.stream()
//			   .distinct()
//			   .forEach(System.out::println);
		
		
		
		// 排序-----根據作家的年齡，大到小
		// 讓author類實現Comparable介面
		// 然後才可以呼叫stream中的sorted的空參數方法進行排序
//		authors.stream()
//		       .sorted()
//		       .map(author -> author.getAge())
//		       .forEach(System.out::println);
		
		// 排序-----根據作家的年齡，大到小
		// 不實現Comparable介面
		// 呼叫stream中的sorted的有參數方法進行排序
//		authors.stream()
//		       .sorted((author1,author2) -> 
//		       			-(author1.getAge().compareTo(author2.getAge()))
//    		   ).map(author -> author.getAge())
//		       .forEach(System.out::println);
		
		
		
		// limit
		// 只列印前2位作家名稱
//		authors.stream()
//		       .limit(2)
//		       .map(author -> author.getName())
//		       .forEach(System.out::println);

		
		
		// skip
		// 跳過前兩位作家
//		authors.stream()
//		       .skip(2)
//		       .map(author -> author.getName())
//		       .forEach(System.out::println);
		
		
		
		// flatMap
		// 可以把一個物件轉換成多個物件作為流中的元素
		// 可將List中的List轉出來
//		authors.stream()
//				//將List作者中的List書中的每本書拿取出來
//		       .flatMap(author -> {
//		    	   		if(author.getBooks() != null)
//		    	   			return author.getBooks().stream();
//		    	   		else 
//							return Stream.empty();
//		       })
//		       .forEach(book -> System.out.println(book.getName()));
		
		
		// flatMap
		// 可以把一個物件轉換成多個物件作為流中的元素
		// 可將List中的List轉出來
		// 看看返回的Stream.empty()是不是會多一本書
		// 答案:不會多一本書
//		List<Book> allAuthorsBooks = authors.stream()
//				//將List作者中的List書中的每本書拿取出來
//			   .flatMap(author -> {
//				   		if(author.getBooks() != null)
//				   			return author.getBooks().stream();
//				   		else 
//							return Stream.empty();
//			   }).collect(Collectors.toList());
//		System.out.println(allAuthorsBooks.size());
//		
		
		
		
		// flatMap
		// 可以把一個物件轉換成多個物件作為流中的元素
		// 可將List中的List轉出來
		// 若原author.getBooks()中為null
		// 接著實際返回一個List<Book>是不是會多書
		// 答案:會多書
//		List<Book> allAuthorsBooks = authors.stream()
//				//將List作者中的List書中的每本書拿取出來
//			   .flatMap(author -> {
//				   		if(author.getBooks() != null) {
//				   			return author.getBooks().stream();
//				   		}
//				   		else {
//				   			List<Book> books = new ArrayList<>();
//				   			books.add(new Book(12L, "這是新的一本書", "無", 100, "無"));
//							return books.stream();
//				   		}
//			   }).collect(Collectors.toList());
//		System.out.println(allAuthorsBooks.size());
		
		
		/*
		 * 1.取的所有作者的資料(裏頭包括作者的書籍資料)
		 * 2.使用flatMap(傳入匿名內部類)，
		 *   將各個作者的書從list轉出來成一本一本書
		 * 3.去除重複的書
		 * 4.使用flatMap，將各個書的分類轉出來，
		 *   因為分類使用逗號隔開的，用split會回傳陣列，
		 *   必須將陣列中的分類給轉出來(stream)，所以再次用flatMap
		 * 5.去除重複的書
		 * 6.列印出來
		 */
		authors.stream()
			   .flatMap(new Function<Author, Stream<Book>>() {
				@Override
				public Stream<Book> apply(Author author) {
					
					return author.getBooks() != null ? author.getBooks().stream() : Stream.empty(); 
				}
			   })
			   .distinct()
			   .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
			   .distinct()
			   .forEach(category -> System.out.println(category));
	

	}
	
	/*
	 * array使用Stream
	 */
	public static void arrayStream() {
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		//創建stream的兩種方法
//		Stream<Integer> stream2 = Arrays.stream(arr);
//		Stream<Integer> streamOf = Stream.of(arr);
		
		// filter 過濾元素
		Arrays.stream(arr)
		      .filter(item -> item%2==0)
		      .forEach(System.out::println);
	}
	
	/*
	 * Map使用Stream
	 */
	public static void mapStream() {
		Map<String, Integer> map = new HashMap<>();
		map.put("王小明", 185);
		map.put("林小華", 175);
		map.put("趙小李", 190);

		map.entrySet().stream()
		              .forEach(entry -> {
			                   System.out.println("key=" + entry.getKey() + " : " + "value=" + entry.getValue());
		});

	}

	public static void printNum(IntPredicate predicate) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Arrays.stream(arr).forEach(i -> {
			if (predicate.test(i)) {
				System.out.println(i);
			}
		});
	}

	public static <R> R typeConver(Function<String, R> funtion) {
		String str = "123456";
		R result = funtion.apply(str);
		return result;
	}

}
