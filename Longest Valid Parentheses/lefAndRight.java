// 两次遍历字符串寻找最大长度的有效子字符
public class Solution {
	public int longestValidParentheses(String s) {
		int left = 0, right = 0, maxlength = 0;
		// 从左向右遍历，能寻找到有效的字符，但忽略了左括号数量多于右括号数量，但存在有效字符串的情况，如（（（））
		for(int i = 0, i < s.length(); i++) {
			// 统计遇到的左右括号的数量
			if(s.charAt(i) == '(')
				left++;
			else
				right++;
			// 当左括号数量始终多于右括号，且左右括号数量相等时，有效
			if(left == right)
				maxlength = Math.max(maxlength, 2 * right);
			else if(right > left)
				left = right = 0;

		}

		left = right = 0;
		// 从右往左遍历，检查上面忽略掉的情况
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) == '(')
				left++;
			else
				right++;
			if(left == right) {
				maxlength = Math.max(maxlength, 2 * left);
			// 右括号多于左括号
			}else if(left > right)
				left = right = 0;
		}

		return maxlength;
	}
}