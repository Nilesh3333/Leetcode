//Time Complexity - O(n), Space Complexity - O(1)
public class findMaxConsecutiveOnes485 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1};
        int ans = findMaxConsecutiveOnes(nums);
        System.out.println(ans);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount=0,count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count = 0;
                continue;
            }
            count++;
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }
}
