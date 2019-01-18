package trieDefinition;

public class Trie {// the trie comprise the many trienode,such as 26
	private TrieNode root;
	public Trie() {
		root = new TrieNode();
	}
	
	//insert a word into the trie
	public void insert(String word) {
		TrieNode node = root; 
		for(int i = 0; i <word.length(); i++) {
			char currentChar = word.charAt(i);
			if(!node.containsKey(currentChar)) {
				node.put(currentChar, new TrieNode());
			}
			//find exist node in trie as root
			node = node.get(currentChar);
		}
		//the end of the key
		node.setEnd();
	}
	
	//search a prefix or whole key in trie and return the node where search ends
	private TrieNode searchPrefix(String word) {//find whole word otherwise return null
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++) {
			char currentChar = word.charAt(i);
			if(node.containsKey(currentChar)) {
				node = node.get(currentChar);
			}else {
				return null;
			}
		}
		return node;
	}
	
	//return if the word is in the trie
	public boolean search(String word) {
		TrieNode node = searchPrefix(word);
		return node != null && node.isEnd();
	}
	
	//return if there is any word in the trie that starts with the given prefix
	public boolean startswith(String prefix) {
		TrieNode node = searchPrefix(prefix);
		return node != null;
	}
	
	public String findPrefix(String word) {
		TrieNode node = root;
		StringBuilder prefix = new StringBuilder();
		for(int i = 0; i < word.length(); i++) {
			char currentChar = word.charAt(i);
			//prefix satisfies the following conditions:
			//1.each node along with the path contains only one childeren node
			//2.the path doesn't comprise of nodes which are marked as an end of key. For example{"flower","flow","flo"}
			if(node.containsKey(currentChar) && node.getSize() == 1 && !node.isEnd()) {
				prefix.append(currentChar);
				node = node.get(currentChar);
			}else {
				return prefix.toString();
			}
		}
		return prefix.toString();
	}
}

