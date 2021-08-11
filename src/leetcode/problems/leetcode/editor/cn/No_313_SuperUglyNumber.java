//超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。 
//
// 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。 
//
// 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12, primes = [2,7,13,19]
//输出：32 
//解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,
//28,32] 。 
//
// 示例 2： 
//
// 
//输入：n = 1, primes = [2,3,5]
//输出：1
//解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
// 
// 
//
// 
// 
// 
// 提示： 
//
// 
// 1 <= n <= 106 
// 1 <= primes.length <= 100 
// 2 <= primes[i] <= 1000 
// 题目数据 保证 primes[i] 是一个质数 
// primes 中的所有值都 互不相同 ，且按 递增顺序 排列 
// 
// 
// 
// 
// Related Topics 数组 哈希表 数学 动态规划 堆（优先队列） 
// 👍 179 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.*;

public class No_313_SuperUglyNumber{
    public static void main(String[] args) {
       Solution solution = new No_313_SuperUglyNumber().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 动态规划：参考官方题解2
     *
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int m = primes.length;
        int[] pointers = new int[m];
        Arrays.fill(pointers, 1);
        for (int i = 2; i <= n; i++) {
            int[] nums = new int[m];
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                nums[j] = dp[pointers[j]] * primes[j];
                minNum = Math.min(minNum, nums[j]);
            }
            dp[i] = minNum;
            for (int j = 0; j < m; j++) {
                if (minNum == nums[j]) {
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }

    /**
     * 想法2：优先队列 (参考官方题解1)
     *解答成功:
     * 		执行耗时:504 ms,击败了17.54% 的Java用户
     * 		内存消耗:155.8 MB,击败了28.14% 的Java用户
     */
    public int nthSuperUglyNumber2(int n, int[] primes){
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int prime : primes) {
                long next = curr * prime;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    /**
     * 初见思路：暴力法，从1开始判断是否是超级丑数   超时
     * 运行失败:
     * 		Time Limit Exceeded
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber1(int n, int[] primes) {

        int count =0;
        int num = 1;
        while (count<n){
            if (isValid(num, primes)) {
                count++;
            }
            num++;
        }
        return num-1;

    }
    public boolean isValid(int num, int[] primes){
        int p = primes.length-1;
        while (num!=1 && p>=0){
            if (num % primes[p] == 0){
                num/=primes[p];
            }else {
                p--;
            }
        }
        if (num == 1){
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
