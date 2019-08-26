class Solution {
	// 回溯法获得所有可能的排列
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backTrack(list, new ArrayList<>(), nums);
		return list;
	}

	// tempList存放一种排列
	private void backTrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if(tempList.size() == nums.length) {
			list.add(new ArrayList(tempList));
		} else {
			// 深度优先搜索的每个结点都有三种可能
			for(int i = 0; i < nums.length; i++) {
				// 不重复存储值，遍历其中的一种路径
				if(tempList.contains(nums[i]))
					continue;
				tempList.add(nums[i]);
				backTrack(list, tempList, nums);
				//该路径遍历完，又遍历另一条路径
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}