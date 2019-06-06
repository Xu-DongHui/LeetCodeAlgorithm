pubic class Solution {
	public int threeSumCloset(int[] num, int target) {
		// 记录最靠近的三位数
		int result = num[0] + num[1] + num[num.length - 1];
		Arrays.sort(num);
		// 先选定第一个数，再选剩下的两个数
		for(int i = 0; i < num.length - 2; i++) {
			// 跳过重复的第一个数
			if(i == 0 || num[i] == num[i - 1]) {
				int start = i + 1; // 标记从最左边标记第2个数
				int end = num.length - 1; // 从最右边标记第3个数
				while(start < end) {
					// 选择一种可能的三位数组合
					int sum = num[i] + num[start] + num[end];
					// 当这三位数比目标值大，说明需要调小，因此将右边的数往左移，在下一轮循环中计算
					if(sum > target) {
						end--;
						// 左移过程中，跳过重复值
						while(start < end && num[end + 1] == num[end]) {
							end--;
						}
					}
					// 当这三位数比目标值小，说明需要调大，因此将左边的数往右移，在下一轮循环中计算
					else if(sum < target)
						start++;
						while(start < end && num[start - 1] == num[start])
							start++;
					// 当这三个数的值等于目标值，直接返回sum
					else
						return sum;
					// 比较此次循环中，该三位数组合是否比之前的组合更靠近目标值，如果是的话，保留下此次的sum
					if(Math.abs(sum - target) < Math.abs(result - target))
						result = sum;
				}
			}
		}

		return result;
	}
}