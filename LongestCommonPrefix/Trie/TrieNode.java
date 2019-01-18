public class TrieNode {
	
	//R links to node children
	private TrieNode[] links;//R links, each links corresponds to one of R character values from dataset alphabet.
	private final int R = 26;
	
	private boolean isEnd;
	private int size = 0;
	public TrieNode() {
		links = new TrieNode[R];
	}
	// key(character)-value(TrieNode)
	public boolean containsKey(char ch) {
		return links[ch - 'a'] != null;
	}
	
	public TrieNode get(char ch) {
		return links[ch - 'a'];
	}
	
	public void put(char ch, TrieNode node) {
		links[ch - 'a'] = node;
		size ++;
	}
	
	public void setEnd() {
		isEnd = true;
	}
	
	public boolean isEnd() {
		return isEnd;
	}
	
	public int getSize() {
		return size;
	}
}
