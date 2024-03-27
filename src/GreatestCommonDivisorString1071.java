
/**
 * Greatest Common Divisor (GCD) with an example.Let's say we want to find the GCD of two numbers: 24 and 36.
To find the GCD, we can use the Euclidean algorithm:
    First, we divide the larger number by the smaller number:
        36 / 24 = 1 with a remainder of 12
    Now, we replace the larger number with the smaller number, and the smaller number with the remainder:
        New larger number = 24
        New smaller number = 12
    Next, we repeat the process until the remainder is 0:
        24 / 12 = 2 with a remainder of 0
Since the remainder is now 0, the GCD is the divisor from the previous step, which is 12.

So, the GCD of 24 and 36 is 12.
* */
public class GreatestCommonDivisorString1071 {
    public static void main(String args[]){
        String gcdString = gcdOfStrings("ABCABC","ABC");
        System.out.println(gcdString);
    }

    public static String gcdOfStrings(String str1, String str2) {
        //Checking if the str1+str2 == str2+str1 so that we will know whether it is valid string or not
        if(!(str1 + str2).equals(str2+str1))
            return "";
        //Finding the GCD Value
        int gcd = findGCD(str1.length(),str2.length());
        return str1.substring(0,gcd);
    }

    public static int findGCD(int str1,int str2){
        //baseCase
        if(str2 == 0)
            return str1;
        else
            return findGCD(str2,str1%str2);
    }
}