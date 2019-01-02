class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {//specail case 0 and negative numbers
            return false;
        }
        
        int revertedNumber = 0;
        while(x > revertedNumber) {//revert the last half of the number
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        
        return (x == revertedNumber) || (x == revertedNumber/10);
    }
}
//time complexity: O(log10(n)). We divided the input by 10 for every iteration, so the time complexity isO(log10(n))
//space complexity:O(1)
