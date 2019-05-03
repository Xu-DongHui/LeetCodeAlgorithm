class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        for i in range(1, len(nums)):#遍历和更新nums数组中的值
            if nums[i-1] > 0:#从第二个值开始遍历，当前面的值大于0，那么就加到当前值，因此对于达到最大累加和有帮助；小于0就不加到当前值，往后迭代
                nums[i] += nums[i-1]
        return max(nums)#选择更新后数组中的最大值，就是累加最大值
"""
函数声明中，nums: List[int]
nums 是参数 :冒号后面  List[int]是参数的注释。
如果参数有默认值，还要给注释，如下写。
max_len:'int>0'=80

->int 是函数返回值的注释。
"""
