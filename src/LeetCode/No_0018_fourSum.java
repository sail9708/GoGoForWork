package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_0018_fourSum {

    /*****test case********/
    private static int[] nums = {1,0,-1,0,-2,2};
    private static int target = 0;
    /**********************/

    public List<List<Integer>> fourSum(int[] nums, int target) {
        //先给数组排序
        Arrays.sort(nums);
        //创建结果列表
        List<List<Integer>> result = new ArrayList();
        //存储四数相加之和
        int sum;

        //
        for(int i = 0; i < nums.length - 3; i++){
            //避免获取重复结果
            if(i > 0 && nums[i] == nums[i-1]){ continue; }

            for(int j = i + 1; j < nums.length-2; j++){
                //避免获取重复结果
                if(j > i + 1 && nums[j] == nums[j-1]){ continue; }
                //左右指针
                int left = j + 1;
                int right = nums.length - 1;

                while(left < right){
                    sum = nums[i]+ nums[j]+ nums[left]+ nums[right];
                    if( sum > target){
                        right--;
                    }
                    else if( sum < target){
                        left++;
                    }
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while( left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while( left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new No_0018_fourSum().fourSum(nums, target);
        System.out.println(result);
    }
}
