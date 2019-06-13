// 暴力解法：先产生所有可能的括号组合，返回再判断每一个组合是否有效
class Solution {
	public List<String> generateParenthesis(int n) {
		// 存储有效的括号组合
		List<String> combination = new ArrayList();
		// 产生有效的括号组合的方法
		generateAll(new char[2 * n], 0, combination);
		return combination;
	}

	// 产生有效的括号组合
	// 1. curent 存储括号组合； 2. pos 标记括号组合生成到哪一位了； 3. result存储当前产生的有效的括号组合
	public void generateAll(char[] current, int pos, List<String> result) {
		// 如果括号组合以及生成到最后一位了，则说明一个括号组合已经产生，判断是否有效
		if(pos == current.length) {
			if(valid(current))
				// 如果括号组合有效，则将该括号组合存储进集合
				// 将字符数组转为字符串，产生新的内存空间
				result.add(new String(current));
		} else { // 产生所有的括号组合
			// 在pos位置有两种可能'('和')'，分别进行递归
			// 以最后一位为例：
			// 假如最后一位是'('
			current[pos] = '(';
			// 进行判断，判断结束后，接下去执行
			generateAll(current, pos + 1, result);
			// 执行到这，假设最后一位是')',因为是对数组的引用进行操作，因此，最后一位的值变为了')'
			current[pos] = ')';
			// 进行判断，判断结束，一个递归结束，返回上一层，接下去执行
			generateAll(current, pos + 1, result);
		}
	}

	// 判断某个括号组合是否有效：某个右括号之前，必定存在一个左括号，则该组合有效
	public boolean valid(char[] current) {
		int balance = 0;
		// balance的正负代表：统计某个右括号之前，是否必定存在一个左括号
		for(char c : current) {
			// 第一个必须是'('
			if(c == '(')
				balance++;
			else
				balance--;
			// 一旦右括号前没有左括号了，则无效
			if(balance < 0)
				return false;
		}
		// balance == 0代表左括号与右括号是否一一对应
		return balance == 0;
	}

}