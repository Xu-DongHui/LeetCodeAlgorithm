// 判断所有可能的子字符串，时间复杂度为o(n^3)，太高了
public class Solution {
	public int longestValidParentheses(String s) {
		int maxlen = 0;
		for(int i = 0; i < s.length(); i++) {
			for(int j = i + 2; j <= s.length; j += 2) {
				// 判断所有可能的子字符串是否有效
				if(isValid(s.substring(i, j))) {
					// 存储最长的有效字符串的长度
					maxlen = Math.max(maxlen, j - i);
				}
			}
		}
		return maxlen;
	}

	// 通过栈来判断是否有效，有效的条件
	// 1.在遍历过程中，左括号数量始终大于右括号
	// 2.遍历结束后，左右括号的数量相等
	public boolean isValid(String s) {
		// 栈存储左括号
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(')
				stack.push('(');
			// 当遇到一个右括号后，弹出一个左括号
			else if(!stack.empty() && stack.peek() == '(')
				stack.pop();
			// 当遇到一个右括号，且没有剩余的左括号，则该字符串无效
			else
				return false;
		}
		// 当遍历结束后，左右括号数量相等，则该字符串有效，唯一一种可能是左括号多余了
		return stack.empty()
	}
}