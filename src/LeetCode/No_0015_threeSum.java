package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_0015_threeSum {

    /*****test case********/
    private static int[] nums = {-1,0,1,2,-1,-4};
    /**********************/

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return result;
            }

            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = nums.length-1;
            while(right>left){
                int sum = nums[i]+nums[right]+nums[left];
                if( sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    right--;
                    left++;
                }
                else if(sum < 0){
                    left++;
                }
                else if(sum > 0){
                    right--;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new No_0015_threeSum().threeSum(nums);
        System.out.println(result);
    }

}
