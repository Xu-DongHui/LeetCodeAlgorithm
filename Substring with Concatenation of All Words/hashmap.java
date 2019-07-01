class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		// 存储words数组里面的字符串，并统计其个数
		final Map<String, Integer> counts = new HashMap<>();
		for(final String word: words) {
			// jdk8中的新方法，在没有找到提供的键的匹配项的时候返回一个“默认值”。
			counts.put(word, counts.getOrDefault(word, 0) + 1);
		}

		final List<Integer> indexes = new ArrayList<>();
		final int n = s.length(), num = words.length;
		final int len = words[0].length();

		// i标记字符串的索引，遍历所有可能的索引
		for(int i = 0; i < n - num * len + 1; i++) {
			// 存储以当前索引i为头的字符串内有对应的word的字符串的情况
			final Map<String, Integer> seen = new HashMap<>();
			int j = 0;
			while(j < num) {
				// 取以当前索引i为头的字符串的第j个word
				final String word = s.substring(i + j * len, i + (j + 1) * len);
				// 判断第j个word是否属于words
				if(counts.containsKey(word)) {
					// 如果属于words，就统计该word在字符串内出现的频次
					seen.put(word, seen.getOrDefault(word, 0) + 1);
					// 当该word在字符串内出现的频次高于words里面的频次，说明不匹配，跳出此次while查询
					if(seen.get(word) > counts.getOrDefault(word, 0))
						break;
				} else //当j个word不属于words时，跳出此次查询
					break;
				// 遍历当前字符串内的下一个word
				j++;
			}

			// 没有跳出过查询，则说明当前字符串内的word和words里面的word是对应上的，记录当前字符串的索引
			if(j == num) {
				indexes.add(i);
			}
		}
		return indexes;
	}
}

// 我自己的方法
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int lenOfS = s.length();
        int len = words.length;
        List<Integer> indices = new ArrayList<Integer>();
        if(lenOfS == 0 || len == 0)
            return indices;
        int lenOfWord = words[0].length();
        int allLen = len * lenOfWord;
        // 遍历字符串s的索引。+1是因为，substring(start, stop)方法截取的子字符串不包括stop位置的字符
        for(int j = 0; j < s.length() - allLen + 1; j++) {
        	// 截取符合words总长度的字符串与word进行对比
            boolean result = isConcatention(s.substring(j, j + allLen), words);
            // 当两者匹配时，记录当前索引
            if(result)
                indices.add(j);
        }
        
        return indices;
    }
    
    // 截取符合words总长度的字符串与word进行对比
    public boolean isConcatention(String s, String[] words) {
    	// 将字符串根据word的长度截断成字符串数组
        String[] components = new String[words.length];
        int l = words.length;
        int g = 0;
        for(int i = 0; i < l; i++) {
            components[i] = s.substring(g, g + words[0].length());
            g = g + words[0].length();
        }
        // 将两个字符串数组排序后进行一一比较，完全相同则返回true
        Arrays.sort(components);
        Arrays.sort(words);
        for(int n = 0; n < l; n++) {
            if(!components[n].equals(words[n]))
                return false;
        }
        return true;
    }
}