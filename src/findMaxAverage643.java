//Time complexity:O(n) Space complexity:O(1)  // Check maxVowels1456 for explanation how sliding window works
public class findMaxAverage643 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        int k=4;
        double ans = findMaxAverage(nums,k);
        System.out.println(ans);
    }

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i=0; i<k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for(int i=k; i<nums.length; i++) {
            sum += nums[i] - nums[i-k];  //Then again we will run a for loop from k to the length of the array,
                                        // we will add the new element and remove the nums[i-k], which means the last element(from 1st we are removing),
                                        // it means the window of size will constantly move forward.
            maxSum = Math.max(sum, maxSum);
        }
        return (double)maxSum/k;
    }
}


