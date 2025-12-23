package DSA_patterns.SlidingWindow.Hard;

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
