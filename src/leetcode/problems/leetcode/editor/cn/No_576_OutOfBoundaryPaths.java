//给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以
//穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。 
//
// 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 
//109 + 7 取余 后的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 50 
// 0 <= maxMove <= 50 
// 0 <= startRow < m 
// 0 <= startColumn < n 
// 
// Related Topics 动态规划 
// 👍 138 👎 0


package leetcode.problems.leetcode.editor.cn;

public class No_576_OutOfBoundaryPaths {
    public static void main(String[] args) {
        Solution solution = new No_576_OutOfBoundaryPaths().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MOD = (int) 1e9 + 7;
        int m, n, max;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][][] cache;

        public int findPaths(int _m, int _n, int _max, int r, int c) {
            m = _m;
            n = _n;
            max = _max;
            cache = new int[m][n][max + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k <= max; k++) {
                        cache[i][j][k] = -1;
                    }
                }
            }
            return dfs(r, c, max);
        }

        int dfs(int x, int y, int k) {
            if (x < 0 || x >= m || y < 0 || y >= n) return 1;
            if (k == 0) return 0;
            if (cache[x][y][k] != -1) return cache[x][y][k];
            int ans = 0;
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                ans += dfs(nx, ny, k - 1);
                ans %= MOD;
            }
            cache[x][y][k] = ans;
            return ans;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
