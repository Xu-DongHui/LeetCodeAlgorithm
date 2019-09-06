public class Solution {
	// 改进了暴力解法，用memo二维数组，记录递归的结果，避免了重复递归已经递归过的部分
	public int lengthOfLIS(int[] nums) {
		int memo = new int[nums.length + 1][nums.length];
		// 初始值设为-1
		for(int[] l : memo) {
			// 向数组中传送一个相同对象。
			Arrays.fill(l, -1);
		}

		return lengthofLIS(nums, -1, 0, memo);
	}

	// 获得以previndex为前面元素，curpos为当前元素的有序元素组的个数
	public int lengthofLIS(int[] nums, int previndex, int curpos, int[][] memo) {
		// 当前元素为空，则为0
		if(curpos == nums.length) {
			return 0;
		}

		// 相较于暴力解法的创新之处
		// 如果以preindex为前面元素，curpos为后面元素以及递归过了，那就不需要再递归了，直接返回
		if(memo[previndex + 1][curpos] >= 0) {
			return memo[previndex + 1][curpos];
		}

		// 统计选取当前元素有序元素组个数
		int taken = 0;

		// 如果当前元素大于之前的元素可以
		// 1）可以把当前元素放入有序元素组，接着往下遍历，用taken记录元素组的元素个数
		// 2）也可以不放入（因为可能不是最长元素组的元素），换下一个元素

		// previndex为选取第一个元素时的情况
		if(previndex < 0 || nums[curpos] > nums[previndex]) {
			taken = 1 + lengthofLIS(nums, curpos, curpos + 1, memo);
		}

		// 如果当前元素小于之前的元素，则当前元素肯定不放入有序元素组，当前元素变为curpos+1
		// 下面nottaken记录了两种情况
		int nottaken = lengthofLIS(nums, previndex, curpos + 1, memo);

		// memo[previndex + 1][curpos]记录了以previndex为前面元素，curpos为当前元素的有序元素组的个数
		memo[previndex + 1][curpos] = Math.max(taken, nottaken);
		
		return memo[previndex + 1][curpos];
	}
}