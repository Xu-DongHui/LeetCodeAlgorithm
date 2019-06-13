public Class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// 只需遍历链表一次就可以
		// 建立虚拟节点，方便删除head节点
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// 第一个标签
		ListNode first = dummy;
		// 第二个标签
		ListNode second = dummy;
		// 第一个标签在前,第二个标签在后,两个标签之间相隔n个节点
		for(int i = 1; i <= n + 1; i++) {
			first = first.next;
		}
		// 当第二个标签到达链表末尾null时，第一个标签正好指向前项节点
		while(first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
	}
}