/*
https://www.youtube.com/watch?v=ZwDDLAeeBM0&ab_channel=NickWhite
Time Complexity: O(n)
Space Complexity: O(n)
*/

package Su;

public class rob198 {
    public static void main(String[] args) {
        rob198 robObj = new rob198();
        int[] nums ={2,7,9,3,1};
        System.out.println(robObj.rob(nums));
    }

    public int rob(int[] nums) {
        // Create a dp (dynamic programming) array to store intermediate results
        // This array will hold the maximum amount robable up to a certain house
        // considering you cannot rob adjacent houses
        int[] dp = new int[nums.length + 1];

        // Handle the base case: if there are no houses (empty array), no money can be stolen
        if (nums.length == 0) return 0;

        // Initialize the first two elements of the dp array
        dp[0] = 0;                      // dp[0] represents the maximum amount stolen up to the 0th house (which is 0)
        dp[1] = nums[0];                // dp[1] represents the maximum amount stolen up to the 1st house (which is the value in the first house)

        for (int i = 1; i < nums.length; i++) {
            // Consider two options:
            // 1. Not robbing the current house (i): The maximum amount stolen here would be the same
            //   as the maximum stolen up to the previous house (dp[i])
            // 2. Robbing the current house (i): The maximum amount stolen here would be the value in the
            //   current house (nums[i]) plus the maximum amount stolen two houses before (dp[i-2]) since you cannot rob adjacent houses
            // Choose the larger amount between these two options and store it in dp[i+1] which represents
            // the maximum amount stolen up to the current house (i) considering the above constraints
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }

        // Finally, dp[nums.length] will hold the maximum amount of money that can be stolen Considering the entire nums array (all the houses)
        return dp[nums.length];
    }
}
