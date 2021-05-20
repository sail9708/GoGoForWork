package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_threeSum {

    /*****test case********/
    private static int[] nums = {-1,0,1,2,-1,-4};
    /**********************/

    public static List<List<Integer>> threeSum(int[] nums) {
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
        List<List<Integer>> result = threeSum(nums);
        System.out.println(Arrays.toString(new List[]{result}));
    }

}
