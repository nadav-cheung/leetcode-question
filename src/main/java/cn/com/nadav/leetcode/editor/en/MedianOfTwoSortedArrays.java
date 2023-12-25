/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10⁶ <= nums1[i], nums2[i] <= 10⁶
 * <p>
 * <p>
 * Related Topics Array Binary Search Divide and Conquer 👍 27060 👎 2977
 */

package cn.com.nadav.leetcode.editor.en;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 二分查找
         * 迭代实现
         */
        public int iterationSearch(int[] array, int target) {
            int l = 0;
            int r = array.length;
            // 在 array[l,r）中寻找target
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (array[mid] == target) {
                    return mid;
                } else if (array[mid] < target) {
                    l = mid + 1;
                } else if (array[mid] > target) {
                    r = mid;
                }
            }
            return -1;
        }


        public double findMedianSortedArray(int[] nums1, int[] nums2) {
            // 确保 nums1 是较短的数组
            if (nums1.length > nums2.length) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
                temp = null;  // help gc
            }

            int m = nums1.length;
            int n = nums2.length;
            int left = 0;
            int right = m;
            int halfLength = (m + n + 1) / 2;

            // nums1[i-1] <= nums2[j]
            // nums2[j-1] <= nums1[i]
            // i + j = (n + 1) / 2

            while (left < right) {
                // 两个队列的临时变量
                int i = left + (right - left) / 2;
                int j = halfLength - i;

                if (i < right && nums2[j - 1] > nums1[i]) {
                    left = i + 1; // i is too small
                } else if (i >= left && nums1[i - 1] > nums2[j]) {
                    right = i; // i is too big
                } else { // i is perfect
                    int maxLeft = 0;
                    if (i == 0) {
                        maxLeft = nums2[j - 1];
                    } else if (j == 0) {
                        maxLeft = nums1[i - 1];
                    } else {
                        maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                    }

                    if ((m + n) % 2 == 1) {
                        return maxLeft;
                    }

                    int minRight = 0;
                    if (i == m) {
                        minRight = nums2[j];
                    } else if (j == n) {
                        minRight = nums1[i];
                    } else {
                        minRight = Math.min(nums2[j], nums1[i]);
                    }

                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}