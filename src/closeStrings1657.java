/*
* Time complexity:
O(n + 26 * log (26)) ~ O(n),
n is size of given input strings, this occurs due to use of sorting on freq arrays

Space complexity:
O(26) ~ O(1)

* https://www.youtube.com/watch?v=3t-hGNArShE&t=556s&ab_channel=MayurProgrammingClub
* */

import java.util.Arrays;
public class closeStrings1657 {
    public static void main(String[] args) {
        boolean ans = closeStrings("abc","bca");
        System.out.println(ans);
    }

    public static boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())
            return false;
        int[] array1 = new int[26];
        int[] array2 = new int[26];
        for(Character c:word1.toCharArray())  //stroring the frequency of each character in a array.
            array1[c-'a']++;
        for(Character c:word2.toCharArray())
            array2[c-'a']++;
        for(int i=0;i<26;i++){ //checking for both the string has the same letters or not
            if(array1[i] > 0 && array2[i] == 0) return false;
            if(array2[i] > 0 && array1[i] == 0) return false;
        }
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1,array2);
    }
}
