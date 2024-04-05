//Time Complexity and Space Complexity - O(n)

import java.util.HashMap;
import java.util.HashSet;

public class uniqueOccurrences1207 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,1,1,3};
        boolean ans = uniqueOccurrences(arr);
        System.out.println(ans);
    }

    public static boolean uniqueOccurrences(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:arr)
            map.put(i,map.getOrDefault(i,0)+1);
        for(int i : map.values()){
            if(set.contains(i))
                return false;
            set.add(i);
        }
        return true;
    }
}
