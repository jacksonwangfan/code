package com.wf.lingcha;

import com.wf.code.二叉树.TreeNode;

import java.util.*;

/**
 * 二叉树题库2
 * 二叉树题库：https://github.com/EndlessCheng/codeforces-go/blob/master/leetcode/README.md
 * 涉及到的力扣题目+代码：
 * 104. 二叉树的最大深度 https://leetcode.cn/problems/maximum-depth-of-binary-tree/solution/kan-wan-zhe-ge-shi-pin-rang-ni-dui-di-gu-44uz/
 *
 * 课后作业：
 * 111. 二叉树的最小深度 https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 * 404. 左叶子之和 https://leetcode.cn/problems/sum-of-left-leaves/
 * 112. 路径总和 https://leetcode.cn/problems/path-sum/
 * 129. 求根节点到叶节点数字之和 https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 * 1448. 统计二叉树中好节点的数目 https://leetcode.cn/problems/count-good-nodes-in-binary-tree/
 * 987. 二叉树的垂序遍历 https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/
 */

//二叉树相关问题
public class BinaryTree {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    public void preorderTraversal(TreeNode root, List<Integer> res) {
         if (root == null) return;
         res.add(root.val);
         preorderTraversal(root.left, res);
         preorderTraversal(root.right, res);
    }


    //完全二叉树的节点个数
    public int countNodes(TreeNode root) {
            if (root == null){
                return 0;
            }

            return 1 + countNodes(root.left) + countNodes(root.right) ;
    }

    /**
     * 二叉树的所有路径
     * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
     * 叶子节点 是指没有子节点的节点。
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        binaryTreePaths(root, "", res);
        return res;
    }

    public void binaryTreePaths(TreeNode root, String s, List<String> res) {
        if (root == null) {
            return;
        }

        s += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            res.add(s);
        }

        s += "->";
        binaryTreePaths(root.left, s, res);
        binaryTreePaths(root.right, s, res);
    }

    int sumOfLeftLeaves3;
    //二叉树左叶子只和
    public int sumOfLeftLeaves3(TreeNode root) {
        if (root == null) {return 0;}

        //收集答案
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sumOfLeftLeaves3 += root.left.val;
        }

        sumOfLeftLeaves3(root.left);
        sumOfLeftLeaves3(root.right);

        return sumOfLeftLeaves3;
    }


    private int baseValue, currCount, maxCount;
    private List<Integer> res = new ArrayList<>();
    /**
     * 二叉搜索树中的众数
     * https://leetcode.cn/problems/find-mode-in-binary-search-tree/description/?envType=problem-list-v2&envId=binary-tree
     */
    public int[] findMode(TreeNode root) {
        baseValue = root.val;
        dfs(root);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }

    public void dfs(TreeNode node){
        if (node == null) {
            return;
        }

        dfs(node.left);

        int val = node.val;
        if (val == baseValue) {
            currCount ++;
        }else {
            currCount = 1;
            baseValue = val;
        }

        if (currCount == maxCount) {
            //同一个数 这里只能被执行一次，所以这不用考虑去重
            res.add(val);
        }

        //说明找到 新的众数了
        if (currCount > maxCount) {
            res.clear();
            maxCount = currCount;
            res.add(val);
        }

        dfs(node.right);
    }

    int pre = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE / 2;
    /**
     * 530. 二叉搜索树的最小绝对差
     * https://leetcode.cn/problems/minimum-absolute-difference-in-bst/?envType=problem-list-v2&envId=binary-tree
     * 二叉搜索树的最小绝对差
     */
    public int getMinimumDifference(TreeNode root) {
        getMinimumDifferenceSub(root);
        return min;
    }

    public void getMinimumDifferenceSub(TreeNode root) {
        if (root == null) {
            return;
        }

        getMinimumDifferenceSub(root.left);
        min = Math.min(root.val - pre, min);
        pre = root.val;
        getMinimumDifferenceSub(root.right);
    }


