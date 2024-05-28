package Amazon;


import java.util.Arrays;

/*We keep most frequent characters on lowest no of press , so the first most frequent 9 chars will go on first press,
and then other 9 and then rest on 3rd.So we maintain a chars frequency array and sort it .loop the array add the number of presses .*/

/*Time Complexity: O(n)   Sorting the fixed-size array of length 26 (number of letters in the alphabet) takes O(k log k) time,
  where k is 26. Since 26 is a constant, this operation is effectively O(1) in terms of the input size n.
  Space Complexity: O(1)
  */
public class MinimumNumberofKeypresses2268 {
    public static void main(String[] args) {
        System.out.println(minimumKeypresses("apple"));
    }
    public static int minimumKeypresses(String s) {
        int[] array = new int[26];
        for(Character str : s.toCharArray())
            array[str - 'a'] +=1;
        Arrays.sort(array);  //sorting the array in ascending order so the most frequent letter will go last
        int count = 0,result = 0;
        int increment = 1;
        for(int i=25;i>=0;i--){
            if(array[i] > 0){
                result += array[i] * increment;   //here for the 1st 9 most frequent letters are incremented by 1.
                count +=1;
                if(count == 9){                 //after the 1st 9 we need to double tap the same number to get the letter so we are keeping the count
                    increment++;
                    count =0;
                }
            }
        }
        return result;
    }
}
