//可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
// 
// 'A'：Absent，缺勤 
// 'L'：Late，迟到 
// 'P'：Present，到场 
// 
//
// 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励： 
//
// 
// 按 总出勤 计，学生缺勤（'A'）严格 少于两天。 
// 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。 
// 
//
// 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 
//取余 的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：8
//解释：
//有 8 种长度为 2 的记录将被视为可奖励：
//"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL" 
//只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：n = 10101
//输出：183236316
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 105 
// 
// Related Topics 动态规划 
// 👍 206 👎 0


package leetcode.problems.leetcode.editor.cn;

public class No_552_StudentAttendanceRecordIi {
    public static void main(String[] args) {
        Solution solution = new No_552_StudentAttendanceRecordIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = (int) 1e9 + 7;

        /**
         * 快速矩阵幂
         * 时间复杂度：O(logn)
         * 空间复杂度：O(1)
         *执行耗时:2 ms,击败了100.00% 的Java用户
         * 			内存消耗:35.7 MB,击败了78.42% 的Java用户
         */
        int N = 6;

        long[][] mul(long[][] a, long[][] b) {
            int r = a.length, c = b[0].length, z = b.length;
            long[][] ans = new long[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    for (int k = 0; k < z; k++) {
                        ans[i][j] += a[i][k] * b[k][j];
                        ans[i][j] %= mod;
                    }
                }
            }
            return ans;
        }

        public int checkRecord(int n) {
            long[][] ans = new long[][]{
                    {1}, {0}, {0}, {0}, {0}, {0}
            };
            long[][] mat = new long[][]{
                    {1, 1, 1, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 0, 0},
                    {1, 1, 1, 1, 1, 1},
                    {0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 1, 0}
            };
            while (n != 0) {
                if ((n & 1) != 0) ans = mul(mat, ans);
                mat = mul(mat, mat);
                n >>= 1;
            }
            int res = 0;
            for (int i = 0; i < N; i++) {
                res += ans[i][0];
                res %= mod;
            }
            return res;
        }

        /**
         * dp
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         * 解答成功:
         * 执行耗时:265 ms,击败了21.58% 的Java用户
         * 内存消耗:59.6 MB,击败了24.21% 的Java用户
         *
         * @param n
         * @return
         */
        // 从 f[u][acnt][lcnt] 出发往前去更新所能更新的状态值
        public int checkRecord3(int n) {
            int[][][] f = new int[n + 1][2][3];
            f[0][0][0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (j != 1) f[i + 1][j + 1][0] = (f[i + 1][j + 1][0] + f[i][j][k]) % mod; // A
                        if (k != 2) f[i + 1][j][k + 1] = (f[i + 1][j][k + 1] + f[i][j][k]) % mod; // L
                        f[i + 1][j][0] = (f[i + 1][j][0] + f[i][j][k]) % mod; // P
                    }
                }
            }
            int ans = 0;
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    ans += f[n][j][k];
                    ans %= mod;
                }
            }
            return ans;
        }

        /**
         * 记忆化搜索
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         * 解答成功:
         * 执行耗时:377 ms,击败了6.84% 的Java用户
         * 内存消耗:71.2 MB,击败了5.27% 的Java用户
         */

        int[][][] cache;

        public int checkRecord2(int n) {
            cache = new int[n + 1][2][3];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 3; k++) {
                        cache[i][j][k] = -1;
                    }
                }
            }
            return dfs(n, 0, 0);
        }

        int dfs(int u, int acnt, int lcnt) {
            if (acnt >= 2) return 0;
            if (lcnt >= 3) return 0;
            if (u == 0) return 1;
            if (cache[u][acnt][lcnt] != -1) return cache[u][acnt][lcnt];
            int ans = 0;
            ans = dfs(u - 1, acnt + 1, 0) % mod; // A
            ans = (ans + dfs(u - 1, acnt, lcnt + 1)) % mod; // L
            ans = (ans + dfs(u - 1, acnt, 0)) % mod; // P
            cache[u][acnt][lcnt] = ans;
            return ans;
        }


        /**
         * 运行失败:
         * Time Limit Exceeded
         */
        int res = 0;

        public int checkRecord1(int n) {
            helper(n, 0, 0);
            return res;
        }

        public void helper(int n, int ADays, int LDays) {
            if (n == 0) {
                res++;
                return;
            }
            for (int i = 0; i < 3; i++) {
                // Present
                if (i == 1) {
                    helper(n - 1, ADays, 0);
                }
                // Absent
                else if (i == 2) {
                    if (ADays >= 1) {
                        continue;
                    }
                    helper(n - 1, ADays + 1, 0);
                }
                // Late
                else {
                    if (LDays >= 2) {
                        continue;
                    }
                    helper(n - 1, ADays, LDays + 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
