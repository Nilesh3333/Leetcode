//s = "([])(){}(())()()"

import java.util.Stack;
public class isBalanceBrackets {
    public static void main(String[] args) {
        String s = "";
        System.out.println(isBalance(s));
    }

    public static boolean isBalance(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i)=='[')
                stack.push(s.charAt(i));
            else if(!stack.isEmpty() && (s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i)==']')){
                char peek = stack.peek();
                if(peek == s.charAt(i))
                    stack.pop();
                else
                    return false;
            }

            else
                return false;
        }
        return true;
    }
}
