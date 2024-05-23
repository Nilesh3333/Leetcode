package Amazon;

import java.util.HashSet;

//Time and Space - O(N)
public class MaximumSumDistinctSubarraywithLengthK2461 {
    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        System.out.println(maximumSubarraySum(nums,3));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long max = 0;
        long sum = 0;
        int j=0;
        for (int num : nums) {
            while (j < nums.length && !set.contains(nums[j]) && set.size() < k) {
                set.add(nums[j]);
                sum += nums[j];
                j++;
            }
            if (set.size() == k)
                max = Math.max(max, sum);
            set.remove(num);
            sum -= num;
        }
        return max;
    }
}
