//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 
// 👍 1067 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class No_239_SlidingWindowMaximum{
    public static void main(String[] args) {
       Solution solution = new No_239_SlidingWindowMaximum().new Solution();
       solution.maxSlidingWindow(new int[]{1,3,1,2,0,5},3);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 答案思路：单调队列
     * 此题为单调队列的经典题
     * 解答成功:
     * 			执行耗时:32 ms,击败了92.77% 的Java用户
     * 			内存消耗:52.6 MB,击败了75.25% 的Java用户
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        //用deque来实现我们想要的单调队列,dq存的是nums中元素的下标
        Deque<Integer> dq = new LinkedList<>();
        //初始化单调队列
        for(int i = 0; i < k; i++){
            while(!dq.isEmpty()&&nums[i]>=nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offer(i);
        }
        res[0] = nums[dq.peek()];
        for (int i = k; i < nums.length; i++){
            while(!dq.isEmpty()&&nums[i]>=nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offer(i);
            while (dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            res[i-k+1] = nums[dq.peek()];
        }
        return res;
    }


    /**
     * 对初见思路也就是方法一的改进，不用每一步都删除优先队列中左边界的值
     * 而是只考虑堆顶的值是否在滑动窗口内，在的话就返回，不在就出队
     * 优先队列也就是堆内存储的结构式（值，下标）
     * 解答成功:
     * 			执行耗时:82 ms,击败了22.57% 的Java用户
     * 			内存消耗:59.2 MB,击败了8.49% 的Java用户
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(k> nums.length){
            k = nums.length;
        }
        int[] res = new int[nums.length-k+1];
        //构建一个大根堆
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        //初始化状态
        for(int i = 0; i < k-1; i++){
            pq.add(new int[]{nums[i],i});
        }
        //开始移动窗口,i表示窗口目前位置的右边边界索引
        for(int i = k-1; i < nums.length; i++){
            pq.add(new int[]{nums[i],i});
            //如果堆顶的值不在窗口内了，给他poll掉
            while(pq.peek()[1]<i-k+1){
                pq.poll();
            }
            res[i-k+1] = pq.peek()[0];
        }
        return res;
    }

    /**
     * 初见思路：建立一个优先队列，存储 (值)，随着滑动更新
     * 运行失败:
     * 			Time Limit Exceeded
     *
     * 	原因：对于每一步大根堆的操作耗时过大
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(k> nums.length){
            k = nums.length;
        }
        int[] res = new int[nums.length-k+1];
        //构建一个大根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //初始化状态
        for(int i = 0; i < k-1; i++){
            pq.add(nums[i]);
        }
        //开始移动窗口,i表示窗口目前位置的右边边界索引
        for(int i = k-1; i < nums.length; i++){
            pq.add(nums[i]);
            res[i-k+1] = pq.peek();
            pq.remove(nums[i-k+1]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
