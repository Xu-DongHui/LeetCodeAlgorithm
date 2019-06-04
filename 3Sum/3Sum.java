public List<List<Integer>> threeSum(int[] nums) {
	// 建立集合
	List<List<Integer>> res = new ArrayList<>();
	// 对数组进行排序，原数组顺序发生改变
	Arrays.sort(nums);
	// 寻找三个相加起来为0的数，先固定一个数，然后再遍历选择另外两个数
	for(int i = 0; i + 2 < nums.length; i++) {
		// 当nums[i] = nums[i - 1]，代表已经寻找过包含nums[i - 0]的三个相加为0的组合，并且这些组合里已经包含了的nums[i]的三个相加为0的组合
		// 因为返回的结果中，三个数相同视为同一种组合。
		if(i > 0; nums[i] = nums[i - 1])
			// 跳过nums[i],查找下一个数
			continue;
		int target = -nums[i]; //固定一个数查找剩下的两个数
		int j = i + 1; // 从左边开始找一个数
		int k = nums.length - 1; // 从右边开始找一个数
		
		while(j < k) {
			if(nums[j] + nums[k] == target) { // 当找到剩下两个数的一种组合时，存入集合，接着找下一种可能的组合
				res.add(Arrays.asList(nums[i], nums[j], nums[k]));
				// 可以同时j++和k--，因为三个数相同视为同一种组合
				j++;
				k--;
				// 跳过左右两边相同的数字，寻找新的不同的组合进行判断
				while(j < k && nums[j] == nums[j - 1]) j++;
				while(j < k && nums[k] == nums[k + 1]) k--;
			} else if(nums[j] + nums[k] > target) { // 现有的组合的和过大，k--减少和来接近目标
				k--;
				// while(j < k && nums[k] == nums[k + 1]) k--;
			} else // 现有的组合的和过小，j++增加和来接近目标
				j++;
				// while(j < k && nums[j] == nums[j - 1]) j++;
		}
	}
	return res;
}
