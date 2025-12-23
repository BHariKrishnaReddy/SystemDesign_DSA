package DSA_patterns.SlidingWindow.Hard;

/*
What is the length of the longest contiguous subarray that can be rearranged to form a sequence of consecutive integers (with no gaps and no duplicates)?
*/

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveRearrangedSubarray {

    public int longestSubarray(int[] arr) {
        int n = arr.length;
        int maxLen = 0;

        for (int left = 0; left < n; left++) {
            Set<Integer> seen = new HashSet<>();
            int min = arr[left];
            int max = arr[left];

            for (int right = left; right < n; right++) {

                // duplicate breaks the condition
                if (seen.contains(arr[right])) {
                    break;
                }

                seen.add(arr[right]);
                min = Math.min(min, arr[right]);
                max = Math.max(max, arr[right]);

                int windowLen = right - left + 1;

                // check consecutive condition
                if (max - min + 1 == windowLen) {
                    maxLen = Math.max(maxLen, windowLen);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestConsecutiveRearrangedSubarray sol =
                new LongestConsecutiveRearrangedSubarray();

        System.out.println(sol.longestSubarray(new int[]{10, 12, 11}));      // 3
        System.out.println(sol.longestSubarray(new int[]{1, 2, 2, 3}));     // 2
        System.out.println(sol.longestSubarray(new int[]{1, 3, 2, 5, 4}));  // 5
    }
}

