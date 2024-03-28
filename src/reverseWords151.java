import java.util.Arrays;
import java.util.stream.Collectors;

//Time and space - O(n)
public class reverseWords151 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        String result =  reverseWords(s);
        System.out.println(result);
    }

    public static String reverseWords(String s) {
        /*
        *     \s+ (with double backslashes) is a regular expression pattern that matches one or more whitespace characters.
              \s+ (with single backslash) is not recognized as a regular expression pattern because the backslash is not escaped, and it's treated as a literal backslash followed by the characters s+.
        * */
        s = s.replaceAll("\\s+", " ").trim();
        String[] arr = s.split(" ");
        int i=0;
        int j = arr.length-1;
        while(i<j){
            String temp = arr[i];
            arr[i]=arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        /*
        *Arrays.stream(arr): This part converts the array arr into a stream of elements. It's achieved using the Arrays.stream() method, which is part of the java.util.Arrays class. This method takes an array as input and returns a sequential Stream with the elements of the array as its source.
        .collect(Collectors.joining(" ")): After converting the array into a stream, we apply the collect() terminal operation on the stream. The collect() method is used to accumulate the elements of the stream into a result container. In this case, we are accumulating the elements into a single string.
        Collectors.joining(" "): This part specifies the Collector used to accumulate the elements. Collectors.joining(" ") is a static factory method provided by the Collectors class, which creates a Collector that concatenates the elements of the stream into a single string. The parameter " " passed to joining() represents the delimiter to be used between the joined elements. In this case, it's a single space.
        * */
        s= Arrays.stream(arr).collect(Collectors.joining(" "));  // or  String.join(" ",arr);
        return s;
    }
}
