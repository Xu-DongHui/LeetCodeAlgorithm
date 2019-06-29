# 分治算法：链表两两合并，最终生成一个链表
class Solution(object):
	def mergeKLists(self, lists):
		ammout = len(lists)
		# 步长
		interval = 1
		while interval < ammout:
			# 生成一个有序整数序列,range(start, end, step)
			# 从0开始，两两合并：0,1,2,3,4,5->0,2,4->0,4->0
			for i in range(0, ammout, interval * 2):
				lists[i] = sef.merge2List(lists[i], lists[i + interval])
			interval *= 2
		return lists[0] if ammout > 0 else lists

	def merge2List(self, l1, l2):
		# 合并两个链表
		head = point = ListNode(0)
		# 将两个链表的值两两比较，生成一个降序的链表
		while l1 and l2:
			if l1.val <= l2.val:
				point.next = l1
				l1 = l1.next
			else:
				point.next = l2
				l2 = l2.next
			point = point.next
		# 两个链表的长度不一样，剩下的链表可以直接连接到总链表的末尾
		if not l1:
			point.next = l2
		else:
			point.next = l1
		return head.next
