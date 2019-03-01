class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;//i
        while (iMin <= iMax) {//每次循环长度都变为原来的1/2
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            //调整i
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;//得到左边部分的最大值
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                //当两个数组总长度为奇数时，只需返回左边的最大值即可
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;//得到右边部分的最小值
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }
                 //当两个数组总长度为偶数时，只需返回左右两边最大值的平均值
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
