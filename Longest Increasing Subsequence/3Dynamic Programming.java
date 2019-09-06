public class Solution {
	// 动态规划方法
	// 1）dp[]数组记录每个元素作为有序元素组最后一个元素时，该元素组的元素个数
	// 2）状态转移方程：dp[i]=max(dp[j])+1,∀0≤j<i，选取之前最大的个数，加一，成为当前元素的个数
	// 3）数组nums中有序元素组个数最大，为dp[]数组中的最大值
	public int lengthOfLIS(int[] nums) {
		// 数组为空，则为0
		if(nums.length == 0) {
			return 0;
		}

		int[] dp = new int[nums.length];
		// 第一个元素对应的个数肯定为1
		dp[0] = 1;

		// 记录全局的有序元素组个数最大
		int maxans = 1;

		for(int i = 1; i < dp.length; i++) {
			// 记录1)在元素num[i]之前的元素为有序元素组最后一个元素2)之前元素小于nums[i]时，有序元素组的元素最大个数
			int maxval = 0;
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					maxval = Math.max(maxval, dp[j]);
				}
			}
			// 以之前的最大值+1，为num[i]为有序元素组最后一个元素的元素组的最大个数
			dp[i] = maxval + 1;

			// 记录全局最大值
			maxans = Math.max(maxans, dp[i]);
		}

		return maxans;
	}
}