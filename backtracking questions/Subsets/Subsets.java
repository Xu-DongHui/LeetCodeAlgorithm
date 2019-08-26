class Solution {
	//回溯法思路描述：把问题的解空间转化成了图或者树的结构表示，然后使用深度优先搜索策略进行遍历，
	//遍历的过程中记录和寻找所有可行解或者最优解。
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer> list = new ArrayList<>();
		//可要可不要，保证深度优先搜索时，搜索的路径不重复
		Array.sort(nums);
		//从头节点开始遍历
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		// 1.在遍历过程中，存储路径
		// 2.new ArrayList(templist)存储的每条路径都是单独的对象，如果存储templist地址，就会使最后存储的元素都是同一个元素
		list.add(new ArrayList(templist));
		// 保证遍历的路径不重复，代表第一层的可能的路径
		for(int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			// 回溯到第二层，并且路径上的节点不重复
			backtrack(list, templist, nums, i + 1);
			// 当当前路径已经遍历到头了，就返回上一层，遍历其他的路径
			tempList.remove(tempList.size() - 1);
		}

	}
}