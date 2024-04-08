/*
Pic - DecodeString394.png
The intuition behind this solution is to use two stacks—one to keep track of the number of times a string needs to be repeated (st1),
and another to store the intermediate results (st2). By iterating through the input string, we build the decoded string by repeating
and concatenating substrings based on the count provided in the input.

Initialize a stack for counts (st1) and another stack for intermediate results (st2).

1.Iterate through the characters of the input string.
2.If a digit is encountered, update the count accordingly.
3.If an opening bracket '[' is encountered, push the current count (n) onto the count stack and reset the count to 0.
Push the current result (sb) onto the result stack and reset the result.
4.If a closing bracket ']' is encountered, pop the count (k) from the count stack and the intermediate result (temp) from the result
stack. Repeat the current result (sb) by appending temp to it k times.
5.If any other character is encountered, append it to the current result (sb).

After processing all characters, the final result is stored in the last sb value.

Complexity
Time complexity:O(n), where n is the length of the input string. Each character is processed once.
Space complexity: O(n), where n is the length of the input string. The space required is proportional to the size of the intermediate result stack (st1).
*/

import java.util.Stack;
public class decodeString394 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
    public static String decodeString(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<StringBuilder> stack2 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n=0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c))
                n = n*10+(c - '0');
            else if(c == '['){
                stack1.push(n);
                n=0;
                stack2.push(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                int times = stack1.pop();
                StringBuilder tempSb = sb;
                sb = stack2.pop();
                while(times-- >0){
                    sb.append(tempSb);
                }
            }
            else
                sb.append(c);
        }
        return sb.toString();
    }
}
