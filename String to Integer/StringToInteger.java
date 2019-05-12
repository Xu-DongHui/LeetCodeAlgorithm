class Solution {
    public int myAtoi(String str) {
        //去除字符串首尾的空格
        String sStr = str.trim();
        //用64位的long型标记32位的int，用来处理int的最大值和最小值
        long num = 0;
        boolean flag = true;//标记正负值
        for(int i = 0; i < sStr.length(); i++) {
            char s = sStr.charAt(i);
            if(s == ' ' && i != 0)
                return (int) num;
            else if(s == '-' && i == 0)//判断为负数
                flag = false;
            else if(s == '+' && i == 0);//判断为正数                
            else if(s >= 48 && s <= 57) {//用数字的字符的ASCII码来进行判断
            //else if(s - '0' > 0 && '9' - s >0) 另外一种判断方式
                if(flag)
                    num = num * 10 + (s - 48);
                else
                    num = num * 10 - (s - 48);
                if (flag && num > Integer.MAX_VALUE)
			        return Integer.MAX_VALUE;
		        if (!flag && num < Integer.MIN_VALUE)
			        return Integer.MIN_VALUE;
            }
            else
                break;
        }
        //强制类型转换，返回int值
        return (int) num;
    }
}