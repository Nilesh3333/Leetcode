package Amazon;

/*
When arranging the string s to avoid adjacent repeated characters, we can adopt a strategy based on organizing the characters into two groups: even and odd indices. By filling all the even indices first, we create a structure where no adjacent characters are the same within this group. Similarly, we proceed to fill the odd indices,
ensuring that adjacent characters within this group are also different from each other.

To begin, we need to determine the frequencies of each character in s, just like we did in the previous approach.

To guarantee a valid rearrangement, we need to ensure that the frequency of the most frequent letter does not exceed half the length
of s, rounded up. If it does, it implies that it is not possible to arrange the string without adjacent repetitions,and we can return an empty string as the result.

We must start by placing the most frequent character of string s in the even positions (0, 2, 4, ...) to ensure the following case doesn't occur:

After the count for the most frequent character has exhausted we can place the remaining characters in the remaining positions.
Once we have finished populating all even indices, we move on to the first odd index and then fill in the odd indices.
*/
public class ReorganizeString767 {
    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
    }

    /*
    Time complexity: O(N). We will have to iterate over the entire string once to gather the counts of each character. Then, we we place each character in the answer which costs O(N).
    Space complexity: O(1). The counter used to count the number of occurrences will incur a space complexity of O(k). Again, one could argue that because k <= 26, the space complexity is constant.
*/
    public static String reorganizeString(String s) {
        char[] count = new char[26];
        for(Character c : s.toCharArray())
            count[c-'a']++;
        int maxCount = 0,letter = 0;
        for(int i=0;i<26;i++){
            if(maxCount < count[i]){
                maxCount = count[i];
                letter = i;
            }
        }

        if(maxCount > (s.length()+1)/2)
            return "";

        char[] ans = new char[s.length()];
        int index = 0;

        // Place the most frequent letter
        while(count[letter] > 0){
            ans[index] = (char) (letter + 'a');
            index+=2;
            count[letter]--;
        }

        // Place rest of the letters in any order
        for(int i=0;i<count.length;i++){
            while(count[i] > 0){
                if(index >= s.length())
                    index = 1;
                ans[index] = (char) (i + 'a');
                index += 2;
                count[i]--;
            }
        }
        return String.valueOf(ans);
    }
}
