//Time and Space Complexity - O(n), O(1)
public class maxArea11 {
    public static void main(String[] args) {
        int[] height= new int[]{2,3,4,5,18,17,6};
        int ans = maxArea(height);
        System.out.println(ans);
    }

    /*
    * Height Constraint: Consider two vertical lines from the array. The height of the container formed by these lines is limited by
    the height of the shorter line. Think of it like pouring water into a container—no matter how tall one side of the container is,
    the water level will be limited by the height of the shorter side.

     Width Constraint: The width of the container is determined by the horizontal distance between the lines. As you move the pointers
     towards the center, you increase the width of the container. Think of it like widening the base of the container—it allows more
     water to be held within.

     Optimality: To maximize the area of the container, you want to maximize both the height and the width. If you move the pointer
     with the larger height towards the center, you decrease the height of the container, which reduces the potential area.
     On the other hand, moving the pointer with the smaller height towards the center maintains or increases the height of the
     container, allowing you to explore all possible pairs of lines and maximize the area.

     Overall, by moving the pointer with the smaller height towards the center, you ensure that you systematically explore all pairs of
     lines and calculate the area formed by them, leading to finding the maximum possible area
    * */
    public static int maxArea(int[] height) {

        int i=0,j = height.length-1;
        int length=0,width=0,area=0;
        while(i !=j) {
            width = j - i;
            length = Math.min(height[i], height[j]);  //we are taking the min height --> if we take the max of both the water will overflow
            area = Math.max(area, length * width);
            if (height[i] < height[j])    //if the height is less that the other we are moving it to next read the above matter
                i++;
            else
                j--;
        }
        return area;
    }
}
