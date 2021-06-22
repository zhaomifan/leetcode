package com.newcode.ProblemNC18;

import java.util.*;

/**
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7},
 * Java递归，直接从某力的二叉树卡片过来，
 * 思想很简单，首先声明一个成员变量供全局使用；
 * 其次写一个向下探索的递归方法，注意先从左边再从右边；每向下一层level+1
 * 这里很巧妙的是，对于二维List来说，将根视为第0层，树的深度正好等于一维List的个数。
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution solution = new Solution();
        System.out.println(solution.levelOrder(root));
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        if (root == null) {
            return res;
        }
        count(root, 0);
        return res;
    }

    public void count(TreeNode node, int level) {
        if (level == res.size()) {
            res.add(new ArrayList<Integer>());
        }

        ArrayList<Integer> list = res.get(level);
        list.add(node.val);

        if (node.left != null) {
            count(node.left, level + 1);
        }

        if (node.right != null) {
            count(node.right, level + 1);
        }

    }
}