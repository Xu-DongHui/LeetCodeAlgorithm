class Solution {
    //求数组元素所有的排列，数组元素有重复值
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // 排序可以方便筛选重复值
        Arrays.sort(nums);
        // 回溯算法
        backTrace(list, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return list;
    }
    
    // list存储所有可能的组合；tempList记录一种组合；nums数组元素；used判断数组元素是否在tempList内
    private void backTrace(List<List<Integer>> list, List tempList, int[] nums, boolean[] used) {
        // 一种组合
        if(tempList.size() == nums.length) {
            list.add(new ArrayList(tempList));
        } else {
            // 回溯法：深度优先遍历，每一层都以数组元素为节点
            for(int i = 0; i < nums.length; i++) {
                // 如果元素i在组合内，则遍历另外一条路径
                // 如果元素i和元素i-1相同，并且元素i-1已经遍历完，则可以跳过。如果元素i-1还在遍历中，则不能跳过
                if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                used[i] = true;
                tempList.add(nums[i]);
                backTrace(list, tempList, nums, used);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
        
    }
}