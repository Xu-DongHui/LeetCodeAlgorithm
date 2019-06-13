public class Solution {
	public List<String> generateParenthesis(int n) {
		// 存储所有合格的括号组合
		public List<String> ans = new ArrayList();
		// 进行回溯
		backtrack(ans, "", 0, 0, n);
		return ans;
	}

	// 想象成二叉树
	// cur代表一种可能的括号组合；open代表当前的括号组合的左括号的个数；
	// close代表当前括号组合的右括号的个数；max代表左右括号最终的数目
	public void backtrack(List<String> ans, String cur, int open, int close, int max) {
		// 形成的括号组合都是可行的括号组合
		// 1.左右括号个数相等；
		// 2.右括号前面必有左括号
		if(cur.length() == max * 2) {
			ans.add(cur);
			return;
		}

		// 保证左右括号相等
		if(open < max)
			backtrack(ans, cur + "(", open + 1, close, max);
		// 保证右括号前面必有对应的左括号
		if(close < open)
			backtrack(ans, cur + ")", open, close + 1, max);
	}

	
}