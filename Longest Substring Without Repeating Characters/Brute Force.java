public class Solution {//时间复杂度高O(n3)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        //遍历所有的子字符串，记录没有重复字母的子字符串的最大的长度
        //获取子字符串时，使用两个标签，分别代表子字符串的开头和结尾
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                //当子字符串没有重复字母时，ans记录最大的长度
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    //判断该子字符串是否有重复的字母
    public boolean allUnique(String s, int start, int end) {
        //HashSet实现了Set接口，它不允许集合中出现重复元素。
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}
