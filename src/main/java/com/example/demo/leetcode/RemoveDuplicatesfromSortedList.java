package com.example.demo.leetcode;

/**
 * 83. Remove Duplicates from Sorted List
 * 
 * @author jy
 *
 */
public class RemoveDuplicatesfromSortedList {

	public static void main(String[] args) {

		ListNode headNode = new ListNode(1);
		headNode.add(headNode, new ListNode(1));
		headNode.add(headNode, new ListNode(2));
		headNode.add(headNode, new ListNode(2));
		headNode.add(headNode, new ListNode(3));
		headNode.add(headNode, new ListNode(3));
		headNode.add(headNode, new ListNode(4));
		headNode.add(headNode, new ListNode(4));

		headNode.listListNode(headNode);
		
		
		
		System.out.println();
		
		ListNode newNode = deleteDuplicates(headNode);
		newNode.listListNode(newNode);

	}

	public static ListNode deleteDuplicates(ListNode head) {

		 if (head == null) return null;
		 
		 if(head.next == null) return head;
		
		ListNode dummyNode = head;
		ListNode distinctNode = new ListNode(-1);
		ListNode dummyDistinctNode = null;
		dummyDistinctNode = distinctNode;

		boolean flag = true;
		while (dummyNode.next != null) {
			
			ListNode prevNode = dummyNode;
			int prevValue = prevNode.val;
			dummyNode = dummyNode.next;
			int nextValue = dummyNode.val;
			
			if (prevValue != nextValue) {
//				if(flag) {
//					dummyDistinctNode.next = prevNode;
//					flag = false;
//				} else {
//					dummyDistinctNode = dummyDistinctNode.next;
//					dummyDistinctNode.next = prevNode;
//				}
				
				dummyDistinctNode.next = prevNode;
				dummyDistinctNode = dummyDistinctNode.next;
				
			}
			
			if(dummyNode.next == null) {
				dummyDistinctNode.next = dummyNode;
			}
			
		}

		return distinctNode.next;

	}
}
