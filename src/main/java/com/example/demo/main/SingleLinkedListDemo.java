package com.example.demo.main;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "宋江", "及時雨");
		HeroNode hero2 = new HeroNode(2, "盧俊義", "玉麒麟");
		HeroNode hero3 = new HeroNode(4, "吳用", "智多星");
//		HeroNode hero4 = new HeroNode(3, "林沖", "豹子頭");
		
		//加入
		SingleLinedList singleLinedList = new SingleLinedList();
		singleLinedList.add(hero1);
		singleLinedList.add(hero2);
		singleLinedList.add(hero3);
		
		singleLinedList.list();
	}
}

//定義Hero節點
class HeroNode{
	public int no;
	public String name;
	public String nickName;
	public HeroNode next; //指向下一個節點
	
	public HeroNode(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
}

class SingleLinedList{
	private HeroNode head = new HeroNode(0,"","");
	
	//添加節點到單項鏈表
	//思路，當不考慮編號順序時
	//1.找到當前鏈表的最後節點
	//2.將最後這個節點的next指向新的節點
	public void add(HeroNode heroNode) {
		
		//因為head節點不能動，因此我們需要一個輔助變數temp
		HeroNode temp = head;
		//遍歷鏈表，找到最後
		while(true) {
			//找到鏈表的最後
			if(temp.next == null) {
				break;
			}
			//如果沒有找到最後，將temp後移
			temp = temp.next;
		}
		
		//當退出while循環時，temp就指向了鏈表的最後
		//將最後這個節點的next指向新的節點，也就是add節點
		temp.next = heroNode;
	}
	
	//顯示鏈表
	public void list() {
		
		//判斷鏈表是否為空
		if(head.next == null) {
			System.out.println("鏈表為空!!");
			return;
		}
		
		HeroNode temp = head.next;
		while(true) {
			//判斷是否到鏈表最後
			if(temp == null) {
				break;
			}
			//輸出節點的信息
			System.out.println(temp);
			//將next後移
			temp = temp.next;
		}
		
	}

	public HeroNode getHead() {
		return this.head;
	}
}

