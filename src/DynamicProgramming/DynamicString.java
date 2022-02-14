package DynamicProgramming;

import java.util.Locale;

public class DynamicString {
    public static void main(String[] args) {
        // check if the string b could be abbreviation for string a
        String a = "AbCFd";
        String b = "BFD";
        System.out.println(checkAbbreviation(a,b));
    }

    private static String checkAbbreviation(String a, String b) {
        int[][] dp = new int[b.length()+1][a.length()+1];
        dp[0][0] = 1;
        for (int i = 1; i < b.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < a.length(); i++) {
            if(Character.isLowerCase(a.charAt(i-1))) dp[0][i]= dp[0][i-1];

        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(Character.isUpperCase(a.charAt(j-1))){
                    if(a.charAt(j-1)==b.charAt(i-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
                else{
                    if(Character.toUpperCase(a.charAt(j-1))==b.charAt(i-1)){
                        if(dp[i-1][j-1]==1 || dp[i][j-1]==1)
                            dp[i][j] = 1;
                    }
                    else dp[i][j] = dp[i][j-1];
                }

            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[b.length()][a.length()]==1 ? "YES" : "NO";
    }

}
