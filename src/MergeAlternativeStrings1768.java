import java.util.*;

//Complexity : O(m+n)
public class MergeAlternativeStrings1768 {
    public static void main(String args[]){
        String mergedString = mergeAlternately("abc", "pqr");
        System.out.println(mergedString); //output : apbqcr
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int i=0,j=0;

        while (i< word1.length() && j<word2.length()){
            str.append(word1.charAt(i));
            str.append(word2.charAt(j));
            i++;
            j++;
        }
        while(i>=word1.length() && j<word2.length()){
            str.append(word2.charAt(j));
            j++;
        }
        while(j>=word2.length() && i<word1.length()){
            str.append(word1.charAt(i));
            i++;
        }
        return str.toString();
    }
}

/*
* Another solution
*
*  int i = 0, j = 0;

        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                str.append(word1.charAt(i));
                i++;
            }
            if (j < word2.length()) {
                str.append(word2.charAt(j));
                j++;
            }
        }
        return str.toString();
*
*
* */