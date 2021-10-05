package Arrays;

public class HighestElementInArray {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2,5};
        int highestValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>highestValue){
                highestValue = arr[i];
            }
        }
        System.out.println(highestValue);
    }
}
