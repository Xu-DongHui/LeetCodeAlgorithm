class Solution
{
    public int divide(int dividend, int divisor)
	{
    if(dividend == Integer.MIN_VALUE && divisor == -1)
        return Integer.MAX_VALUE;
        
		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
    int result = 0;
		long x = Math.abs((long)dividend);
    long y = Math.abs((long)divisor);

		while(x >= y)
		{
       int shift = 1;
      //将y持续向左移位，相当于y*2^(shift);
      //当y*2^(shift)< x <y*2^(shift+1)时，循环结束
      while(x >= (y << shift))
      {
          shift++;
      }
      x -= y << (shift - 1);
      //相当于x = y*2^(shift)+y*2^(shift-n)+.....+y*2^(0) + m;m是余数
      result += 1 << (shift - 1);
    }
    return result * sign;
    }
}
