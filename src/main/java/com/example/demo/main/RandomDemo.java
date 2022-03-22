package com.example.demo.main;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		Random random = new Random();
		
		//隨機生成0~9的數字
		int randomInt01 = random.nextInt(10);
		
		//隨機生成1~10的數字
		int randomInt02 = random.nextInt(10) + 1;
		
		//如何生成34到179的隨機數?
		//nextInt中的bound用來控制生成數字的範圍
		//填入10就是生成0~9
		//填入179-34=145就是生成0~144
		//要生成34到179的隨機數只要145+1(0~145)再+34
		
		//生成34到179的隨機數
		int randomInt03 = random.nextInt(179-34+1) + 34;

	}

}
