public class Solution {//时间复杂度o(n)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        //使用hashmap记录遍历过的字符的索引，当发现重复的字符时，可以将窗口的左边直接跳到该重复字符的索引处
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {//j负责向右边遍历，i根据重复字符的情况进行调整
            if (map.containsKey(s.charAt(j))) {//当发现重复的字符时,将字符的索引与窗口的左边进行对比，将窗口的左边直接跳到该重复字符的索引处
                i = Math.max(map.get(s.charAt(j)), i);
            }
            //记录子字符串的最大的长度
            ans = Math.max(ans, j - i + 1);
            //map记录第一次遍历到key时的索引位置，j+1,保证i跳到不包含重复字母的位置
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
