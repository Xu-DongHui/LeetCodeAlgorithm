class Solution {
    public int reverse(int x) {
      String stringx = new Integer(x).toString();//int转string
      boolean isNegative = stringx.startsWith("-");//string自带的检验开头的字符串
      StringBuffer s = new StringBuffer(stringx);//sting转为StringBuffer拥有更多的方法
      if(isNegative){
        s.delete(0,1);//删除字符串的某个位置的值

      }
      s.reverse();
          try{
        return isNegative? Integer.parseInt(s.toString())*(-1):Integer.parseInt(s.toString());//String转int
      }catch(NumberFormatException e){//防治产生的转置值超过内存，可以捕捉异常
        return 0;
      }
    }
}
