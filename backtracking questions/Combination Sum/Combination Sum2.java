class Solution {
    // 回溯法，数组元素值会重复，每个元素只能使用一次
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        // 原数组排序
        Arrays.sort(candidates);
        backTrace(list, new ArrayList<Integer>(), candidates, 0, target);
        return list;
    }
    
    // 回溯法
    private void backTrace(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start, int remain) {
        if(remain < 0)
            return;
        else if(remain == 0)
            list.add(new ArrayList(tempList));
        else {
            for(int i = start; i < nums.length; i++) {
                // 跳过重复值
                if(i > start && nums[i] == nums[i - 1])
                    continue;
                tempList.add(nums[i]);
                // start = i + 1使每个元素只能使用一次，遍历所有不重复的组合
                backTrace(list, tempList, nums, i + 1, remain - nums[i]);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}