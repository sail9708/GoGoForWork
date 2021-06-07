//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 513 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import leetcode.datastructure.TreeNode;

import java.util.TreeMap;

public class No_106_ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
       Solution solution = new No_106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
       solution.buildTree(new int[]{1,2,3}, new int[]{3,2,1});
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildProcess(inorder,0, inorder.length, postorder, 0, postorder.length);
    }

    //左闭右开
    public TreeNode buildProcess(int [] inorder, int inleft, int inright, int[] postorder, int postleft, int postright){
        if (inright-inleft < 1){
            return null;
        }
        if (inright-inleft == 1){
            return new TreeNode(inorder[inleft]);
        }

        TreeNode root = new TreeNode(postorder[postright-1]);
        int mid = 0;
        for (int i = inleft; i < inright; i++){
            if (inorder[i] == postorder[postright-1]){
                mid = i;
                break;
            }
        }
        root.left = buildProcess(inorder,inleft,mid,postorder,postleft,postleft+mid-inleft);
        root.right = buildProcess(inorder, mid+1,inright,postorder,postleft+mid-inleft,postright-1);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
