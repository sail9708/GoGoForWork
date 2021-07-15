//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 105] 内。 
// -109 <= Node.val <= 109 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 1189 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import com.sun.source.tree.Tree;
import leetcode.datastructure.TreeNode;

import java.util.TreeMap;

public class No_236_LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args) {
       Solution solution = new No_236_LowestCommonAncestorOfABinaryTree().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    /**
     * 优化思路：回溯：
     * 向下递归，遇到p或者q返回p和q，遇到null就返回null
     * 如果左右子树递归结果都不为空，说明当前root为最小祖先节点，则返回当前root
     * 若一个为空一个不为空，则返回不为空的
     * 解答成功:
     * 			执行耗时:6 ms,击败了100.00% 的Java用户
     * 			内存消耗:40.4 MB,击败了76.98% 的Java用户
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p||root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left!=null&&right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        if(right !=null){
            return right;
        }
        return null;

    }
        /**
         * 初见思路：从根节点开始，判断p和q是否在其左右子树上，或者是否p或q就是当前根节点，
         * 是则直接返回当前根节点
         * 否则继续
         * 解答成功:
         * 			执行耗时:455 ms,击败了5.51% 的Java用户
         * 			内存消耗:40.4 MB,击败了79.92% 的Java用户
         * @param root
         * @param p
         * @param q
         * @return
         */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q){
            return root;
        }
        if (isContain(root.left,p,q)){
            if(isContain(root.right,p,q)){
                return root;
            }else{
                return lowestCommonAncestor(root.left,p,q);
            }
        }
        return lowestCommonAncestor(root.right,p,q);

    }

    public boolean isContain(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        if(root == p || root == q){
            return true;
        }
        return (isContain(root.left,p,q) || isContain(root.right,p,q));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
