public Class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// 记录ListNode的节点数
		int length = 0;
		ListNode first = head;
		// 统计出节点数
		while(first != null) {
			length++;
			first = first.next;
		}

		// 删除倒数第n个节点，代表删第length-n+1个节点
		// 1.节点计数是1,2,...
		// 2.可以以删除第一个节点为例来缕清关系
		// 3.length-n代表前项节点
		length -= n;

		// 建立虚拟节点，来构建统一的关系
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		first = dummy;
		// 如果listnode中存在前项节点则找到该前项节点，如果没有前项节点，那么虚拟节点可以作为前项节点，即，删除的是头节点。
		while(length > 0) {
			length--;
			first = first.next; // 获得前项节点
		}
		// 删除节点：前项节点连接后项节点
		first.next = first.next.next;
		return dummy.next;
	}
}