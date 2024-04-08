/*
* Time Complexity:
    The outer loop iterates over each element in the asteroids array, which has n elements. Therefore, the time complexity of the outer loop is O(n).
    Within the outer loop, there is a while loop. In the worst case, this while loop can iterate over all elements in the stack,
    resulting in a time complexity of O(n) for each iteration of the outer loop.
    Since there are no nested loops or recursive calls, the overall time complexity is O(n^2), where n is the number of elements in the asteroids array.
*Space Complexity - O(n)
* */
import java.util.Stack;
public class asteroidCollision735 {
    public static void main(String[] args) {
        int[] asteroids = new int[]{5,10,-5};
        asteroids = asteroidCollision(asteroids);
        for(int i:asteroids)
            System.out.println(i);
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i : asteroids){
            int n=1;
            while ((!stack.isEmpty() && stack.peek() > 0 && i < 0 )){
                if(stack.peek() < Math.abs(i)){  // Checking if the peek < abs(i) if yes we are pop the peek element
                    stack.pop();
                    continue;
                }
                else if (stack.peek() == Math.abs(i))  // both the peek and abs(i) are equal they both will collide, so we need to pop
                        stack.pop();                  //the peek element and skip the current element for that we have initialized n.
                n=0;    //to skip the current element to get added to the stack (peek == abs(i)) || peek > abs(i))
                        //in peek>abs(i)  we no need to add it to the stack
                break;
            }
            if(n!=0)
                stack.push(i);
        }
        int[] result = stack.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}
