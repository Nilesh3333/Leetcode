package Amazon;

import java.util.*;

//Time and Space Complexity - O(N logN) , O(N)
public class ReorderDataInLogFiles937 {
    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] ans = reorderLogFiles(logs);
        for(String i:ans)
            System.out.println(i);
    }

    public static String[] reorderLogFiles(String[] logs) {
        if(logs.length == 0)
            return logs;
        List<String> numerList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        for(String log : logs){
            if(log.charAt(log.indexOf(" ") +1) < 'a')
                numerList.add(log);
            else
                stringList.add(log);
        }
        /* "1 Alice","2 Bob","3 Alice","4 Charlie"
              "1 Alice" vs "2 Bob": "Alice" < "Bob", so "1 Alice" comes before "2 Bob".
              "2 Bob" vs "3 Alice": "Bob" > "Alice", so "3 Alice" comes before "2 Bob".
              "3 Alice" vs "1 Alice": "Alice" = "Alice", so it compares the original strings "3 Alice" and "1 Alice", and since "1 Alice" < "3 Alice", "1 Alice" comes before "3 Alice".
              "4 Charlie" is compared with others similarly and placed accordingly.*/
        stringList.sort((o1, o2) -> {
            String s1 = o1.substring(o1.indexOf(" ") + 1);
            String s2 = o2.substring(o2.indexOf(" ") + 1);
            //If both s1 and s2 are equal we need to compare the string from the start, so we are comparing o1 and o2 otherwise we can compare the s1 and s2.
            return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
        });

        int i = 0;

        for(String s:stringList)
            logs[i++] = s;

        for(String s:numerList)
            logs[i++] = s;

        return logs;
    }
}
