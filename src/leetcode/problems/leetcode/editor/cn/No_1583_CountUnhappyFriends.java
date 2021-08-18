//给你一份 n 位朋友的亲近程度列表，其中 n 总是 偶数 。 
//
// 对每位朋友 i，preferences[i] 包含一份 按亲近程度从高到低排列 的朋友列表。换句话说，排在列表前面的朋友与 i 的亲近程度比排在列表后面的
//朋友更高。每个列表中的朋友均以 0 到 n-1 之间的整数表示。 
//
// 所有的朋友被分成几对，配对情况以列表 pairs 给出，其中 pairs[i] = [xi, yi] 表示 xi 与 yi 配对，且 yi 与 xi 配对
//。 
//
// 但是，这样的配对情况可能会是其中部分朋友感到不开心。在 x 与 y 配对且 u 与 v 配对的情况下，如果同时满足下述两个条件，x 就会不开心： 
//
// 
// x 与 u 的亲近程度胜过 x 与 y，且 
// u 与 x 的亲近程度胜过 u 与 v 
// 
//
// 返回 不开心的朋友的数目 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4, preferences = [[1, 2, 3], [3, 2, 0], [3, 1, 0], [1, 2, 0]], pairs =
// [[0, 1], [2, 3]]
//输出：2
//解释：
//朋友 1 不开心，因为：
//- 1 与 0 配对，但 1 与 3 的亲近程度比 1 与 0 高，且
//- 3 与 1 的亲近程度比 3 与 2 高。
//朋友 3 不开心，因为：
//- 3 与 2 配对，但 3 与 1 的亲近程度比 3 与 2 高，且
//- 1 与 3 的亲近程度比 1 与 0 高。
//朋友 0 和 2 都是开心的。
// 
//
// 示例 2： 
//
// 输入：n = 2, preferences = [[1], [0]], pairs = [[1, 0]]
//输出：0
//解释：朋友 0 和 1 都开心。
// 
//
// 示例 3： 
//
// 输入：n = 4, preferences = [[1, 3, 2], [2, 3, 0], [1, 3, 0], [0, 2, 1]], pairs =
// [[1, 3], [0, 2]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 500 
// n 是偶数 
// preferences.length == n 
// preferences[i].length == n - 1 
// 0 <= preferences[i][j] <= n - 1 
// preferences[i] 不包含 i 
// preferences[i] 中的所有值都是独一无二的 
// pairs.length == n/2 
// pairs[i].length == 2 
// xi != yi 
// 0 <= xi, yi <= n - 1 
// 每位朋友都 恰好 被包含在一对中 
// 
// Related Topics 数组 模拟 
// 👍 41 👎 0


package leetcode.problems.leetcode.editor.cn;

import java.util.HashSet;

public class No_1583_CountUnhappyFriends {
    public static void main(String[] args) {
        Solution solution = new No_1583_CountUnhappyFriends().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 初见思路： 匈牙利算法。但是忘记了怎么实现.
         *          一个一个比对
         *解答成功:
         * 			执行耗时:3 ms,击败了57.83% 的Java用户
         * 			内存消耗:53.9 MB,击败了97.59% 的Java用户
         *
         * @param n
         * @param preferences
         * @param pairs
         * @return
         */
        public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
            //先将pairs转化为匹配数组
            int[] match = new int[n];
            for (int i = 0; i < n / 2; i++) {
                int x = pairs[i][0];
                int y = pairs[i][1];
                match[x] = y;
                match[y] = x;
            }
            //false为不确定，true为不高兴
            boolean[] ishappy = new boolean[n];
            //遍历
            for (int x = 0; x < n; x++) {
                //如果已经判断x为不高兴了，直接跳过
                if (ishappy[x]) {
                    continue;
                }
                //目前与x匹配的人
                int y = match[x];
                //遍历x与别人的关系
                for (int i = 0; i < n - 1; i++) {
                    int u = preferences[x][i];
                    int v = match[u];
                    //因为是从关系最好的开始遍历，所以如果当前不是y，说明x与u的关系比与y好
                    if (u != y) {
                        //进而判断u与x的关系是否比v好，如果是，则x与u都不高兴
                        for (int j = 0; j < n - 1; j++) {
                            if (preferences[u][j] == v) {
                                break;
                            }
                            if (preferences[u][j] == x) {
                                ishappy[x] = true;
                                ishappy[u] = true;
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
            int res = 0;
            for (boolean i : ishappy) {
                if (i) {
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
