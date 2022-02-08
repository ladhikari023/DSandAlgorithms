package Arrays;

import java.util.Arrays;

public class ArrayProblems {
    public static void main(String[] args) {
        int[] arr = {10,5,6,30,12,1,5,6};

        System.out.println(Arrays.toString(reverseArray(arr)));
        int[] arr1 = {10,20,20,30,30,30};
        System.out.println(removeDuplicates(arr1));

        int[] arr2 = {10,20,0,0,8,0,3,0,9,11,0};
        System.out.println(Arrays.toString(movesZerosToEnd(arr2)));

        int[] arr3 = {1,5,7,3,2,0,8};
        int d = 2;
        System.out.println(Arrays.toString(leftRotateByD(arr3,d)));

        int[] arr4 = {7,10,4,3,6,5,2};
        // leader means that each element to the right side of element is smaller than the element
        leaderInArray(arr4);

        int[] arr5 = {30,10,8,2};
        System.out.println(maximumDifference(arr5));

        int[] arr6 = {10,20,30};
        frequencyInASortedArray(arr6);

        int[] arr7 = {1,5,3,8,12};
        maximumProfitFromStock(arr7);

        int[] arr8 = {3,0,1,2,5,1,1,2,1};
        trapRainWater(arr8);

        int[] arr9 = {0,1,1,1,0};
        System.out.println(maximumConsecutiveOnes(arr9));
        
        int[] arr10 = {2,3,-8,7,-1,2,3};
        System.out.println(maximumSubArray(arr10));

        int[] arr11 = {7,10,13,14};
        System.out.println(maxLengthEvenOddSubArray(arr11));

        int[] arr12 = {8,-4,3,-5,4};
        System.out.println(maxCircularSubArray(arr12));
    }

    private static int maxCircularSubArray(int[] arr12) {
        int max_normal = maximumSubArray(arr12);
        if (max_normal<0) return max_normal;
        int arr_sum = 0;
        for (int i = 0; i < arr12.length; i++) {
            arr_sum += arr12[i];
            arr12[i] = -arr12[i];
        }
        int max_circular = arr_sum + maximumSubArray(arr12);
        return (Math.max(max_normal,max_circular));
    }

    private static int maxLengthEvenOddSubArray(int[] arr11) {

        int maxValue = 1;
        int curr = 1;

        for (int i = 1; i < arr11.length; i++) {
            if ((arr11[i]%2==0 && arr11[i-1]%2!=0) || (arr11[i]%2==1 && arr11[i-1]%2!=1)){
                curr++;
                maxValue = Math.max(maxValue,curr);
            }
            else{
                curr = 1;
            }
        }
        return maxValue;
    }

    private static int maximumSubArray(int[] arr10) {
        int result = Integer.MIN_VALUE;
        int[] max = new int[arr10.length];
        max[0] = arr10[0];
        for (int i = 1; i < arr10.length; i++) {
            max[i] = Math.max(arr10[i],arr10[i]+max[i-1]);
            result = Math.max(max[i],result);
        }
        return result;
    }

    private static int maximumConsecutiveOnes(int[] arr9) {
        int count = 0;
        int max_count = 0;
        for (int i = 0; i < arr9.length; i++) {
            if (arr9[i]==1){
                count++;
            }
            else{
                if(max_count<count){
                    max_count = count;
                }
                count = 0;
            }
        }
        return max_count;
    }

    private static void trapRainWater(int[] arr8) {
        int[] lMax = new int[arr8.length];
        int[] rMax = new int[arr8.length];
        int water = 0;
        rMax[arr8.length-1] = 0;
        for (int i = arr8.length-2; i >= 0; i--){
            rMax[i]= Math.max(rMax[i+1],arr8[i+1]);
        }
        System.out.println(Arrays.toString(rMax));
        lMax[0] = 0;
        for (int i = 1; i < arr8.length; i++) {
            lMax[i]= Math.max(lMax[i-1],arr8[i-1]);
        }
        System.out.println(Arrays.toString(lMax));
        for (int i = 0; i < arr8.length; i++) {
            if(lMax[i]>arr8[i] && rMax[i]>arr8[i]){
                water += (Math.min(lMax[i],rMax[i])-arr8[i]);
            }
        }
        System.out.println(water);
    }

    private static void maximumProfitFromStock(int[] arr7) {
        int profit = 0;
        for (int i = 1; i < arr7.length; i++) {
            if(arr7[i]>arr7[i-1]){
                profit += (arr7[i]-arr7[i-1]);
            }
        }
        System.out.println(profit);
    }

    private static void frequencyInASortedArray(int[] arr6) {
        int element = arr6[0], count = 1;
        for (int i = 1; i < arr6.length; i++) {
            if (arr6[i-1]==arr6[i]){
                count++;
            }
            else if(arr6[i-1]!=arr6[i]){
                System.out.println(element+" "+count);
                element = arr6[i];
                count = 1;
            }
            if(i==arr6.length-1){
                System.out.println(element+" "+count);
            }
        }
    }

    private static int maximumDifference(int[] arr5) {
        int low = arr5[0];
        int diff = Integer.MIN_VALUE;
        for (int i = 1; i < arr5.length; i++) {
            if ((arr5[i]-low)>diff){
                diff = arr5[i]-low;
            }
            if(arr5[i]<low){
                low = arr5[i];
            }
        }
        return diff;
    }

    private static void leaderInArray(int[] arr4) {
        int curr_ldr = arr4[arr4.length-1];
        System.out.print(curr_ldr+" ");
        for (int i = arr4.length-2; i > 0; i--) {
            if (arr4[i]>curr_ldr){
                System.out.print(arr4[i]+" ");
                curr_ldr = arr4[i];
            }
        }
        System.out.println();
    }

    private static int[] leftRotateByD(int[] arr3, int d) {
        int[] temp = new int[arr3.length];
        for (int i = d; i < arr3.length; i++) {
            temp[i-d] = arr3[i];
        }
        for (int i = 0; i < d; i++) {
            temp[arr3.length-d+i] = arr3[i];
        }
        return temp;
    }

    private static int[] movesZerosToEnd(int[] arr2) {
        int count = 0;
        for (int i = 0; i < arr2.length-1; i++) {
            if(arr2[i]!=0){
                int temp = arr2[i];
                arr2[i]=0;
                arr2[count] = temp;
                count++;
            }
        }
        return arr2;
    }

    private static int[] reverseArray(int[] arr) {
        int low = 0, high = arr.length-1;
        while(low<high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return arr;
    }
    private static int removeDuplicates(int[] arr){
        int result = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[result-1]){
                arr[result] = arr[i];
                result++;
            }
        }
        return result;
    }
}
