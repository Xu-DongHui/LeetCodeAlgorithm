public class Solution {
	// 寻找一个数组序列的有序增加元素的个数
	// 递归的方式查询
	public int lengthOfLIS(int[] nums) {
		return lengthofLIS(nums, Integer.MIN_VALUE, 0);
	}

	// 查询nums中，以pre作为前面元素，curpos作为当前元素的情况下，往下穷举的有序元素的个数
	public int lengthofLIS(int[] nums, int prev, int curpos) {
		// 当当前元素为nums.length，则往下穷举的个数为0
		if(curpos == nums.length) {
			return 0;
		}

		// 统计选取当前元素的有序元素组的个数
		int taken = 0;

		// 如果当前元素大于之前的元素可以
		// 1）可以把当前元素放入有序元素组，接着往下遍历，用taken记录元素组个数
		// 2）也可以不放入（因为可能不是最长元素组的元素），换下一个元素
		if(nums[curpos] > prev) {
			taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);
		}

		// 如果当前元素小于之前的元素，则当前元素肯定不放入有序元素组
		// 下面nottaken记录了两种情况
		int nottaken = lengthofLIS(nums, prev, curpos + 1);

		// 返回三种情况中最大的元素组个数
		return Math.max(taken, nottaken);
	}
}