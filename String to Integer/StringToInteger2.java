public static int myAtoi(String str) {
	// 判断字符是否为空字符
	if (str == null || str.length() == 0)
		return 0;//
	str = str.trim();
	// 根据第一个字符判断正负
	char firstChar = str.charAt(0);
	int sign = 1, start = 0, len = str.length();
	// 用于判断int的最大值
	long sum = 0;
	if (firstChar == '+') {
		// 判断正负号
		sign = 1;
		// 用第二个字符开始遍历，否则从第一个字符开始
		start++;
	} else if (firstChar == '-') {
		sign = -1;
		start++;
	}
	for (int i = start; i < len; i++) {
		// 字符中间只要有任何一个字符不是数字，那么就返回之前的数字
		if (!Character.isDigit(str.charAt(i)))
			return (int) sum * sign;
		sum = sum * 10 + str.charAt(i) - '0';
		if (sign == 1 && sum > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
	}

	return (int) sum * sign;
}