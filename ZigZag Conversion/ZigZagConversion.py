class Solution(object):
    #算法思路同java方法
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        #直接返回原字符串即可
        if numRows == 1 or numRows >= len(s):
            return s

        #在python中, 如果用一个列表list1乘一个数字n 会得到一个新的列表list2, 这个列表的元素是list1的元素重复n次,
        L = [''] * numRows
        #step来记录方向
        index, step = 0, 1

        #遍历字符串中的字符
        for x in s:
            #python中的字符串拼接可以直接用+
            L[index] += x
            if index == 0:
                step = 1
            elif index == numRows -1:
                step = -1
            index += step

        #join用法：按照自定义方法连接列表为字符串
        return ''.join(L)
