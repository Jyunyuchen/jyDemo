package com.example.demo.main;

public class StringDemo {

	public static void main(String[] args) {
		practise01();
	}

	private static void practise01() {
		 String Str = new String("www.runoob.com");
		 //o最後出現的位置
	     System.out.println(Str.lastIndexOf( "o" ));
	     
	     //從2的位置開始擷取，最後擷取出happy
	     String s = "unhappy";
	     System.out.println(s.substring(2));
	     
	     String fileName = "xxx.pdf";
	     System.out.println(fileName.lastIndexOf("."));
	     /*
	      * 如何擷取出副檔名?
	      * 使用lastIndexOf發現「.」在3的位置，
	      * 再使用substring從3開始擷取(包含3這個位置)，
	      * 最後擷取出「.pdf」
	      * 
	      */
	     System.out.println(fileName.substring(fileName.lastIndexOf(".")));
		
	}

	
}
