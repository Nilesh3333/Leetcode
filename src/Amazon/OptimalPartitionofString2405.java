package Amazon;

import java.util.HashSet;

//https://www.youtube.com/watch?v=CKZPdiXiQf0   for Explanation
//Time Complexity - O(N)  Space Complexity - O(1) as it will have constant data storing like only from a-z character so it is constant
public class OptimalPartitionofString2405 {
    public static void main(String[] args) {
        var ans = partitionString("abacaba");
        System.out.println(ans);
    }

    public static int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(Character c : s.toCharArray()){
            if(set.contains(c)){
                count++;
                set.clear();
            }
            set.add(c);
        }
        return count+1;  //For the final string we need to count so we are adding +1
    }
}
