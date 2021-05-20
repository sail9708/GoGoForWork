package LeetCode.Problems;

import java.util.Arrays;
import java.util.HashMap;

public class No_0001_twoSum {

    /*****test case********/
    private static int[] nums = {2,7,11,15};
    private static int target = 9;
    /**********************/

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] result = new No_0001_twoSum().twoSum(nums,target);
        System.out.println(Arrays.toString(result));
    }



}