public class moveZeroes283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        nums = moveZeroes(nums);
        for(int i : nums)
            System.out.println(i);
    }

    public static int[] moveZeroes(int[] nums) {
        int i=0,j=1;
        while (i<nums.length && j<nums.length){
            int temp=nums[i];
            if(nums[i] == 0 && nums[j]!=0){
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j++;
            }
            else
                i++;
            j++;
        }
        return nums;
    }
}
