//Time - O(N), Space - O(1)
public class Anagram242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("Silent","Tenlis"));
    }
    public static boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for(char c : s.toLowerCase().toCharArray())
            arr[c - 'a']++;
        for(char c : t.toLowerCase().toCharArray())
            arr[c - 'a']--;
        for(int c : arr){
            if(c !=0)
                return false;
        }
        return true;
    }
}
