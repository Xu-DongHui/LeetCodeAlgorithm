pullic class Solution {
	// 1.使用map来存储数字和字符的对应关系
	// 2.map的初始化方式：
	// 第一层括弧实际是定义了一个匿名内部类 (Anonymous Inner Class)；
	// 第二层括弧实际上是一个实例初始化块 (instance initializer block)，这个块在内部匿名类构造时被执行。
	Map<String, Stirng> phone = new HashMap<String, String>() {
		{
			put("2", "abc");
			put("3", "def");
			put("4", "ghi");
			put("5", "jkl");
			put("6", "mno");
			put("7", "pqrs");
			put("8", "tuv");
			put("9", "wxyz");
		}
	};

	// 存储结果
	List<String> output = new ArrayList<String>();

	// 回溯算法：类似枚举的搜索尝试过程，可以想象成建立一棵树
	public void backtrack(String combination, String next_digits) {
		// 如果字符串已经搜索结束，则停止
		if(next_digits.length() == 0)
			output.add(combination);
		else { // 接下去搜索剩下的字符串
			// 取第一个字符
			String digit = next_digits.subString(0, 1);
			// 根据数字获取对应的字符
			String letters = phone.get(digit);
			// 建立树的第一层
			for(int i = 0; i < letters.length(); i++) {
				// 建立第一层的每个元素：取第i个字符
				String letters = letters.subString(i, i + 1);
				// 排列组合的方式->用递归的方式，在每个元素下面，建立第二层，以此类推
				backtrack(combination + letters, next_digits.subString(1));
			}
		}
	}

	public List<String> lettersCombinations(String digits) {
		if(digits.length() != 0) {
			backtrack("", digits);
		}
		return output;
	}
}