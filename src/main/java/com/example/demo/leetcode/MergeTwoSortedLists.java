package com.example.demo.leetcode;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		
		ListNode listNode2 = new ListNode(4);
		ListNode listNode1 = new ListNode(2, listNode2);
		ListNode l1 = new ListNode(1, listNode1);
		l1.listListNode(l1);

		System.out.println();

		// ListNode listNode5 = new ListNode(5);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode3 = new ListNode(3, listNode4);
		ListNode l2 = new ListNode(1, listNode3);
		l2.listListNode(l2);

		System.out.println();
		
		
		//ListNode l1 = new ListNode();
		//ListNode l2 = new ListNode();

		l1.listListNode(mergeTwoLists(l1, l2));

	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		
		ListNode head = new ListNode(-1);
		ListNode dummy = head;

		while (true) {
			
			if (list1 == null && list2 == null) {
				break;
			} else if (list1 == null && list2 != null) {
				dummy.next = list2;
				break;
			} else if (list1 != null && list2 == null) {
				dummy.next = list1;
				break;
			}
			
			if (list1.val < list2.val) {
				dummy.next = new ListNode(list1.val);
				list1 = list1.next;
			} else if (list2.val < list1.val) {
				dummy.next = new ListNode(list2.val);
				list2 = list2.next;
			} else if (list2.val == list1.val) {
				dummy.next = new ListNode(list1.val);
				dummy = dummy.next;
				dummy.next = new ListNode(list2.val);
				list1 = list1.next;
				list2 = list2.next;
			}

			dummy = dummy.next;

		}

		return head.next;

	}

}
