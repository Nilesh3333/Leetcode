public class isSubsequence392{
    public static void main(String[] args) {
        String s= "axc";
        String t = "ahbgdc";
        boolean ans = isSubsequence(s,t);
        System.out.println(ans);
    }
    public static boolean isSubsequence(String s, String t) {
        if(s.length() > t.length())
            return false;
        int i=0,j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else
                j++;
        }
        return s.length() == i;
    }
}
