class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // 必须要排序，才能处理数组中的重复值
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    // 回溯法
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++) {
            // 当另外一条路径的节点与前面的节点相同，说明该类路径已经遍历过了，因此需要跳过
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    } 
}