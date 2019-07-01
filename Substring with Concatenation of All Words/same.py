from collections import Counter, defaultdict
# 用python实现Java的思路
class Solution(object):
	def findSubstring(self, s, words):
		# 计数器，统计words里面每个word的频次，是一个dict
		wordBag = Counter(words)
		wordLen, numWords = len(words[0]), len(words)
		totalLen, res = wordLen * numWords, []
		# 遍历字符串的每个索引
		for i in range(len(s) - totalLen + 1):
			# 统计数量，也是一个dict
			seen = defaultdict(int)
			# 生成一个数列，每个数代表一个word
			for j in range(i, i + totalLen, wordLen):
				# 取出该word
				currWord = s[j: j + wordLen]
				# 判断该word是否在wordBag里面
				if currWord in wordBag:
					# 如果在，就记录其数量
					seen[currWord] += 1
					if seen[currWord] > wordBag[currWord]:
						break
					else:
						break
			# 当seen记录的数量和words里面的数量一致，则记录该索引
			if seen = wordBag:
				res.append(i)
		return res
