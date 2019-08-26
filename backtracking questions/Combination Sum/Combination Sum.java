class Solution {
    // 回溯法计算组合值，数组没有重复值，每个元素可以重复出现多次
   public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        // 回溯法
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start) {
        // remain标志是否等于target
        // 当remain<0时，代表接着往下遍历的组合肯定无效，因此直接停止这条路径的遍历
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{ 
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                // 每个遍历的节点下面的路径都是从start开始，确保没有重复的组合
                // 每条路径都是从不同的元素开始，因此不会出现重复的组合。
                // not i + 1 because we can reuse same elements
                backtrack(list, tempList, nums, remain - nums[i], i); 
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}