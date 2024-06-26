package Amazon;

import java.util.*;

/*  Time Complexity: O(n * m log m)    Space Complexity: O(n * m)*/
public class GroupAnagrams49 {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = groupAnagrams(strs);
        System.out.println(ans);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();

        for(String s: strs){
            // made char array out of String
            char[] arr=s.toCharArray();
            Arrays.sort(arr);
            // made string again
            String sortedString=String.valueOf(arr);
            // if map don't have sorted string as key...we create new arraylist in it's value
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }
            // adding string in the value
            map.get(sortedString).add(s);
        }
        // at last putting all values of a map inside a arrayList and returning
        return new ArrayList<>(map.values());
    }
}
