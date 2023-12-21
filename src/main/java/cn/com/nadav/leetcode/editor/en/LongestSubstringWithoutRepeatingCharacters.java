/**
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 0 <= s.length <= 5 * 10⁴
 * s consists of English letters, digits, symbols and spaces.
 * <p>
 * <p>
 * Related Topics Hash Table String Sliding Window 👍 38186 👎 1750
 */

package cn.com.nadav.leetcode.editor.en;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }

            int left = 0;
            int maxLength = 0;
            Set<Character> charSet = new HashSet<>(s.length());

            for (int right = 0; right < s.length(); right++) {
                if (!charSet.contains(s.charAt(right))) {
                    charSet.add(s.charAt(right));
                    maxLength = Math.max(maxLength, right - left + 1);
                } else {
                    while (charSet.contains(s.charAt(right))) {
                        charSet.remove(s.charAt(left));
                        left++;
                    }
                    charSet.add(s.charAt(right));
                }
            }
            return maxLength;
        }

        public int lengthOfLongestSubstringUseMap(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }

            int left = 0;
            int maxLength = 0;
            Map<Character, Integer> charMap = new HashMap<>(s.length());

            for (int right = 0; right < s.length(); right++) {
                if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
                    charMap.put(s.charAt(right), right);
                    maxLength = Math.max(maxLength, right - left + 1);
                } else {
                    left = charMap.get(s.charAt(right)) + 1;
                    charMap.put(s.charAt(right), right);
                }
            }
            return maxLength;
        }

        public int lengthOfLongestSubstringUseArray(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }

            int n = s.length();
            int maxLength = 0;
            int[] charIndex = new int[128];
            Arrays.fill(charIndex, -1);
            int left = 0;

            for (int right = 0; right < n; right++) {
                if (charIndex[s.charAt(right)] >= left) {
                    left = charIndex[s.charAt(right)] + 1;
                }
                charIndex[s.charAt(right)] = right;
                maxLength = Math.max(maxLength, right - left + 1);
            }

            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}