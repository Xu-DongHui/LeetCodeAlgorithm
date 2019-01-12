class Solution {
    public int romanToInt(String s) {
        int[] num = new int[s.length()];//获取string的长度
        for(int i = 0; i < s.length(); i++) {//swithc case语句既可以判断字符也可以判断数字
            switch(s.charAt(i)) {//获取string第i个字符
                case 'I'://chart用单引号，string用双引号
                    num[i] = 1;
                    break;
                case 'V':
                    num[i] = 5;
                    break;
                case 'X':
                    num[i] = 10;
                    break;
                case 'L':
                    num[i] = 50;
                    break;
                case 'C':
                    num[i] = 100;
                    break;
                case 'D':
                    num[i] = 500;
                    break;
                case 'M':
                    num[i] = 1000;
                    break;
            }
            
        }
        if(s.length() == 1) {
            return num[0];
        }
        int sum = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if(num [i] >= num[i+1]) {
                if(i == s.length() -2) {
                    sum = sum + num[i] + num[i+1];
                }else {
                    sum += num[i];
                }
            }else {
                sum = sum + num[i+1] -num[i];
                i++;
                if(i == s.length() -2) {
                    sum = sum + num[i+1];
                }
            }
            
        }
        return sum;
    }
}
