/*
* Vowel Count Calculation for First Substring:
for(int i = 0; i < k; i++) { ... }
In this loop, it iterates from index 0 to k - 1 to calculate the vowel count for the first substring of length k.
For each character within this substring, it checks if it is a vowel using the checkVowels method and increments count if it is.

Sliding Window Technique:
for(int i = k; i < s.length(); i++) { ... }
In this loop, it employs the sliding window technique to iterate from index k to s.length() - 1.
It slides the window by removing the leftmost character (s.charAt(i - k)) and adding the rightmost character (s.charAt(i)).

Updating Vowel Count:
if(checkVowels(s.charAt(i - k))) count--;
Decrements count if the character being removed from the window (s.charAt(i - k)) is a vowel.
if(checkVowels(s.charAt(i))) count++;
 Increments count if the character being added to the window (s.charAt(i)) is a vowel.


Consider the input string s = "leetcode" and k = 3.
Initialization:
s = "leetcode", k = 3.
Iteration for the First Substring:
For the first substring "lee", the vowel count is 2 ('e' occurs twice).
count = 2.

Sliding Window Technique:
Now, we slide the window by moving to the next character.
The window moves from "lee" to "eet".
As we remove 'l' from the left and add 't' from the right, we update the vowel count.
Vowel count changes from 2 to 1.

Updating Max Count:
The maximum count encountered so far is 2.
maxCount = 2.

Continuing the Sliding Window:
We continue to slide the window until it reaches the end of the string.
At each step, we update the vowel count and check if it exceeds the maximum count encountered so far.

    Final Result:
        After processing all substrings of length k, we find that the maximum vowel count is 2 for the substring "lee".

    Return:
        The method returns 2, which is the maximum count of vowels in substrings of length k within the string s.
* */
public class maxVowels1456 {
    public static void main(String[] args) {
        int ans = maxVowels("leetcode",3);
        System.out.println(ans);
    }

    public static int maxVowels(String s, int k) {
        int count=0;
        for(int i=0;i<k;i++) {   // In this loop we are calaculating the vowel count until the k length
            boolean x = checkVowels(s.charAt(i));
            if(x)
                count++;
        }
        int maxCount = count;
        for(int i=k;i<s.length();i++){  // in this loop we are calculating the count from k to s.length.
                                        //we are sliding the pointer here s.charAt(i-k) this will give the 1st value we are minusing
                                        //that value and adding the s.charAt(i)) new value so that we are sliding
            if(checkVowels(s.charAt(i-k)))
                count--;
            if(checkVowels(s.charAt(i)))
                count ++;
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }
    public static boolean checkVowels(Character c){
        c = Character.toLowerCase(c);
        return (c == 'a' || c == 'e' || c== 'i' || c == 'o' || c == 'u') ? true : false;
    }
}
