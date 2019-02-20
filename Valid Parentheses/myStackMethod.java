class Solution {
    public boolean isValid(String s) {
       Stack<Character> parenthesesSmall = new Stack<Character>();
	    int length = s.length();
        if(length == 0){
            return true;
        }else{
            if(length % 2 == 1)
            return false;
            char c = s.charAt(0);
            //这一步的代码多余
            if(c == ')' || c == ']' || c == '}')
                return false;
            for(int i = 0; i < length; i++) {
                c = s.charAt(i);
                if(c == '(' || c == '[' || c == '{')
                    parenthesesSmall.push(c);
  
                //没有进行判断，如果栈为空，那么就不能调用pop方法
                if(c == ')') {
                    char left = parenthesesSmall.pop();
                    if(left != '(')
                        return false;
                }
                if(c == ']') {//可以用hashmap进行判断，详见StackMethod.java
                    char left = parenthesesSmall.pop();
                    if(left != '[')
                        return false;
                }
                if(c == '}') {
                    char left = parenthesesSmall.pop();
                    if(left != '{')
                        return false;
                }
            }
        }
		
		if(parenthesesSmall.size() > 0) {//代码多余，可以直接调用isEmpty()方法
			return false;
		}
		
		return true;
    }
}
