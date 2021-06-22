package com.newcode.ProblemNC102;

/**
 * 给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 * 注：本题保证二叉树中每个节点的val值均不相同。
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public static void main(String[] args) {
        //[3,5,1,6,2,0,8,#,#,7,4],5,1
        TreeNode temp = null;
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        temp = root.right;
        temp.left = new TreeNode(6);
        temp.right = new TreeNode(2);
        Solution solution = new Solution();
        int res = solution.lowestCommonAncestor(root, 6, 2);
        System.out.println(res);
    }

    /**
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    public static TreeNode dfs(TreeNode root, int o1, int o2) {
        if (root == null) {
            return null;
        }
        if (root.val == o1 || root.val == o2) {
            return root;
        }
        TreeNode right = dfs(root.right, o1, o2);
        TreeNode left = dfs(root.left, o1, o2);
        if (right != null && left != null) {
            return root;
        }
        if (right != null) {
            return right;
        } else {
            return left;
        }
    }


    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        TreeNode t = dfs(root, o1, o2);
        if (t == null) {
            return -1;
        }
        return t.val;


    }
}