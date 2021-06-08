//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 523 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class No_111_MinimumDepthOfBinaryTree{
    public static void main(String[] args) {
       Solution solution = new No_111_MinimumDepthOfBinaryTree().new Solution();
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
     * 递归法
     * 			执行耗时:7 ms,击败了71.75% 的Java用户
     * 			内存消耗:59.1 MB,击败了38.60% 的Java用户
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        if (root.left!=null && root.right != null){
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
        }
        return Math.max(minDepth(root.left),minDepth(root.right))+1;

    }

    /**
     * 层序遍历， 迭代法
     * 			执行耗时:1 ms,击败了99.89% 的Java用户
     * 			内存消耗:57.3 MB,击败了99.62% 的Java用户
     * @param root
     * @return
     */
    public int minDepth_1(TreeNode root) {
        if (root == null){
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            int size = que.size();
            for (int i = 0; i<size; i++) {
                if (que.peek().left == null && que.peek().right == null){
                    return depth;
                }
                if (que.peek().left!=null){
                    que.offer(que.peek().left);
                }
                if (que.peek().right!=null){
                    que.offer(que.peek().right);
                }
                que.poll();
            }
            depth++;
        }
        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
