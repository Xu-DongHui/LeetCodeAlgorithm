class Solution {
    //将数组变为下一个更大的数组，如果已经是最大了，那么就返回该数组组成的最小值
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //从数组右边开始遍历，找到第一个a[i-1] < a[i]的值（就可以换一个大的值到a[i-1]，增大数组的值，右边是从大到小的）
        while(i >= 0 && nums[i + 1] <= nums[i])
            i--;
        //将a[i-1]和右边的最小元素交换（增大数组值）
        if(i >= 0) {
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        //将交换后的a[i-1]的右边的值逆序（就获得了最小的增大的数组值）
        reverse(nums, i + 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int n) {
        int i = n, j = nums.length - 1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}