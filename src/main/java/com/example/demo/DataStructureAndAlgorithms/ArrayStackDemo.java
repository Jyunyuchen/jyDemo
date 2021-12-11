package com.example.demo.DataStructureAndAlgorithms;

public class ArrayStackDemo {

	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(10);
		arrayStack.push(1);
		arrayStack.push(2);
		arrayStack.push(3);
		arrayStack.listStack();
	}

}

class ArrayStack {

	/*
	 * 堆疊的大小
	 */
	private int maxSize;

	/*
	 * 使用陣列模擬堆疊，資料就放在此陣列中
	 */
	private int[] stack;

	/*
	 * top代表堆疊的頂端，初始化為-1 假如堆疊中有5筆資料，則top為4(0~4) 4即為此堆疊的頂端
	 */
	private int top = -1;

	/*
	 * 建構子 用傳入的mzxSize初始化模擬堆疊的陣列
	 */
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		this.stack = new int[this.maxSize];
	}

	/*
	 * 判斷堆疊是否已滿
	 * 
	 */
	public boolean isFull() {
		return top == maxSize;
	}

	/*
	 * 判斷堆疊是否為空
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/*
	 * 向堆疊加入資料
	 */
	public void push(int value) {

		// 先判斷是否有空間可以加入資料
		if (isFull()) {
			System.out.println("================堆疊已滿================");
			return;
		}

		// 往上指向陣列的一個空間，好讓資料加入在此空間
		top++;

		// 加入資料
		stack[top] = value;
	}

	/*
	 * 從堆疊拿出資料
	 */
	public int pop() {

		// 先判斷堆疊是否為空，空的話就無法拿資料了
		if (isEmpty()) {
			System.out.println("================堆疊已空================");
			throw new RuntimeException("================堆疊已空================");
		}

		// 取出資料
		int value = stack[top];

		// top往下一格，資料被拿出，讓出空間
		top--;

		// 返回資料
		return value;

	}

	/*
	 * 顯示堆疊裡的資料
	 */
	public void listStack() {

		// 先判斷堆疊是否為空，空的話就無法顯示資料了
		if (isEmpty()) {
			System.out.println("================堆疊已空================");
			return;
		}

		/*
		 * 堆疊須由上而下顯示資料
		 */
		for (int i = top; i >= 0; i--) {
			System.out.printf("Stack[%d]=%d\n", i, stack[i]);
		}
	}

}