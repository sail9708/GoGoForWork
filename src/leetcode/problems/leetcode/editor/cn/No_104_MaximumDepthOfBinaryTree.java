//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 893 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class No_104_MaximumDepthOfBinaryTree{
    public static void main(String[] args) {
       Solution solution = new No_104_MaximumDepthOfBinaryTree().new Solution();
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

    //本题可使用迭代或者递归法

    /**
     * 递归法
     * @param root
     * @return maxDepth
     */
    public int maxDepth_1(TreeNode root) {
        if (root == null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 迭代法
     * @param root
     * @return maxDepth
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            int size = que.size();
            while (size > 0){
                if (que.peek().left != null){
                    que.offer(que.peek().left);
                }
                if (que.peek().right != null){
                    que.offer(que.peek().right);
                }
                que.poll();
                size--;
            }
            depth++;
        }
        return depth;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
