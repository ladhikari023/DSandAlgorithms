package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] weight = {3, 4, 5, 6, 1};
        int[] value = {9, 3, 5, 4, 17};
        System.out.println(knapsack(weight, value, 6));
    }

    static int knapsack(int[] wt, int[] val, int wMax) {
        int[][] dp = new int[val.length + 1][wMax + 1];
        for (int i = 0; i <= wMax; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= val.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= val.length; i++) {
            for (int w = 1; w <= wMax; w++) {
                if (wt[i - 1] > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+","+dp[i][j]+" ");
            }
            System.out.println("");
        }
        // subset finding
        List<Integer> subsetArr = new ArrayList<>();
        for (int i = val.length; i > 0; i--) {
            if (dp[i][wMax]>dp[i-1][wMax])
                subsetArr.add(wt[i-1]);
        }
        System.out.println(subsetArr);
        return dp[val.length][wMax];
    }

}
