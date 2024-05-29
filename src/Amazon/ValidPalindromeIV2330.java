package Amazon;

//The loop runs O(n/2) times where n is the length of the string. Since constants are ignored in asymptotic analysis,
// this simplifies to O(n).
/*
    Time Complexity: O(n)
    Space Complexity: O(1)
*/
public class ValidPalindromeIV2330 {
    public static void main(String[] args) {
        System.out.println(makePalindrome("abcdba"));
    }
    public static boolean makePalindrome(String s) {
        int i=0,j=s.length()-1,count=0;
        while(i<j){
            if(count > 3)
                return false;
            if (s.charAt(i) != s.charAt(j))
                count++;
            i++;
            j--;
        }
        return true;
    }
}
