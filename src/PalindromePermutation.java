import java.util.HashMap;
import java.util.HashSet;

//Given a string, determine if a permutation of the string could form a palindrome.
//Time Complexity - O(N)  Space Complexity - O(1)
public class PalindromePermutation {
    public static void main(String[] args) {
        String s = "civic";
        System.out.println(STR."\{s} is a PalindromePermutation \{checkPalindrome(s)}");
        System.out.println(STR."\{s} is a PalindromePermutation \{checkPalindrome1(s)}");
        System.out.println(STR."\{s} is a PalindromePermutation \{checkPalindrome2(s)}");
    }

    private static boolean checkPalindrome(String s) {
        int[] countChar = new int[126];
        for(int c : s.toCharArray()){
            countChar[c]++;
        }
        int count =0;
        for(int i : countChar){
            if(i%2 !=0)
                count++;
        }
        return count <=1;
    }

    private static boolean checkPalindrome2(String s) {
        HashSet<Character> set = new HashSet<>();
        for(Character c:s.toCharArray()){
            if(set.contains(c)) set.remove(c);
            else set.add(c);
        }
        return set.size() <=1;
    }

    private static boolean checkPalindrome1(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(Character c : s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        int count =0;
        for(int val : map.values()){
            if(val %2 !=0)
                count++;
        }
        return count <=1;
    }
}
