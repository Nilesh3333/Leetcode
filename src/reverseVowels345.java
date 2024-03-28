//Time and Space complexity - O(n)
public class reverseVowels345 {
    public static void main(String[] args) {

        String result = reverseVowels("hello");
        System.out.println(result);
    }

    public static String reverseVowels(String s) {
        int i=0,j=s.length()-1;
        char[] arr = s.toCharArray();
        while (i<=j){
            char a = arr[i];
            char b = arr[j];
            if((checkVowel(a) && checkVowel(b))){
                if((!checkVowel(a) && !checkVowel(b))){
                    i++;
                    j--;
                    continue;
                }
                arr[i] = b;
                arr[j] = a;
                i++;
                j--;
            }
            else if(!checkVowel(a))
                i++;
            else
                j--;
        }
        /*
        * the valueOf() method is a static method defined in various classes, including String, Integer, Boolean, etc. Its purpose is to convert different data types to their corresponding wrapper class objects or strings.

            Here's a brief overview of how valueOf() works in different contexts:

    String Class:
        In the String class, valueOf() converts various data types (e.g., int, double, char, boolean, etc.) to their string representation.
        Example: String.valueOf(123) returns the string "123". or String.valueOf(arr) // "hello"
        * */

        return String.valueOf(arr); //or new String(arr);
    }
    public static boolean checkVowel(char c){
        c= Character.toLowerCase(c);
        if(c == 'a' || c == 'e' || c=='i'|| c=='o'|| c == 'u')
            return true;
        else
            return false;
    }
}


/*
* public class ReverseVowels {
    public static void main(String[] args) {
        String result = reverseVowels("hello");
        System.out.println(result);
    }

    public static String reverseVowels(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        char[] charArray = s.toCharArray();
        int i = 0, j = charArray.length - 1;

        while (i < j) {
            while (i < j && !isVowel(charArray[i])) {
                i++;
            }
            while (i < j && !isVowel(charArray[j])) {
                j--;
            }
            if (i < j) {
                swap(charArray, i, j);
                i++;
                j--;
            }
        }
        return new String(charArray);
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

*
* */
