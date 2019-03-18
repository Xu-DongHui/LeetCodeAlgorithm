class Solution
{
    public int divide(int dividend, int divisor)
	{
    //定义除法，被除数是最小值，除以-1时，是最大值
    if(dividend == Integer.MIN_VALUE && divisor == -1)
        return Integer.MAX_VALUE;
    //^运算符，只有不同时，才为true ; sign定义商是否为负数  
		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
    int result = 0;
    //取除数和被除数的正数形式
		long x = Math.abs((long)dividend);
    long y = Math.abs((long)divisor);
    
    //统计被除数共减去多少个除数，即为商
		while(x >= y)
		{
            x -= y;
            result++;
     }
     return result * sign;
    }
}
