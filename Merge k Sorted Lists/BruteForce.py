# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):
	# 将所有的链表的值合并为一个集合，排序后再转换为一个离岸边

	def mergeKLists(self, lists):
		"""
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        # node用来存储所有的链表值
		self.nodes = []
		# 构造一个虚拟的链表节点
		head = point = ListNode(0)
		# 遍历并存储所有的链表值
		for l in lists:
			#获得每个链表里面的值
			while l:
				self.nodes.append(l.val)
				l = l.next
		# 将排序后的list值转为一个链表
		for x in sorted(self.nodes):
			point.next = ListNode(x)
			point = point.next
		return head.next
