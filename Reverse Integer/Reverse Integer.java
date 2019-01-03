class Solution {
    public int reverse(int x) {//当x为任意int值时，要考虑int的内存溢出问题
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;//Java中的余数可以为负数
            x /= 10;
            //rev不能溢出int的内存，因此不能rev > Integer.MAX_VALUE/10，或者，当rev == Integer.MAX_VALUE / 10时，即rev=214748364时,不能pop > 7
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
//time compolexity:O(\log(x))
//space complexity:O(1)
/*
Integer.MIN_VALUE= -2147483648 （-2的31次方）；Integer.MAX_VALUE= 2147483647 （2的31次方-1）
01111(31个1);1000(31个0);因为二进制补码换为十进制为（-1）*2的n次方
MAX_VALUE  + 1 == MIN_VALUE 
二进制系统是通过补码来保存数据的。
第一位是符号位，0为正，1为负，当正的除了符号位全为1，再加1就进位了，符号位就会变成1，是负数，其他为0。
*/
