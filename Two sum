class Solution {
    public int[] twoSum(int[] nums, int target) {
        int x = nums.length;
        int temp = 0;
        int[] s = new int[2];
        for (int i = 0; i < x; i++) {
            temp = nums[i];
            for (int j = i + 1; j < x; j++) {
                temp = temp + nums[j];
                if (temp == target) {
                    s[0] = i;
                    s[1] = j;
                }
                temp = temp - nums[j];
            }
        }
        return s;
    }
}
//Example
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
//Runtime: 
61 ms, faster than 9.70% of Java online submissions for Two Sum.
