class Solution {
//By iterating through the string from left to right, we can easily determine which row in the Zig-Zag pattern that a character belongs to.
//以row为视角来组织字符串,只需要关注现在是第几行和现在的方向
//Iterate through ss from left to right, appending each character to the appropriate row. The appropriate row can be tracked using two variables: the current row and the current direction.
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < Math.min(numRows, s.length()); i++) 
            rows.add(new StringBuilder());//每一个行用StringBuilder来记录该行的字符
        
        int curRow = 0;//记录遍历到第几行
        boolean goingDown = false;//记录现在的方向
        
        for(char c : s.toCharArray()) {
            rows.get(curRow).append(c);//将字符串的字符加入到对应的行中
            if(curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;//变换方向
            curRow += goingDown ? 1 : -1;//逐行向上或向下
        }
        
        StringBuilder ret = new StringBuilder();
        for(StringBuilder row : rows) ret.append(row);//按照行，将字符串拼接到一起
        return ret.toString();
    }
}
