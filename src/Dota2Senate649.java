/*
One strategy that would pass the judge (although not the most efficient) to think about the problem is for the first character
in the string to move to the back and eliminate the first "opposing" character in the string. So in the case of "DDRRR":

DDRRR - the first D moves to the back and takes out the first R
DRRD - the first D moves to the back and takes out the first R
RDD - the first R moves to the back and takes out the first D
DR - the first (and only) D moves to the back and takes out the first (and only) R
D - D wins the vote.

If you sit down with a piece of paper, you'll be able to solve any of these problems easily.

https://leetcode.com/problems/dota2-senate/solutions/3483399/simple-diagram-explanation/?envType=study-plan-v2&envId=leetcode-75

time and space complexity of O(n)
*/

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate649 {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RD"));
    }
    public static String predictPartyVictory(String senate) {
        Queue<Integer> rad = new LinkedList<>();
        Queue<Integer> dir = new LinkedList<>();
        int n = senate.length();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i) == 'D')
                dir.add(i);
            else
                rad.add(i);
        }
        while (!rad.isEmpty() && !dir.isEmpty()){
            if(rad.peek() < dir.peek())
                rad.add(n++);
            else
                dir.add(n++);
            rad.poll();
            dir.poll();
        }
        return (rad.isEmpty())? "Dire" : "Radiant";
    }
}
