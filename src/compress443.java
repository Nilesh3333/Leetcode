//Time and space - O(n)
public class compress443 {
    public static void main(String[] args) {
        char c[]= new char[]{'a','a','b','b','c','c','c'};
        System.out.println(compress(c));
    }

    public static int compress(char[] chars) {
        StringBuffer str= new StringBuffer();
        int count=1;
        for(int i=0;i<chars.length;i++){
            if(i+1 < chars.length && chars[i] == chars[i+1]){
                count++;
            }else{
                str.append(chars[i]);
                if(count >1)
                    str.append(count);
                count=1;
            }
        }
        for(int i=0;i<str.length();i++)
            chars[i] = str.charAt(i);

        return str.length();
    }
}
