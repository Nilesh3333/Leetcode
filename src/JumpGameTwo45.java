//Time - O(N), Space - O(1)
//https://www.youtube.com/watch?v=9kyHYVxL4fw&t=1060s&ab_channel=NikhilLohia
public class JumpGameTwo45 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,1,2,3,1,1,2};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int totalJumps =0, coverage =0,lastJumpedIndex =0,destination = nums.length-1;

        for(int i=0;i<=destination;i++){
            coverage = Math.max(coverage,nums[i] + i);
            if(i == lastJumpedIndex){
                totalJumps++;
                lastJumpedIndex = coverage;

                if(coverage >= destination)
                    return totalJumps;
            }
        }

        return totalJumps;
    }
}
