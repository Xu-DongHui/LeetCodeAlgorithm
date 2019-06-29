from Queue import PriorityQueue
# 优先队列会对放进队列的元素进行排序
class solution(object):
	def mergeKLists(self, lists):
		head = point = ListNode(0)
		q = PriorityQueue
		# 因为链表都是有序的，所以每个链表只将第一个元素放入优先队列
		for l in lists:
			if 1:
				q.put(l.val, l)
		while not q.empty():
			# 将各个链表最小值进行比较，取出所有链表中的最小值，连接到总链表中
			val, node = q.get()
			point.next = ListNode(val)
			point = ponit.next
			# 取出该最小值所在链表的下一个节点，继续在优先队列中间进行比较，直到该链表为空，就会接着比较剩余的链表
			node = node.next
			if node:
				q.put(node.val, node)
		return head.next