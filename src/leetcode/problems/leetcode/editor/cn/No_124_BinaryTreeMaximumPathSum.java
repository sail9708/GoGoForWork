//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 104] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 
// 👍 1144 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import leetcode.datastructure.TreeNode;

public class No_124_BinaryTreeMaximumPathSum{
    public static void main(String[] args) {
       Solution solution = new No_124_BinaryTreeMaximumPathSum().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /**
     * 解答成功:
     * 		执行耗时:0 ms,击败了100.00% 的Java用户
     * 		内存消耗:40.2 MB,击败了77.10% 的Java用户
     */

    //建立一个类内全局变量
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode root){
        if (root ==  null){
            return 0;
        }

        int leftMaxSum = dfs(root.left);
        int rightMaxSum = dfs(root.right);

        //更新最长路径长度
        //每次有以下几种情况：
        // 1. 当前节点值，与子节点最长路径值的大小
        // 2. 当前节点与左子树连城的路径， 与右子树连城的路径，以及与左右子树练起的路径
        maxSum = Math.max(maxSum, root.val);
        maxSum = Math.max(maxSum, Math.max(leftMaxSum+root.val, Math.max(rightMaxSum+root.val,leftMaxSum+rightMaxSum+root.val)));

        //递归返回的值
        // 包含当前节点的最长路径和
        int reVal = Math.max(root.val, Math.max(leftMaxSum+root.val, rightMaxSum+ root.val));

        return reVal;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
