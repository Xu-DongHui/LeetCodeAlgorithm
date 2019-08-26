class Solution {
	//一个顺序数组截成两段，顺序交换，查找对应值的索引
	//时间复杂度为O(log(n))
	pubic int search(int[] nums, int target) {
		//当为空数组时
		if(nums.length == 0)
			return -1;
		//1.先用二分法找到对应的最小值的索引
		int minIdx = findMinIdx(nums);
		if(target == nums[minIdx])
			return minIdx;
		int m = nums.length;
		//找到最小值的索引，就相当于找到了数组的两段
		//2.判断target是在哪一段数组元素里面
		int start = (target <= nums[m - 1]) ? minIdx : 0;
		int end = (target >= nums[m - 1]) ? minIdx - 1 : m - 1;

		//3.二分查找查找对应的数组段，找到对应的值
		//需要等于号
		//假如end指到了target，start不断向end靠近，到最后start和end相邻时，可以再等于的情况下，得到target
		while(start <= end) {
			int mid = (start + end) / 2;
			if(nums[mid] == target)
				return mid;
			else if(nums[mid] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}

		return -1;
	}

	//二分法找到对应的最小值的索引
	private int findMinIdx(int[] nums) {
		int start = 0, end = nums.length - 1;
		//没有等于号
		//如果有等于号，则会死循环，因为end = mid;
		while(start < end) {
			int mid = (start + end) / 2;
			//和最后一个数组元素进行比较，判断最小值的位置
			if(nums[mid] > nums[end])
				start = mid + 1;
			else
				end = mid;
		}
		return start;
	}
}