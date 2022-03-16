package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OneToTwenty {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        int[] arr = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(arr,9)));
    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int left = 0, right = s.length()-1;
        while(left<right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
