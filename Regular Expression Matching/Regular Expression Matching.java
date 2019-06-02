class Solution {
	// 采用递归的方式进行匹配
	public boolean isMatch (String text, String pattern) {
		// 当正则为空时，判断字符串是否为空
		//递归停止的终点，当正则的字符处理完时，如果字符串还有字符没有处理，那么代表匹配不成功
		if (pattern.isEmpty()) {
			return text.isEmpty();
		}
		// 每次递归是只判断字符串的第一个字符
		// 1.判断字符串的第一个字符是否匹配
		boolean first_match = (!text.isEmpty() && 
			(pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
		// 2.根据正则的第二个字符是否是"*"可以分为不同的截断方式
		// （1）当正则的第二个字符是"*"
		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			// 只需递归判断两种情况（因为*代表该字符为0个获得多个）：
			// 1.不管第一个字符是否匹配，将正则从第二个字符开始截断，继续判断
			// 2.当第一个字符匹配成功时，将字符串从第一个字符截断，相当于新的字符串和原来的正则继续判断
			return (isMatch(text, pattern.substring(2)) || 
				(first_match && isMatch(text.substring(1), pattern)));
		} else {
		// （2）当正则的第二个字符不是"*"
			// 要能匹配成功，首先第一个字符必须匹配成功，将字符串和正则从第一个字符截断，相当于新的字符串和新的正则继续判断
			return first_match && isMatch(text.substring(1), pattern.substring(1));
		}
	}
}