class Solution {
    // 3sum的升级版：定位前两位数，然后再遍历出后两位数
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> fourSumList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            // 跳过重复值
           if(i != 0 && nums[i] == nums[i - 1])
               continue;
           for(int j = i + 1; j < nums.length - 2; j++) {
               if(j != i + 1 && nums[j] == nums[j - 1])
                   continue;
               int temp = target - nums[i] - nums[j];
               int l = j + 1;
               int r = nums.length - 1;
               while(l < r) {
                   int sum = nums[l] + nums[r];
                   if(sum < temp) {
                       l++;
                       while(nums[l] == nums[l - 1] && l < nums.length - 1) 
                           l++;
                   } else if(sum > temp) {
                       r--;
                       while(nums[r] == nums[r + 1] && r > 0)
                           r--;
                   } else {
                       fourSumList.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                       r--;
                       l++;
                       while(nums[r] == nums[r + 1] && r > 0)
                           r--;
                       while(nums[l] == nums[l - 1] && l < nums.length - 1) 
                           l++;
                   }
               }
           }
        }
        return fourSumList;
    }
}