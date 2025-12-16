package DSA_patterns.SlidingWindow.Easy;

public class LongestSubarrayWithatMostKZeroesflipZeroestoOnes {

    public int flipZeros(int[] arr,int k){

        int maxSubarray =0;
        int left =0;
        int zeroCounter = 0;

        for(int r = 0;r<arr.length;r++){

            //expanding
            if(arr[r] == 0){
                zeroCounter++;
            }

            while (zeroCounter > k) {
                if(arr[left]==0){
                    zeroCounter--;
                }
                left++;
            }
            maxSubarray = Math.max(maxSubarray, r - left + 1);
        }



        return maxSubarray;

    }



    

    public static void main(String[] args) {
        
    }
}