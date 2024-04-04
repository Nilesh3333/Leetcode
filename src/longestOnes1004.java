/*Intuition
The intuition behind this solution is to use a sliding window approach to find the longest subarray with at most k zeros.
The idea is to keep track of the number of zeros within the current window and adjust the window accordingly to satisfy the constraint.

Approach
Initialize two pointers, left and right, both set to the beginning of the array.
Move the right pointer to the right, and if the element at the right position is 0, increment the zeroCount.
Enter a while loop to check if the number of zeros within the current window is greater than k. If true, move the left pointer to the right until the window satisfies the constraint.
Update the maxOnes by calculating the length of the current window (right - left + 1).
Continue the process until the right pointer reaches the end of the array.
Return the maximum length of a subarray with at most k zeros.

Complexity
Time complexity: O(n)
The left and right pointers traverse the array once.
Space complexity: O(1)
The algorithm uses a constant amount of extra space, regardless of the input size.*/

public class longestOnes1004 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int ans = longestOnes(nums,2);
        System.out.println(ans);
    }

    public static int longestOnes(int[] nums, int k) {
        int i=0,j=0,maxCount=0,zeroCount=0;
        while (j<nums.length){
            if(nums[j] == 0)
                zeroCount++;
            while (zeroCount>k){
                if(nums[i] == 0)
                    zeroCount--;
                i++;
            }
            maxCount = Math.max(maxCount,j-i+1);
            j++;
        }
        return maxCount;
    }
}
