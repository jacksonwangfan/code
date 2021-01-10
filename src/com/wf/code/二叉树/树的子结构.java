package com.wf.code.二叉树;

/**
 * @auter wf
 * @date 2020/12/20
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * <p>
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 */
public class 树的子结构 {

    public static void main(String[] args) {
        //初始化 一个二叉树
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        //构造一个子树
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(0);
        node5.left = node6;
        System.out.println(isSubStructure(node1, node6));
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        //特殊处理
        if (A == null || B == null) {
            return false;
        }
        //A和B
        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public static boolean helper(TreeNode A, TreeNode B) {
        //说B已经遍历完了
        if (A == null) return true;
        //如果B还没完A就遍历完了不是子结构
        if (B == null) return false;
        //一直对比直到A或者B越过或者相等
        return A.val == B.val && helper(A.left, B.left) && helper(A.right, B.right);
    }

    /****************************树的子结构 二刷*********************************/
    public static boolean isSub(TreeNode root,TreeNode sub){
    return false;
    }

    //从第一个相等的节点开始，判断是否是子树
    public static boolean helper1(TreeNode a,TreeNode b){
        if(b==null) return true;
        return false;
    }


}
