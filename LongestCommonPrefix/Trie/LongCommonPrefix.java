public class LongCommonPrefix {
	public static void main(String[] args) {
		String[] str = {"flower", "flow", "floy"};
		String s = longestCommonPrefix(str);
		System.out.println(s);
	}
	
	public static String longestCommonPrefix(String [] str) {
		if(str.length == 0)
			return "";
		if(str.length == 1)
			return str[0];
		Trie trie = new Trie();
		for(int i = 0; i < str.length; i++) {
			trie.insert(str[i]);
		}
		
		return trie.findPrefix(str[0]);
	}
}
