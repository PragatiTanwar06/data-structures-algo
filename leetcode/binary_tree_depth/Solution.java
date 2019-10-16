package com.pragati.leetcode.binary_tree_depth;

/**
 * Created by pragati on 16/10/19.
 */

//This class will count the depth for a binary tree
public class Solution {

    int height;

    private int maxDepth(TreeNode root) {

            if(root==null){
                return 0;
            }
            else {
                int left = maxDepth(root.left);
                int right = maxDepth(root.right);

                if(left > right){
                    height = left+1;
                }
                else{
                    height = right+1;
                }
            }
            return height;
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node1.right.left = node4;
        node1.right.right = node5;

        System.out.println(new Solution().maxDepth(node1));
    }
}
