public class Solution {
	public int maxArea(int[] height) {
		// 记录出现过的最大的面积
		int maxArea = 0;
		// 遍历可能的面积组合
		for(int i = 0; i < height.length; i++) {
			for(int j = i + 1; j < height.length; j++)
				// 两条边组合时，以两者中的短边为宽，两者的距离为长
				// 使用现有的包装好的api，整个代码就变得简洁很多
				maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
		}
		return maxArea;
	}
	// 时间复杂度O(n^2),空间复杂度O(1)
}
/* 比较分析自己写的代码：过于冗余
class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        for(int i = 1; i < len + 1; i++) {
            for(int j = i + 1; j < len + 1; j++) { 
                int betLow = 0;
                if(height[j - 1] < height[i -1])
                    betLow = height[j - 1];
                else
                    betLow = height[i - 1];
                int square = betLow * (j - i);
                max = max > square ? max : square;
            }
        }
        return max;
    }
}

*/