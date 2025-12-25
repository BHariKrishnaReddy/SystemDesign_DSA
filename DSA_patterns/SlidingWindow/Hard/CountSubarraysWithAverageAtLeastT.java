package DSA_patterns.SlidingWindow.Hard;

/*
How many contiguous subarrays of length exactly K have an average greater than or equal to T?


Instead of checking:  average ≥ T
You can rewrite it as:  (sum / K) ≥ T  ⇒ sum ≥ K * T

So the problem becomes:
Count subarrays of length K whose sum ≥ K × T
This removes division completely.

At each step:
Add the new element entering the window
Remove the element leaving the window
This keeps the window size exactly K.
*/

public class CountSubarraysWithAverageAtLeastT {

    public int countSubarrays(int[] arr, int k, int t) {
        int target = k * t;
        int sum = 0;
        int count = 0;

        // first window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        if (sum >= target) {
            count++;
        }

        // slide the window
        for (int right = k; right < arr.length; right++) {
            sum += arr[right];       // add new element
            sum -= arr[right - k];   // remove old element

            if (sum >= target) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountSubarraysWithAverageAtLeastT sol =
                new CountSubarraysWithAverageAtLeastT();

        System.out.println(
            sol.countSubarrays(new int[]{2, 4, 6, 8, 10}, 3, 6)
        ); // 2
    }
}
