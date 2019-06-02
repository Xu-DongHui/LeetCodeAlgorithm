public class Solution {
	public int maxArea(int[] height) {
		int maxArea = 0;
		int l = 0; // 标记数组左边
		int r = height.length - 1; // 标记数组右边
		while(l < r) {
			maxArea = Math.max(maxArea, Math.min(height[r], height[l]) * (r - l));
			// 取左右两边相对较短的一边，向内进行遍历
			// 因为短边对面积的影响大，改变短边，有可能降低坐标靠近的影响，获得更大的面积
			if(height[r] < height[l])
				r--;
			else
				l++;
		}
		return maxArea;
	}
	// 时间复杂度O(n),空间复杂度O(1)
}