class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
             return "";
        }
        if(strs.length == 1) {
             return strs[0];
        }
        int min = strs[0].length();
        String s = strs[0];
        for(int i = 0; i < strs.length; i++) {
            if(min > strs[i].length()) {
                min = strs[i].length();
                s = strs[i];
            }
        }
        for(int k = s.length(); k > 0 ; k--) {//从一个字符串的后面往前面比较
            String subS = s.substring(0,k);//起始索引（包括）, 索引从 0 开始，结束索引（不包括）
            int sum =0;
            for(int j = 0; j < strs.length; j++) {
                if(strs[j].substring(0,k).equals(subS)){//字符串用equals比较
                    sum++;
                }
            }
            if(sum == strs.length) {
                return subS;
            }
        } 
        return "";
    }
}
/*筛选出字符数组中各字符的共同子字符
class Solution {
	    public String longestCommonPrefix(String[] strs) {
	        if(strs.length == 0) {
	             return "";
	        }
	        if(strs.length == 1) {
	             return strs[0];
	        }i
	        String s = strs[0];
	        for(int i = 0; i < s.length(); i++) {
	            for(int k = s.length(); k > i ; k--) {
	                String subS = s.substring(i,k);
	                int sum =0;
	                for(int j = 1; j < strs.length; j++) {
	                    if(strs[j].indexOf(subS) != -1){
	                        sum++;
	                    }
	                }
	                if(sum == strs.length-1) {
	                    return subS;
	                }
	            } 
	        }
	        return "";
	    }
	}*/
