class solution {
	// 计算两个字符串相乘的结果：将排竖式的乘法计算过程表达出来
	// https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
	public String multiply(String num1, String num2) {
		int m = num1.length(), n = num2.length();
		// 计算的结果是存储在大小为m+n的数组中
		int[] pos = new int[m + n];

		// 从两个字符串的末尾数字开始计算
		for(int i = m - 1; i >= 0; i--) {
			for(int j = n - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				// 位置i和j乘法得到的结果存放在i+j和i+j+1的位置
				int p1 = i + j, p2 = i + j + 1;
				// 1.计算结果先统一放到p2的位置中
				int sum = mul + pos[p2];
				// 2.处理结果，分别放到i+j和i+j+1中
				// 3.因为是从右往左计算，因此可以保证pos上的每一位经过这么处理都只有个位大小
				pos[p1] += sum/10;
				pos[p2] += sum%10;
			}
		}

		// 将pos中的数组拼接成字符串
		StringBuffer sb = new StringBuilder();
		for(int p : pos) {
			// 排除首字母为0的数字
			if(!(sb.length() == 0 && p == 0))
				sb.append(p);
		}

		return sb.length() == 0 ? "0" : sb.toString();
	}
}