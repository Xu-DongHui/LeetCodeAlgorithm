public class solution {
	// 采用互斥的原理进行遍历
	public List<String> generateParenthesis(int n) {
		// 存储给定n下的括号组合
		List<String> ans = new ArrayList();
		// 组合为空
		if(n == 0) {
			ans.add("");
		} else {
			// 给定一个括号组合集合left，第一个元素必然是"(",最后一个元素必然是")"
			for(int c = 0; c < n; ++c) {
				// 括号组合集合left由元素c确定
				for(String left : generateParenthesis(c))
					// 当集合left确定了之后，其互斥的另外一个集合right也可确定
					for(String right : generateParenthesis(n - 1 - c))
						// left集合和right集合组成最终的集合
						ans.add("(" + left + ")" + right);
			}
		}
		return ans;
	}
}