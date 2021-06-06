//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 890 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import leetcode.datastructure.TreeNode;

import java.util.*;

public class No_102_BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
       Solution solution = new No_102_BinaryTreeLevelOrderTraversal().new Solution();
       solution.levelOrder(new TreeNode(3,new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7,null,null))));
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
    public List<List<Integer>> levelOrder(TreeNode root) {


        //
        List<List<Integer>> res = new ArrayList<>();

        if (root == null){
            return res;
        }

        Queue<Integer> temp = new LinkedList<>();

        //定义一个队列
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            int size = que.size();
            for (int i = 1; i <= size; i++){
                if (que.peek().left != null){
                    que.offer(que.peek().left);
                }
                if (que.peek().right != null){
                    que.offer(que.peek().right);
                }
                temp.offer(que.poll().val);
            }
            res.add(new ArrayList<>(temp));
            temp.clear();
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
