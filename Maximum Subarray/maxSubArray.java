/*
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*/
class Solution {
    public int maxSubArray(int[] nums) {
       int ans = nums[0], sum = 0;//ans记录曾经出现过的最大的和，sum是从一个地方开始往后累加的值
       for(int i = 0; i < nums.length; i++){
          sum = Math.max(nums[i], sum+nums[i]);//是否要选择新的开头，当前面累加的值，没有当前值大，那么肯定不是最大累加和的一部分，因此从nums[i]开始累加
          ans = Math.max(ans, sum);//记录累加过程中出现过的最大值
       }   
       return ans;//返回最大值
    }
}
