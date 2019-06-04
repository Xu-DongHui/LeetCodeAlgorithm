public Class Solution{
	public String intToRoman(int num) {
		// 对于每个特殊表示的数值都可以作为单位，比如900，一般900都只用了一个单位
		// 数值数组和罗马数字数组一一对应
		int[] coins = {
			1000, 900, 500, 400,
			100, 90, 50, 40, 10,
			9, 5, 4, 1
		};
		String[] romanNums = {
			"M", "CM", "D", "CD", "C",
			"XC", "L", "XL", "X", "IX",
			"V", "IV", "I"
		};

		//记录level共有多少个单位
		int coinsUsed;
		// 拼接字符串
		StringBuilder resultSB = new StringBuilder();
		for(int i = 0; i < 13; i++) {
			// 从最高位开始统计最大的单位用了多少个
			coinsUsed = num / coins[i];
			String s = romanNums[i];
			for(int j = 0; j < coinsUsed; j++) {
				// 将使用的单位拼接起来。罗马数字的规则。
				resultSB.append(s);
			}
			// 接着计算下一个位
			num -= coinsUsed * coins[i];
			// 当正好被所有单位表示时，结束
			if(num == 0)
				break;
		}
		return resultSB.toString();
	}
}