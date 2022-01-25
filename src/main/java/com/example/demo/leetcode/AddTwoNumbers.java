package com.example.demo.leetcode;

public class AddTwoNumbers {

	public static void main(String[] args) {

		/*
		 * ListNode l1 = new ListNode(2); ListNode l2 = new ListNode(4); ListNode l3 =
		 * new ListNode(3); SingleLinedList singleLinedList1 = new SingleLinedList();
		 * singleLinedList1.add(l1); singleLinedList1.add(l2); singleLinedList1.add(l3);
		 * singleLinedList1.listListNode();
		 * 
		 * ListNode ll1 = new ListNode(5); ListNode ll2 = new ListNode(6); ListNode ll3
		 * = new ListNode(4); SingleLinedList singleLinedList2 = new SingleLinedList();
		 * singleLinedList2.add(ll1); singleLinedList2.add(ll2);
		 * singleLinedList2.add(ll3);
		 * 
		 * singleLinedList2.listListNode();
		 */

		// [9,9,9,9,9,9,9]
		// [9,9,9,9]

//		ListNode listNode2 = new ListNode(4);
//		ListNode listNode1 = new ListNode(6, listNode2);
//		ListNode l2 = new ListNode(5, listNode1);

//		ListNode listNode6 = new ListNode(9);
//		ListNode listNode5 = new ListNode(9, listNode6);
//		ListNode listNode4 = new ListNode(9, listNode5);
//		ListNode listNode3 = new ListNode(9, listNode4);
		ListNode listNode2 = new ListNode(9);
		ListNode listNode1 = new ListNode(9, listNode2);
		ListNode l2 = new ListNode(9, listNode1);
		l2.listListNode(l2);

		System.out.println();

//		ListNode listNode4 = new ListNode(3);
//		ListNode listNode3 = new ListNode(4, listNode4);
//		ListNode l1 = new ListNode(2, listNode3);

//		ListNode listNodee3 = new ListNode(9);
//		ListNode listNodee2 = new ListNode(9, listNodee3);
		ListNode listNodee1 = new ListNode(9);
		ListNode l1 = new ListNode(9, listNodee1);
		l1.listListNode(l1);

		System.out.println();

		l1.listListNode(addTwoNumbers(l1, l2));

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode ans = new ListNode();
		ListNode listNodeTemp = ans;
		ListNode temp01 = l1;
		ListNode temp02 = l2;

		// l1 = [6,4,3]
		// l2 = [5,6,4]
		// ans = [1,1,8]

		int carry = 0;
		int addUp = 0;
		int remainder = 0;
		boolean tempFlag01 = false;
		boolean tempFlag02 = false;
		while (true) {

			if (temp01 == null && temp02 == null && carry == 0) {
				break;
			}

			if (carry > 0) {
				if (temp01 != null && temp02 != null) {
					addUp = temp01.val + temp02.val + carry;
					carry = 0;
				} else if (temp01 != null && temp02 == null) {
					addUp = temp01.val + 0 + carry;
					carry = 0;
				} else if (temp01 == null && temp02 != null) {
					addUp = 0 + temp02.val + carry;
					carry = 0;
				} else {
					addUp = carry;
					carry = 0;
				}

			} else {
				if (temp01 != null && temp02 != null) {
					addUp = temp01.val + temp02.val;
				} else if (temp01 != null && temp02 == null) {
					addUp = temp01.val + 0;
				} else {
					addUp = 0 + temp02.val;
				}
			}

			if (addUp >= 10) {

				carry = addUp / 10;
				remainder = addUp % 10;
				listNodeTemp.val = remainder;

				if (temp01 != null) {
					if (temp01.next != null || carry > 0) {
						tempFlag01 = true;
						listNodeTemp.next = new ListNode();
						listNodeTemp = listNodeTemp.next;
					}
				}

				if (temp02 != null) {
					if (temp02.next != null || carry > 0) {
						if (!tempFlag01) {
							listNodeTemp.next = new ListNode();
							listNodeTemp = listNodeTemp.next;
						}
					}
				}

			} else {
				listNodeTemp.val = addUp;

				if (temp01 != null) {
					if (temp01.next != null) {
						tempFlag01 = true;
						listNodeTemp.next = new ListNode();
						listNodeTemp = listNodeTemp.next;
					}
				}

				if (temp02 != null) {
					if (temp02.next != null) {
						if (!tempFlag01) {
							listNodeTemp.next = new ListNode();
							listNodeTemp = listNodeTemp.next;
						}
					}
				}
			}

			if (temp01 != null) {
				temp01 = temp01.next;
			}

			if (temp02 != null) {
				temp02 = temp02.next;
			}
			
			tempFlag01 = false;
		}

		return ans;

	}

}

class ListNode {
	int val;
	ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + "]";
	}
	
	public void add(ListNode headNode, ListNode listNode) {

		// 因為head節點不能動，因此我們需要一個輔助變數temp
		ListNode dummyNode = headNode;

		// 遍歷鏈表，找到最後
		while (true) {
			// 找到鏈表的最後
			if (dummyNode.next == null) {
				break;
			}
			// 如果沒有找到最後，將temp後移
			dummyNode = dummyNode.next;
		}

		// 當退出while循環時，temp就指向了鏈表的最後
		// 將最後這個節點的next指向新的節點，也就是add節點
		dummyNode.next = listNode;

	}// end add

	public void listListNode(ListNode head) {

		// 判斷鏈表是否為空
		if (head.next == null) {
			System.out.println("鏈表為空!!");
			return;
		}

		// 因為head節點不能動，因此我們需要一個輔助變數temp
		ListNode temp = head;

		while (true) {

			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
}

class SingleLinedList {
	private ListNode head = new ListNode(0);

	public void add(ListNode listNode) {

		// 因為head節點不能動，因此我們需要一個輔助變數temp
		ListNode temp = head;

		// 遍歷鏈表，找到最後
		while (true) {
			// 找到鏈表的最後
			if (temp.next == null) {
				break;
			}
			// 如果沒有找到最後，將temp後移
			temp = temp.next;
		}

		// 當退出while循環時，temp就指向了鏈表的最後
		// 將最後這個節點的next指向新的節點，也就是add節點
		temp.next = listNode;

	}// end add

	public void listListNode() {

		// 判斷鏈表是否為空
		if (head.next == null) {
			System.out.println("鏈表為空!!");
			return;
		}

		// 因為head節點不能動，因此我們需要一個輔助變數temp
		ListNode temp = head;

		while (true) {

			if (temp.next == null) {
				break;
			}

			temp = temp.next;

			System.out.println(temp);
		}

	}// end listListNode

}// end class SingleLinedList
