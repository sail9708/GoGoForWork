//这里有 n 个航班，它们分别从 1 到 n 进行编号。 
//
// 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 fi
//rsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。 
//
// 请你返回一个长度为 n 的数组 answer，其中 answer[i] 是航班 i 上预订的座位总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//输出：[10,55,45,25,25]
//解释：
//航班编号        1   2   3   4   5
//预订记录 1 ：   10  10
//预订记录 2 ：       20  20
//预订记录 3 ：       25  25  25  25
//总座位数：      10  55  45  25  25
//因此，answer = [10,55,45,25,25]
// 
//
// 示例 2： 
//
// 
//输入：bookings = [[1,2,10],[2,2,15]], n = 2
//输出：[10,25]
//解释：
//航班编号        1   2
//预订记录 1 ：   10  10
//预订记录 2 ：       15
//总座位数：      10  25
//因此，answer = [10,25]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 104 
// 1 <= bookings.length <= 2 * 104 
// bookings[i].length == 3 
// 1 <= firsti <= lasti <= n 
// 1 <= seatsi <= 104 
// 
// Related Topics 数组 前缀和 
// 👍 234 👎 0


package leetcode.problems.leetcode.editor.cn;

public class No_1109_CorporateFlightBookings {
    public static void main(String[] args) {
        Solution solution = new No_1109_CorporateFlightBookings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 继续优化：差分方法，参考  宫水三叶  的题解
         *      数组不变，区间查询：前缀和、树状数组、线段树；
         *      数组单点修改，区间查询：树状数组、线段树；
         *      数组区间修改，单点查询：差分、线段树；
         *      数组区间修改，区间查询：线段树。
         * 解答成功:
         *      执行耗时:3 ms,击败了78.66% 的Java用户
         *      内存消耗:53.2 MB,击败了75.82% 的Java用户
         *
         * @param bookings
         * @param n
         * @return
         */
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] c = new int[n + 1];
            for (int[] b : bookings) {
                c[b[0] - 1] += b[2];
                c[b[1]] -= b[2];
            }
            int[] ans = new int[n];
            ans[0] = c[0];
            for (int i = 1; i < n; i++) {
                ans[i] = ans[i - 1] + c[i];
            }
            return ans;
        }

        /**
         * 初见思路：直接遍历噻30
         * 解答成功: (不出意料，速度很慢，不过好歹能过）
         *      执行耗时:1698 ms,击败了7.58% 的Java用户
         *      内存消耗:53.5 MB,击败了48.02% 的Java用户
         *
         * @param bookings
         * @param n
         * @return
         */
        public int[] corpFlightBookings1(int[][] bookings, int n) {
            int[] ans = new int[n];
            for (int i = 0; i < bookings.length; i++) {
                for (int j = bookings[i][0]; j <= bookings[i][1]; j++) {
                    ans[j - 1] += bookings[i][2];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
