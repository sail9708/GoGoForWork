//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。 
//
// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 按 严格递增 顺序排列 
// 
// Related Topics 树 深度优先搜索 
// 👍 779 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import leetcode.datastructure.TreeNode;

public class No_108_ConvertSortedArrayToBinarySearchTree{
    public static void main(String[] args) {
       Solution solution = new No_108_ConvertSortedArrayToBinarySearchTree().new Solution();
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return bstHelper(nums, 0, nums.length);
    }
    //左闭右开
    public TreeNode bstHelper(int[] nums, int start, int end){
        if (end-start<1){
            return null;
        }

        if (end-start == 1){
            return new TreeNode(nums[start]);
        }

        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = bstHelper(nums, start, mid);
        root.right = bstHelper(nums, mid+1, end);

        return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
