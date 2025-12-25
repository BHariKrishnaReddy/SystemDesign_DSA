package DSA_patterns.SlidingWindow.Hard;

/*
For every contiguous subarray (window) of size K, compute (maximum − minimum) and return the sum of all these values.

sample
arr = [2, 5, -1, 7, -3, -1, -2]
K = 4

[2, 5, -1, 7]   → max=7,  min=-1 → diff=8
[5, -1, 7, -3]  → max=7,  min=-3 → diff=10
[-1, 7, -3, -1] → max=7,  min=-3 → diff=10
[7, -3, -1, -2] → max=7,  min=-3 → diff=10

Sum = 8 + 10 + 10 + 10 = 38

Maintain max and min with deques; add (max − min) per window. ->   “Two deques → range in O(1).”

*/

import java.util.Deque;
import java.util.LinkedList;

public class SumOfMaxMinusMin {

    public long sumOfDifferences(int[] arr, int k) {
        int n = arr.length;
        long result = 0;

        Deque<Integer> maxDeque = new LinkedList<>(); // decreasing
        Deque<Integer> minDeque = new LinkedList<>(); // increasing

        for (int right = 0; right < n; right++) {

            // Remove elements outside the window
            if (!maxDeque.isEmpty() && maxDeque.peekFirst() <= right - k) {
                maxDeque.pollFirst();
            }
            if (!minDeque.isEmpty() && minDeque.peekFirst() <= right - k) {
                minDeque.pollFirst();
            }

            // Maintain decreasing order for maxDeque
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);

            // Maintain increasing order for minDeque
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);

            // When first window is complete
            if (right >= k - 1) {
                int max = arr[maxDeque.peekFirst()];
                int min = arr[minDeque.peekFirst()];
                result += (max - min);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SumOfMaxMinusMin sol = new SumOfMaxMinusMin();
        System.out.println(
            sol.sumOfDifferences(
                new int[]{2, 5, -1, 7, -3, -1, -2}, 4
            )
        ); // 38
    }
}
