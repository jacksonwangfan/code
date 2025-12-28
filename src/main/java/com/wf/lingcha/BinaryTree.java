package com.wf.lingcha;

import com.wf.code.二叉树.TreeNode;

import java.lang.reflect.Array;
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

    /**
     * 938. 二叉搜索树的范围和
     * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
     */
    private int rangeSumBSTRes = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        rangeSumBSTSub(root, low, high);
        return rangeSumBSTRes;
    }

    public void rangeSumBSTSub(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        if (root.val >= low && root.val <= high) {
            rangeSumBSTRes += root.val;
            rangeSumBSTSub(root.left, low, high);
            rangeSumBSTSub(root.right, low, high);
        }

        if (root.val < low) {
            rangeSumBSTSub(root.right, low, high);
        }

        if (root.val > high) {
            rangeSumBSTSub(root.left, low, high);
        }
    }

    /**
     * 递增顺序搜索树
     * 给你一棵二叉搜索树的 root
     * 请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
     */

    TreeNode temp;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode firstNode = new TreeNode(-1);
        temp = firstNode;
        increasingBSTSub(root);
        return firstNode.right;
    }

    public void increasingBSTSub(TreeNode root) {
        if (root == null) {
            return;
        }

        increasingBSTSub(root.left);

        temp.right = root;
        root.left = null;
        temp = root;

        increasingBSTSub(root.right);
    }

    /**
     * https://leetcode.cn/problems/leaf-similar-trees/description/?envType=problem-list-v2&envId=binary-tree
     * 872. 叶子相似的树
     * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
     *
     * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
     * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
     * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
     */

    private StringBuilder res1 = new StringBuilder();
    private StringBuilder res2 = new StringBuilder();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        leafSimilarBFS(root1, res1);
        leafSimilarBFS(root2, res2);
        return res1.toString().equals(res2.toString());
    }


    public  void leafSimilarBFS(TreeNode root,  StringBuilder res) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            res.append(root.val).append(',');
        }

        leafSimilarBFS(root.left, res);
        leafSimilarBFS(root.right, res);
    }


    /**
     * https://leetcode.cn/problems/minimum-distance-between-bst-nodes/description/?envType=problem-list-v2&envId=binary-tree
     * 783. 二叉搜索树节点最小距离
     * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
     * 差值是一个正数，其数值等于两值之差的绝对值。
     */
    private TreeNode pre = null;
    private int res = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        minDiffInBSTDFS(root);
        return res;
    }


    public void minDiffInBSTDFS(TreeNode root) {
        if (root == null) return;
        minDiffInBSTDFS(root.left);
        if (pre != null) {
            res = Math.min(res, Math.abs(root.val - pre.val));
        }
        pre = root;

        minDiffInBSTDFS(root.right);
    }

    /**
     * 703. 数据流中的第 K 大元素
     * https://leetcode.cn/problems/kth-largest-element-in-a-stream/description/?envType=problem-list-v2&envId=binary-tree
     * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
     * 请实现 KthLargest 类：
     * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
     * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
     */
    /*PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    Integer size = 0;
    public KthLargest(int k, int[] nums) {
        this.size = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > size) {
            queue.poll();
        }

        return queue.peek();
    }*/

    //二叉搜索树中找一个节点
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val == root.val) {
            return root;
        }

        return   searchBST(val >= root.val ? root.right : root.left, val);
       /*TreeNode left = searchBST(root.left, val);
        if (left != null) {
            return left;
        }
       return searchBST(root.right, val);*/
    }

    /**
     * 671. 二叉树中第二小的节点
     * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
     * 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
     * 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。
     * 如果第二小的值不存在的话，输出 -1 。
     */

    private int ans = -1;
    private int rootVal;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return ans;
        rootVal = root.val;
        findSecondMinimumValueDfs(root);
        return ans;
    }

    private void findSecondMinimumValueDfs(TreeNode root){
        if(root == null) {
            return;
        }


        if (root.val > rootVal) {
            ans = root.val;
        }

        findSecondMinimumValueDfs(root.left);
        findSecondMinimumValueDfs(root.right);
    }

    /**
     * 653. 两数之和 IV - 输入二叉搜索树'
     * https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/description/?envType=problem-list-v2&envId=binary-tree
     * 给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。
     */
    Set<Integer> findTargetSet = new HashSet<>();
    public boolean findTarget1(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        if (findTargetSet.contains(k - root.val)) return true;
        findTargetSet.add(root.val);

        return  findTarget1(root.left, k) || findTarget1(root.right, k);

    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        findTargetDfs(root, k, list);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size();j++ ) {
                if (list.get(i) + list.get(j) > k) {
                    break;
                }

                if (list.get(i) + list.get(j) == k) {
                    return true;
                }
            }
        }

        return false;
    }

    public void findTargetDfs(TreeNode treeNode, int k, List<Integer> list) {
        if (treeNode == null) {
            return;
        }

        findTargetDfs(treeNode.left, k, list);
        int val = treeNode.val;
        list.add(val);
        findTargetDfs(treeNode.right, k, list);

    }



    /**
     * 637. 二叉树的层平均值
     * https://leetcode.cn/problems/average-of-levels-in-binary-tree/description/?envType=problem-list-v2&envId=binary-tree
     * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<Double>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            double average = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            average = sum / (double) size;
            res.add(average);
        }

        return res;

    }

    /**
     * 另一棵树的子树
     * https://leetcode.cn/problems/subtree-of-another-tree/?envType=problem-list-v2&envId=binary-tree
     * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
     * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (subRoot == null) {
            return false;
        }


        if (root.val == subRoot.val && isSubTreeIsSameTree(root, subRoot)) {
            return true;
        }

       return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSubTreeIsSameTree(TreeNode subRoot1, TreeNode subRoot2) {
        if (subRoot1 == null || subRoot2 == null) {
            return subRoot1 == subRoot2;
        }

        return  (subRoot1.val == subRoot2.val) && isSubTreeIsSameTree(subRoot1.left, subRoot2.left) && isSubTreeIsSameTree(subRoot1.right, subRoot2.right);
    }


    /**
     * 563. 二叉树的坡度
     * https://leetcode.cn/problems/binary-tree-tilt/description/?envType=problem-list-v2&envId=binary-tree
     *
     * 给你一个二叉树的根节点 root ，计算并返回 整个树 的坡度 。
     * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
     * 整个树 的坡度就是其所有节点的坡度之和。
     */

    //这个虽然能access但是看上去还是向下递的方式，每往下递都要重新计算左右子树的和，时间复杂度是O(n)方。
    public int findTilt(TreeNode root) {
        if (root == null) {
           return 0;
        }

        int sumLeft = sum(root.left);
        int sumRight = sum(root.right);

        int tile = Math.abs(sumLeft - sumRight);
        return tile + findTilt(root.left) + findTilt(root.right);
    }

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + sum(root.left) +  sum(root.right);
    }

cx
    /**
     * LCR 045. 找树左下角的值
     * https://leetcode.cn/problems/LwUNpT/description/
     * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
     *
     * 假设二叉树中至少有一个节点。
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode lastLevelFirstNode = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

                if (i != 0) {
                    continue;
                }

                lastLevelFirstNode = treeNode;
            }
        }

        return lastLevelFirstNode == null ? 0 : lastLevelFirstNode.val;
    }

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
    private List<Integer> resList = new ArrayList<>();
    /**
     * 二叉搜索树中的众数
     * https://leetcode.cn/problems/find-mode-in-binary-search-tree/description/?envType=problem-list-v2&envId=binary-tree
     */
    public int[] findMode(TreeNode root) {
        baseValue = root.val;
        dfs(root);
        int[] result = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            result[i] = resList.get(i);
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
            resList.add(val);
        }

        //说明找到 新的众数了
        if (currCount > maxCount) {
            resList.clear();
            maxCount = currCount;
            resList.add(val);
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
