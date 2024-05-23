//Check 1493Solution.jpeg
//Time complexity:O(n) Space complexity:O(1)
public class longestSubarray1493 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,0,1,1,1,0,1};
        int ans = longestSubarray(nums);
        System.out.println(ans);
    }

    public static int longestSubarray(int[] nums) {
        int previousCount=0,nextCount = 0,maxCount =0;
        boolean flag=false;
        for (int num : nums) {
            if (num == 0) {
                maxCount = Math.max(maxCount, nextCount);
                nextCount = previousCount;
                previousCount = 0;
                flag = true;
            } else {
                previousCount++;
                nextCount++;
            }
        }
        if(!flag)
            return nums.length-1;
        return Math.max(maxCount,nextCount);
    }
}