    int diameterOfBinaryTree = 0;
    /*
     * 二叉树的直径
     * https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=problem-list-v2&envId=binary-tree
     * 给你一棵二叉树的根节点，返回该树的 直径 。
        二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
        两节点之间路径的 长度 由它们之间边数表示。
     */
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeSub(root);
        return diameterOfBinaryTree;
    }

    public int diameterOfBinaryTreeSub(TreeNode root) {
        if (root == null) {
            return -1;
        }

        //计算左节点的树高
        int left = diameterOfBinaryTreeSub(root.left) + 1;
        //计算右节点的树高
        int right = diameterOfBinaryTreeSub(root.right) + 1;
        //left + right 是这棵树的直径，比较直径的最大值，收集答案
        diameterOfBinaryTree = Math.max(left + right, diameterOfBinaryTree);
        //最后返回这颗子树的对最大深度
        return Math.max(left, right);
    }


    //二叉树的层序遍历
    public List<List<Integer>> levelOrderByQueue(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            res.add(list);
        }

        return res;
    }

    //二叉树的层序遍历
    public List<List<Integer>> levelOrderByArr(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<TreeNode> next = new LinkedList<>();
            List<Integer> r = new ArrayList<>();
            for (TreeNode treeNode : queue) {
                r.add(treeNode.val);

                if (treeNode.left != null) {
                    next.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    next.add(treeNode.right);
                }
            }

            queue = next;
            res.add(r);
        }

        return res;
    }

    //二叉搜索树树的最近公共祖先
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val > root.val){
            return root;
        }

        if (q.val < root.val && p.val > root.val){
            return root;
        }

        if (root.val == p.val) return p;
        if (root.val == q.val) return q;

        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        if (left != null) {
            return left;
        }

        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        return right;


    }

    //二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        return right;

    }


    /**
     * 108. 将有序数组转换为二叉搜索树
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int left , int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right + 1) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, left, mid - 1);
        node.right = buildTree(nums, mid + 1, right);

        return node;
    }


    /**
     * 剪枝二叉树
     * LCR 047. 二叉树剪枝
     * https://leetcode.cn/problems/pOCWxh/description/
     * 给定一个二叉树 根节点 root ，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
     * 节点 node 的子树为 node 本身，以及所有 node 的后代。
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left  = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }

        return root;
    }


    /**
     * 二叉树题库1：https://github.com/EndlessCheng/codeforces-go/blob/master/leetcode/README.md
     */
    //1. 二叉树的最大深度
    public int maxDepth4(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = 1 + maxDepth4(root.left);
        int rightDepth = 1 + maxDepth4(root.right);
        return Math.max(leftDepth, rightDepth);
    }

    //2. 二叉树的最小深度 自底向上归
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return  1 + minDepth(root.right);
        }

        if (root.right == null) {
            return  1 + minDepth(root.left);
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    //自顶向下递
    public int minDepth1(TreeNode root) {
        Value ans = new Value();
        ans.v = Integer.MAX_VALUE;
        minDepthDFS(root, 0, ans);
        return root == null ? 0 : ans.v;
    }

    public void minDepthDFS(TreeNode root, int cnt, Value ans) {
        if (root == null) {
            return;
        }

        cnt++;
        //叶子节点手机答案
        if (root.left == null && root.right == null) {
            ans.v = Math.min(ans.v, cnt);
        }

        minDepthDFS(root.left, cnt, ans);
        minDepthDFS(root.right, cnt, ans);
    }

    //二叉树左叶子之和
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        //找到左叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        return sum + sumOfLeftLeaves1(root.left) + sumOfLeftLeaves1(root.right);
    }

    /**
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
     * 叶子节点 是指没有子节点的节点。
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, 0);
    }

    public boolean pathSum(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }

        sum += root.val;
        //叶子节点返回
        if (root.left == null && root.right == null) {
            //因为到了叶子节点一定会返回
           return sum == targetSum;
        }

        return  pathSum(root.left, targetSum, sum) || pathSum(root.right, targetSum, sum);
    }

    /**
     * 129. 求根节点到叶节点数字之和
     * https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/
     * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
     * 每条从根节点到叶节点的路径都代表一个数字：
     * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
     * 计算从根节点到叶节点生成的 所有数字之和 。
     * 叶节点 是指没有子节点的节点。
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbersSub(root, 0);
    }

    //遍历到到叶子节点之后的和
    public int sumNumbersSub(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        sum = sum * 10 + root.val;
        //当是叶子节点的时候收集答案
        if (root.left == null && root.right == null) {
            return sum;
        }

       return sumNumbersSub(root.left, sum) + sumNumbersSub(root.right, sum);

    }

    /**
     * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
     *
     * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
     *
     * 统计二叉树中好节点的数目
     * https://leetcode.cn/problems/count-good-nodes-in-binary-tree/description/
     */
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return  goodNodes(root, root.val);

    }

    public int goodNodes(TreeNode root, int maxVal){
        if (root == null) {
            return 0;
        }

        int total = 0;
        //说明是好节点
        if (root.val >= maxVal) {
            total++;
            maxVal = root.val;
        }

        total = total + goodNodes(root.left, maxVal) + goodNodes(root.right, maxVal);
        return total;
    }


    /**
     * 二叉树的垂序遍历
     * https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/description/
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        return null;
    }


/*    //平衡二叉树
    public boolean isBalanceTree(TreeNode root){
        if (root == null) {
            return true;
        }

        return (treeHight(root.right) - treeHight(root.left) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    //树的高度
    public int treeHight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHight = treeHight(root.left);
        int rightHight = treeHight(root.right);
        return  Math.max(leftHight, rightHight) +1;
    }*/



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        //int depth = BinaryTree.DeepTree(root);
        int depth = BinaryTree.DeepTree2(root);
        
        System.out.println("二叉树的最大深度为: " + depth); // 输出：3
    }

    /**
     * 左叶子之和
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftValue = 0;
        //说明遍历到左叶子节点了
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftValue += root.left.val;
        }

       return leftValue +sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }


    //求二叉树的最大深度问题开始
    public static int DeepTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDeep = DeepTree(root.left);
        int rightDeep = DeepTree(root.right);
        return Math.max(leftDeep, rightDeep) + 1;
    }
    static class Value {
        int v;
    }

    //求二叉树最大深度第二种方法
    public static int DeepTree2(TreeNode root) {
        Value ans = new Value();
        DeepTree3(root, 0, ans);
        return ans.v;
    }
    public static void DeepTree3(TreeNode root, int cnt, Value ans) {
        if (root == null) {
            return;
        }

        ++cnt;
        ans.v = Math.max(ans.v, cnt);
        DeepTree3(root.left, cnt, ans);
        DeepTree3(root.right, cnt, ans);
    }
    //###########################求二叉树的最大深度问题结束###########################


/**
 * 100. 相同的树
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 101. 对称二叉树
     * 已解答
     * 简单
     * 相关标签
     * premium lock icon
     * 相关企业
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null || root.right == null) {
            return root.left == root.right;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSymmetricSubTree(left, right);
    }

    public boolean isSymmetricSubTree (TreeNode l, TreeNode r) {
        if (l == null || r == null) {
            return l == r;
        }
        return l.val == r.val && isSymmetricSubTree(l.left, r.right) && isSymmetricSubTree(l.right, r.left);
    }

    /**
     * 110. 平衡二叉树
     * 简单
     * 相关标签
     * premium lock icon
     * 相关企业
     * 给定一个二叉树，判断它是否是 平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftH = getHight(root.left);
        int rightH = getHight(root.right);
        return  !(Math.abs(leftH - rightH) > 1) && isBalanced(root.left) && isBalanced(root.right);
    }


    public int getHight(TreeNode node) {
        if (node == null) {
            return 0;
        }

       int left_deep = getHight(node.left);
       int right_deep = getHight(node.right);
       return  Math.max(left_deep, right_deep) + 1;
    }


    /**
     * 199. 二叉树的右视图
     * 中等
     * 相关标签
     * premium lock icon
     * 相关企业
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     */
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int deep = 0;
        listBinaryTree(root, deep, map);
        List<Integer> list = new ArrayList();
        for (int i = 0; i < map.size(); i++) {
            Integer integer = map.get(i);
            list.add(integer);
        }

        return list;
    }

    public void listBinaryTree(TreeNode root, int deep, Map<Integer, Integer> map ){
        if (root == null) {
            return;
        }

        if (!map.containsKey(deep)) {
            map.put(deep, root.val);
        }

        listBinaryTree(root.right, deep + 1, map);
        listBinaryTree(root.left, deep + 1, map);
    }


    /**
     * 二叉树的右视图，采用层序遍历的方式
     * @param root
     * @return
     */
    public List<Integer> rightSideViewLevelList(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }

                //最后一个收集答案
                if (i == size - 1) {
                    res.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return res;
    }

    /**
     * 965. 单值二叉树
     * 简单
     * 相关标签
     * premium lock icon
     * 相关企业
     * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
     *
     * 只有给定的树是单值二叉树时，才返回 true；否则返回 false
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        int val = root.val;
        return isSameValTree(root, val);

    }

    public boolean isSameValTree(TreeNode node, int val){
        if (node == null) {
            return true;
        }

        if (node.val != val) {
            return false;
        }

       return isSameValTree(node.left, val) && isSameValTree(node.right, val);
    }

    /**
     * 是否是 翻转等价二叉树
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }

        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

       return  (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right));
    }

    /**
     * 翻转二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        processInvertTree(root);
        return root;
    }

    public void processInvertTree(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
    }

    /**
     * 合并二叉树 https://leetcode.cn/problems/merge-two-binary-trees/
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    /**
     * 判断二叉树是不是 二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        long left = Long.MIN_VALUE;
        long right = Long.MAX_VALUE;
        return isValidBSTSub(root, left, right);
    }


    public boolean isValidBSTSub(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }

        return root.val > left && root.val < right
                && isValidBSTSub(root.left, left, root.val)
                && isValidBSTSub(root.right, root.val, right);
    }

    private int res = 0;

    /**
     * 二叉树染色
     * https://leetcode.cn/problems/QO5KpG/
     */
    public int getNumber(TreeNode root, int[][] ops) {
        if (root == null) {
            return 0;
        }
        isRed(root, ops);
        getNumber(root.left, ops);
        getNumber(root.right, ops);

        return res;
    }

    //判断当前节点是不是红的
    public void isRed(TreeNode root, int[][] ops) {
        if (root == null) {
            return;
        }
        int val = root.val;

        for (int i = ops.length - 1; i > 0; i--) {
            int color = ops[i][0];
            int left = ops[i][1];
            int right = ops[i][2];

            //0是蓝色 1是红色
            if (left <= val && right >= val) {
                if (color == 1) {
                    res++;
                }

                return;
            }
        }
    }





}
