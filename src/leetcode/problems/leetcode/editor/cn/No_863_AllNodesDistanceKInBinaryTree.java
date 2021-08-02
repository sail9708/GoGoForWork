//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 402 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import leetcode.datastructure.TreeNode;

import java.util.*;

public class No_863_AllNodesDistanceKInBinaryTree{
    public static void main(String[] args) {
       Solution solution = new No_863_AllNodesDistanceKInBinaryTree().new Solution();
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
     * 初见思路：树转化成图(太慢)
     * 方法一：嫁接（下文代码），将target的父节点嫁接作为其子节点，然后从target开始遍历
     * 解答成功:
     * 			执行耗时:13 ms,击败了99.38% 的Java用户
     * 			内存消耗:38.6 MB,击败了41.57% 的Java用户
     *
     * 方法二：建立族谱（很巧妙，使用额外编码）
     *
     * PS：方法一二参考于：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/solution/alton-er-cha-shu-zhong-suo-you-ju-chi-we-osk3/
     *
     * 方法三：深度优先搜索 + 哈希表（官方方法）
     *
     */

    // 定义结果值
    public List<Integer> res = new ArrayList<>();
    // 定义 k 变量（类全局有效）
    int dis;

    // 定义 target 全局 tar, 方便全局更改
    TreeNode tar;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // 赋值 dis 为 k
        dis = k;

        // 根据题意，root 不可能为空，考虑 k 的 2 个边界即可
        if(dis == 0) {
            res.add(target.val);
            return res;
        }

        // 树节点范围 [0, 500], 当 k 大于它时，是不会存在结果集的
        if (dis > 501) {
            return res;
        }

        tar = target;

        // 将 target 树先处理完
        dfs(target,0);

        // target 遍历完后，将 target left, right 清空,仅保留 target 根
        target.left = target.right = null;

        /**
         * 将 root 其它树枝续接到 target 上
         * root 等于 target 时， 不需要进行此步骤
         */
        if(root != target){
            graft(root);
            dfs(tar,0);
        }
        return res;
    }

    private boolean graft(TreeNode node){

        // left, right 节点为空时， 不处理
        if(node == null) {
            return false;
        }

        // 找到与 target 相等的节点
        if(node == tar) {
            return true;
        }

        if(graft(node.left)){

            // 不断将父节点，续接到当前空节点上
            if(node.left.left == null){
                // 优先放 left 上
                node.left.left = node;
            } else if(node.left.right == null){
                node.left.right = node;
            }

            // 将 node left 置为 null
            node.left = null;

            return true;
        }

        if(graft(node.right)){

            // 不断将父节点，续接到当前空节点上
            if(node.right.left == null){
                // 优先放 left
                node.right.left = node;
            }else if(node.right.right == null){
                node.right.right = node;
            }
            // 将 node right 置为 null
            node.right = null;
            return true;
        }

        return false;
    }

    private void dfs(TreeNode node,int step){

        // node 为空时，不处理
        if(node == null) {
            return;
        }

        // 步数等于 k(dis), 将 node.val 添加到 res
        if(step == dis){
            res.add(node.val);
            // 够步数后，后续的步骤不需要
            return;
        }

        dfs(node.left, step + 1);
        dfs(node.right, step + 1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
