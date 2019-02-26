public class Solution {//O(m). m is the size of the charset.    只存储字符大小
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        //a['b'-'a']=a[1]
        //一共有128种可能的字符
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            //如果当前字符重复了，那该字符索引数组的值会大于窗口的左边
            i = Math.max(index[s.charAt(j)], i);
            //存储不重复子字符最大的长度
            ans = Math.max(ans, j - i + 1);
            //对应的字符索引数组上，存储上该字符所在的位置
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
