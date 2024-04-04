//check 1493Solution for explanation of this code
/** Problem Statement:
Given a binary array nums, you can flip at most one 0 to obtain the maximum number of consecutive 1's.
* Input: nums = [1,0,1,1,0]
Output: 4
Explanation: Flip the first 0 will get the maximum number of consecutive 1s.
After flipping, the maximum number of consecutive 1s is 4.
* */

public class findMaxConsecutiveOnes487 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,0,1,1,1,0,1,1};
        int ans = findMaxConsecutiveOnes(nums);
        System.out.println(ans);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int currentCount=0,nextCount=0,maxCount=0;
        boolean flag= false;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                maxCount = Math.max(maxCount,nextCount);
                nextCount = currentCount;
                currentCount=0;
                flag = true;
            }
            else{
                currentCount++;
                nextCount++;
            }
        }
        if(!flag)
            return nums.length;
        return Math.max(maxCount,nextCount)+1;
    }
}
