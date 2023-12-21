/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 2 <= nums.length <= 10⁴
 * -10⁹ <= nums[i] <= 10⁹
 * -10⁹ <= target <= 10⁹
 * Only one valid answer exists.
 * <p>
 * <p>
 * <p>
 * Follow-up: Can you come up with an algorithm that is less than
 * O(n²)
 * time complexity?
 * <p>
 * Related Topics Array Hash Table 👍 49902 👎 1613
 */

package cn.com.nadav.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length <= 1) {
                return new int[]{-1, -1};
            }

            // Create a hashmap to store the values and their indices
            Map<Integer, Integer> map = new HashMap<>();

            // Iterate through the array
            for (int i = 0; i < nums.length; i++) {
                // Calculate the complement of the current element
                int complement = target - nums[i];

                // Check if the complement is already in the map
                if (map.containsKey(complement)) {
                    // If it is, return the current index and the index of the complement
                    return new int[]{map.get(complement), i};
                }

                // If not, put the current element and its index in the map
                map.put(nums[i], i);
            }

            // In case there is no solution, though the problem statement assures there is one
            return new int[]{-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}