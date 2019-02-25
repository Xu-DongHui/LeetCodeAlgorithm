public class Solution {//时间复杂度O(2n),空间复杂度O(min(m,n))
//O(min(m,n)). Same as the previous approach. We need O(k)O(k) space for the sliding window, where kk is the size of the Set. The size of the Set is upper bounded by the size of the string nn and the size of the charset/alphabet mm. 
  //滑动窗口算法
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {//窗口的左边是i，右边是j，下列算法将窗口的左右移动，截取出其中一段
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){//如果set中不存在该字母，就将j+1，相当于窗口右边向右移动一格，左边不动
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);//记录目前存在过的最大的子字符长度
            }
            else {//如果set中存在该字母，则将窗口左边向右移动一格，右边不动，直到该窗口中不存在重复的字符
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
