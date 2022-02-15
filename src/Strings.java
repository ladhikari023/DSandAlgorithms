import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.HashMap;

public class Strings {
    public static void main(String[] args) {
        String str = "geeks";
        System.out.println(str.length());
        System.out.println(str.charAt(3));
        System.out.println(str.substring(2));
        System.out.println(str.substring(1,3));
        String str2 = "geeks";
        if(str==str2)
            System.out.println("Yes");
        else System.out.println("No");
        String s3 = new String("geeks");
        if(str==s3){
            System.out.println("Yes");
        }else System.out.println("No");
        if(str.contains("geek")) System.out.println("Yes");
        if(str.contains("geeki")) {
            System.out.println("Yes");
        }else System.out.println("No");


        // indexOf()
        // returns negative value if s2 is not present, otherwise it return first occurrence of s2 in s1
        String s = "ek";
        System.out.println(str.indexOf(s));
        System.out.println(str.concat("forgeeks"));



        //methods
        System.out.println(checkPalindrome("ABCDCBA"));
        System.out.println(checkSubsequence("ABCD","AF"));
        System.out.println(checkAnagram("listen","silent"));
        System.out.println(lexicographicRank("DCBA"));
    }

    private static int lexicographicRank(String str) {
        return 0;
    }

    private static boolean checkAnagram(String a, String b) {
        int count[] = new int[256];
        if(a.length()!=b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i)]++;
            count[b.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (count[i]!=0) return false;
        }
        return true;

//        char[] a1 = a.toCharArray();
//        Arrays.sort(a1);
//        a = new String(a1);
//
//        char[] b1 = a.toCharArray();
//        Arrays.sort(b1);
//        b = new String(b1);

//
//        return a.equals(b);
    }

    private static boolean checkSubsequence(String a, String b) {
        int j=0;
        for (int i = 0; i < a.length() && j<b.length(); i++) {
            if(a.charAt(i)==b.charAt(j)){ j++;}
        }
        return b.length() == j;
    }

    private static boolean checkPalindrome(String str) {
        int l=0,r=str.length()-1;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;
            r--;
        }
        StringBuilder rev = new StringBuilder(str);
        rev.reverse();
        return str.equals(rev.toString());
    }
}
