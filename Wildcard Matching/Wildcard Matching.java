class Solution {
	// 通配符*和?检验
	// 动态分配算法
	public boolean isMatch(String s, String p) {

		int m = s.length(), n = p.length();
		// 组成一个二维数组，dp[i][j] = true代表在字符串s[0,...i-1]上的字符和p[0,...j-1]上的字符匹配成功
		// s和p的第一个位置为空
		boolean[][] dp = new boolean[m + 1][n + 1];

		//对应s和p来说，空和空是匹配的
		dp[0][0] = true;
		// 对于p的空位置来说，s的任何一个位置都不匹配，因此为false
		// 其实可以省略下面的赋值过程，因为默认为空
		for(int i = 1; i <= m; i++) {
			dp[i][0] = false;
		}

		// 对于s的空位置来说，只有p的开头是****...才能匹配上，遇到第一个非*的字符之后就都为false了
		for(int j = 1; j <= n; j++) {
			if(p.charAt(j - 1) == '*') {
				dp[0][j] = true;
			} else {
				break;
			}
		}

		// 从s和p的第一个字符开始，基于之前的判断结果得出最终的判断匹配
		// 不断递推得到所有的结果
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(p.charAt(j - 1) != '*') {
					// 如果p的当前字符不为*,则在之前都匹配成功的情况下，当前字符只能匹配上或者为'?'
					dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
				} else {
					// 如果p的当前字符为*，dp[i][j]为true的情况为：
					// 1）dp[i - 1][j]为ture,且当前的*代表任意的字符；
					// 2）dp[i][j - 1]为ture,且当前的*代表空字符；
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
			}
		}

		// dp[m][n]代表s和p是否匹配
		return dp[m][n];
	}
}