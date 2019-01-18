public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";    
    return longestCommonPrefix(strs, 0 , strs.length - 1);
}

private String longestCommonPrefix(String[] strs, int l, int r) {// get the final common prefix of all the string
    if (l == r) {
        return strs[l];
    }
    else {
        int mid = (l + r)/2;
        //compare left with right till there is no character mathed
        String lcpLeft =   longestCommonPrefix(strs, l , mid);
        String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
        //lcpLeft is the common prefix of letf and lcpRight is the common prefix of right
        return commonPrefix(lcpLeft, lcpRight);
   }
}

String commonPrefix(String left,String right) {//compare two string to get comom prefix
    int min = Math.min(left.length(), right.length());       
    for (int i = 0; i < min; i++) {
        if ( left.charAt(i) != right.charAt(i) )
            return left.substring(0, i);
    }
    return left.substring(0, min);
}
