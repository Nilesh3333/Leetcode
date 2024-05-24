package Amazon;

/*
Time Complexity: O(min(m, n))   //The loop terminates when either i reaches the end of s or j reaches the end of t so.
Space Complexity: O(1)*/
public class AppendCharacterstoStringtoMakeSubsequence2486 {
    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching","coding"));
        System.out.println(appendCharacters("abcde","a"));
        System.out.println(appendCharacters2("coaching","coding"));
        System.out.println(appendCharacters2("abcde","a"));
    }

    //code 1
    public static int appendCharacters(String s, String t) {  //Used 2 pointer approach traversed 2 two strings and returning t.length-1
        int i=0,j=0;
        if(s.isEmpty() || t.isEmpty())
            return 0;
        while(i!= s.length() && j!=t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else
                i++;
        }
        return t.length() == j? 0 : t.length()-j;
    }

    //code 2 Refactored
    public static int appendCharacters2(String s, String t) {
        int i=0,j=0;
        while(i!= s.length() && j!=t.length()){
            if(s.charAt(i) == t.charAt(j))
                j++;
            i++;
        }
        return t.length()-j;
    }
}
