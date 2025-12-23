package DSA_patterns.SlidingWindow.Hard;

import java.util.Deque;
import java.util.LinkedList;

public class LongestSubarrayMaxMinDiff {

    public int longestSubarray(int[] arr, int x) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < arr.length; right++) {

            // maintain decreasing deque for max
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] < arr[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);

            // maintain increasing deque for min
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] > arr[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);

            // shrink window if invalid
            while (arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x) {
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                left++;
            }

            // update longest valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubarrayMaxMinDiff sol = new LongestSubarrayMaxMinDiff();
        System.out.println(sol.longestSubarray(new int[]{8, 2, 4, 7}, 4)); // 2
    }
}

