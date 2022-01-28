package Bitwise;

public class Bitwise {
    public static void main(String[] args) {
        int x = 3, y = 6;
        System.out.println(x&y);
        System.out.println(x^y);
        System.out.println(~x);
        System.out.println(x<<1);
        System.out.println(-2000>>2);
        System.out.println(300>>3);

        // check if the kth bit is set or not
        int n = 1,k = 2;
        if (((n >> (k - 1)) & 1) == 1)
            System.out.println("SET");
        else
            System.out.println("NOT SET");

        // find odd occurrence number from an array
        int res = 0;
        int[] arr = {4,2,4,3,3,5,5,3,3};
        for (int i = 0; i < arr.length; i++) {
            res = res^arr[i];
        }
        System.out.println(res);

        // find a missing number from an array containing numbers from 1 to 1+n, all numbers occurs exactly once
        int[] arr2 = {1,2,4,3,5,6,9,8};
        System.out.println(getMissingNo(arr2));
    }
    static int getMissingNo(int a[]){
        int res1 = a[0];
        for (int i = 1; i < a.length; i++) {
            res1 = res1^a[i];
        }
        int res2 = 1;
        for (int i = 2; i <= a.length+1; i++) {
            res2 = res2^i;
        }
        return (res1^res2);
    }
}
