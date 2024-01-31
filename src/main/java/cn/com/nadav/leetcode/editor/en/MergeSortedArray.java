/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, representing the number of elements in nums1 and
 * nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be
 * stored inside the array nums1. To accommodate this, nums1 has a length of m + n,
 * where the first m elements denote the elements that should be merged, and the
 * last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming
 * from nums1.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to
 * ensure the merge result can fit in nums1.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10⁹ <= nums1[i], nums2[j] <= 10⁹
 * <p>
 * <p>
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 * <p>
 * Related Topics Array Two Pointers Sorting 👍 13827 👎 1672
 */

package cn.com.nadav.leetcode.editor.en;

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge1(int[] nums1, int m, int[] nums2, int n) {
            int[] sorted = new int[m + n];
            int p1 = 0;
            int p2 = 0;
            int currentValue;
            while (p1 < m || p2 < n) {
                if (p1 == m) {
                    currentValue = nums2[p2++];
                } else if (p2 == n) {
                    currentValue = nums1[p1++];
                } else if (nums1[p1] >= nums2[p2]) {
                    currentValue = nums2[p2++];
                } else {
                    currentValue = nums1[p1++];
                }
                sorted[p1 + p2 - 1] = currentValue;
            }
            for (int i = 0; i != m + n; ++i) {
                nums1[i] = sorted[i];
            }
        }

        public void merge2(int[] nums1, int m, int[] nums2, int n) {
            int position = m-- + n-- - 1;
            while (m >= 0 && n >= 0) {
                nums1[position--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            }
            while (n >= 0) {
                nums1[position--] = nums2[n--];
            }
        }

        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int tail = m + n - 1;
            int cur;
            while (p1 >= 0 || p2 >= 0) {
                if (p1 == -1) {
                    cur = nums2[p2--];
                } else if (p2 == -1) {
                    cur = nums1[p1--];
                } else if (nums1[p1] >= nums2[p2]) {
                    cur = nums1[p1--];
                } else {
                    cur = nums2[p2--];
                }
                nums1[tail--] = cur;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}