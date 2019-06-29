public class Solution {
	// 使用递归
	public ListNode swapPairs(ListNode head) {
		// 当链表W只有0或1个节点时，返回原链表
		if(head == null || head.next == null)
			retunr head;
		// 交换前两个节点
		ListNode n = head.next;
		// 递归交换好剩下的其他节点
		head.next = swapPairs(head.next.next);
		n.next = head;
		return n;
	}
}