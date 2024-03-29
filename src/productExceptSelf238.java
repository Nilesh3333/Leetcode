//Time and Space Complexity - O(n)
public class productExceptSelf238 {
    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,4};
        nums = productExceptSelf(nums);
        for(int i:nums){
            System.out.println(i);
        }
    }

    // you can compute the product of all elements to the left of each element and the product of all elements to the right
    // of each element separately, and then combine these two products to obtain the final result.
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // Arrays to store the products of elements to the left and right of each index
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];

        // Initialize the leftProducts and rightProducts arrays
        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }
        rightProducts[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }

        // Compute the final product except self
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }

        return result;
    }
}
                //or see this Solution

/*public static int[] productExceptSelf(int[] nums) {
    int[] productOfNumbers= new int[nums.length];
    int productExceptZero = 1;
    int zeroCount = 0;
    for(int i : nums){
        if(i == 0){
            zeroCount++; //Calculating the zero count
            continue;
        }
        productExceptZero *= i;  //calculating the product of all elements except zero
    }

    if(zeroCount >1)
        return productOfNumbers;  //if the zero count is grater than 1 then there is no use all the elements products will be 0

    if(zeroCount == 1){ //if the count is 1 then there is only one element which will have value remaining all will be zero
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                productOfNumbers[i] = productExceptZero;
                break;
            }
        }
        return productOfNumbers; // so we are returing the array becuase there is no need to check the remaining everything will be Zero if we multiply with 0
    }

    //For remaining elements except Zeros we have the product of all number in the array and we are dividing it with the
    // currect element so that we can get the product of all other elements except the current element
    for(int i=0;i<nums.length;i++)
        productOfNumbers[i] = productExceptZero / nums[i];

    return productOfNumbers;
}*/

/*
public static int[] productExceptSelf(int[] nums) {
    int[] productOfNumbers= new int[nums.length];
    Arrays.fill(productOfNumbers,1);
    for(int i=0;i<nums.length;i++){
        int product = 1;
        for (int j=0;j<nums.length;j++){
            if(i == j)
                continue;
            else
                product = nums[j] * product;
        }
        productOfNumbers[i] = product;
    }
    return productOfNumbers;

}
*/
