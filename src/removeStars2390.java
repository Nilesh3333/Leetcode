//Time and Space Complexity - O(n)
import java.util.Stack;

public class removeStars2390 {
    public static void main(String[] args) {
        String ans = removeStars("leet**cod*e");
        System.out.println(ans);
    }

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c:s.toCharArray()){
            if(c == '*' && (!stack.isEmpty())){
                stack.pop();
                continue;
            }
            stack.add(c);
        }
        StringBuilder str = new StringBuilder();
        for(int i=0;i< stack.size();i++)
            str.append(stack.get(i));
        return str.toString();
    }
}
