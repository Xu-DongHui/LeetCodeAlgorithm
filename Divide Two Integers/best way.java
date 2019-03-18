class Solution
{
    public int divide(int dividend, int divisor)
	{
    if(dividend == Integer.MIN_VALUE && divisor == -1)
        return Integer.MAX_VALUE;
        
		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
    int result = 0;
    int power = 32;
    //long是8字节，64位；int是4字节，32位
    long x = Math.abs((long)dividend);
    long y = Math.abs((long)divisor);
        
    while(x >= y)
		{
      //将y*2^32增加到最大，然后逐步减小，靠近x
      //y*2^power<x时结束
        while((y << power) > x)
        {
           //每次只需要执行有限步就能找到power，不想beter way中的方法，是执行O(n)步才能找到
           power--;
        }
        x -= y << power;
        result += 1 << power;
     }
     return result * sign;
   }
}
