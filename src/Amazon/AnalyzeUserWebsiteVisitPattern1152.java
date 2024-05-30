package Amazon;

import java.util.*;

/*
Time Complexity: O(n * k^3) -- outerLoop - line 30 and 3 inner loops so n * k^3
Space Complexity: O(n * k) --  line 19 storing username with hashmap of time and website
*/
public class AnalyzeUserWebsiteVisitPattern1152 {
    public static void main(String[] args) {
        String[] username = {"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
        int[] timestamp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] website = {"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};
        List<String> ans = mostVisitedPattern(username,timestamp,website);
        for(String i : ans)
            System.out.println(i);
    }
    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        var map = new HashMap<String, Map<Integer, String>>();
        /*Step 1: Organize Visits
        First, the code creates a HashMap named data to organize visits by each user. The key is the username, and the value is another Map,
        where the key is the timestamp and the value is the website visited at that timestamp. It uses a TreeMap for the inner map to ensure that visits are automatically sorted by timestamp.*/
        for (int i = 0; i < username.length; i++) {
            map.computeIfAbsent(username[i], o -> new TreeMap<>()).put(timestamp[i], website[i]);
        }

        var patternCount = new HashMap<String, Integer>();
        var maxPattern = "";
        var maxCnt = 0;
        for (Map<Integer, String> m : map.values()) {
            /*Step 2: Find Patterns
            Next, for each user, it generates all possible combinations of three-website visit patterns.
            It does this by first converting the values of the TreeMap (websites visited in chronological order) into an ArrayList.*/
            var list = new ArrayList<>(m.values());
            var uniquePatterns = new HashSet<String>();
            if (list.size() < 3) continue;

            /*Step 3: Count Unique Patterns
            It then uses three nested loops to generate all unique combinations of three websites (patterns) that a user has visited.
            These patterns are created by appending the website names together, separated by a period ".".   */
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        var builder = new StringBuilder();
                        var pattern = builder.append(list.get(i)).append(".")
                                .append(list.get(j)).append(".")
                                .append(list.get(k)).toString();


                        /*For each unique pattern (ensured by adding to a HashSet named uniqueStrings), the code updates patternCount, a HashMap that tracks how many times each pattern occurs across all users.
                        Step 4: Identify the Most Visited Pattern
                        While generating and counting patterns, the code also keeps track of the most visited pattern (maxPattern) and its count (maxCnt).
                        It updates maxPattern and maxCnt if it finds a pattern with a higher count than the current maxCnt,
                        or if the counts are equal but the new pattern is lexicographically smaller than maxPattern.*/

                        if (uniquePatterns.add(pattern)) {  //Line 31 Creation of hashset
                            patternCount.merge(pattern, 1, Integer::sum);
                            //the second condition is for lexicographically pattern
                            if (patternCount.get(pattern) > maxCnt || (patternCount.get(pattern) == maxCnt && pattern.compareTo(maxPattern) < 0)) {
                                maxCnt = patternCount.get(pattern);
                                maxPattern = pattern;
                            }
                        }
                    }
                }
            }
        }
        return Arrays.asList(maxPattern.split("\\."));
    }
}
