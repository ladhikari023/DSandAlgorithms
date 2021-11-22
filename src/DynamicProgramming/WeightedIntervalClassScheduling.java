package DynamicProgramming;

import java.util.Arrays;

public class WeightedIntervalClassScheduling {
    public static void main(String[] args) {
        int[][] arr = {{7,8},{1,2},{5,6},{1,4},{6,7}};
        int[] values = {2,6,5,7,1};
        System.out.println(weightedIntervalClassScheduling(arr,values));
    }

    private static int weightedIntervalClassScheduling(int[][] arr, int[] values) {
        // First arranging the classes in the order of their end time
        int mergedArr[][] = new int[arr.length][arr[0].length+1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= arr[0].length; j++) {
                if (j==arr[0].length) mergedArr[i][j] = values[i];
                else mergedArr[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < mergedArr.length; i++) {
            for (int j = 0; j <mergedArr.length; j++) {
                if (mergedArr[i][1]<mergedArr[j][1]){
                    int[] temp = mergedArr[i];
                    mergedArr[i] = mergedArr[j];
                    mergedArr[j] = temp;
                }
            }
        }

        int dp[] = new int[mergedArr.length];

        dp[0] = mergedArr[0][2];
        for (int i = 1; i<mergedArr.length; i++) {
            System.out.println(Arrays.toString(dp));
            dp[i] = Math.max(mergedArr[i][2],dp[i-1]);
            for (int j = i-1; j >= 0; j--) {
                if (mergedArr[j][1]<=mergedArr[i][0]){
                    dp[i] = Math.max(dp[i],(mergedArr[i][2]+dp[j]+(mergedArr[i][0]-mergedArr[j][1])));
                }
            }
        }
        return dp[dp.length-1];
    }
}
