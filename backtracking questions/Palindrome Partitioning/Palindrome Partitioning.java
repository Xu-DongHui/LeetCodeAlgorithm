class Solution {
	// 回溯法：统计一个字符串正好能够截成的回文的组合。
	public List<List<String>> partition(String s) {
		List<List<String> list = new ArrayList<>();
		backTrack(list, new ArrayList<>(), s, 0);
		return list;
	}

	// start代表当前截断子字符的起始位置
	private void backTrack(List<List<String>> list, List<String> list, String s, int start) {
		// 所有的子字符都已经截过了,且截好的子字符都是回文
		if(start == s.length())
			list.add(new ArrayList<>(tempList));
		else {
			// 回溯法,每一层的子节点是可能的子字符
			for(int i = start; i < s.length(); i++) {
				// 判断当前截断的子字符是否是回文,是的话就保留这个截断,接着往下截下一个子字符
				if(isPalindrome(s, start, i)) {
					// 保留这个截断的子字符
					tempList.add(s.substring(start, i + 1));
					// 从当前位置,接着往下截下一个子字符
					backTrack(list, tempList, s, i + 1);
					// 换一种阶段方式
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	}

//  判断是否是回文
	private boolean isPalindrome(String s, int low, int high) {
		while(low < high)
			// 首尾字符一一比对
			if(s.charAt(low++) != s.charAt(high--))
				return false;
		return true;
	}
}