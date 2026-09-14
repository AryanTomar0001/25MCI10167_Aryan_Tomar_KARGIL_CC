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
    private int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        maxSum=0;
        bst(root);
        return maxSum;
    }

    Pair bst(TreeNode root){
        if(root == null){
           return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Pair left = bst(root.left);
        Pair right =bst(root.right);

        int min ;
        int max;
        int sum;
        if(left.max<root.val && right.min> root.val){
            int currentSum = left.sum + right.sum + root.val;
            maxSum= Math.max(maxSum , currentSum);
            int currentMin = Math.min(root.val, left.min);
            int currentMax = Math.max(root.val, right.max);
            return new Pair(currentMin, currentMax, currentSum);
        }
        return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}

class Pair{
    int min ;
    int max ;
    int sum ;
    Pair(int min , int max , int sum){
        this.min = min;
        this.max =max;
        this.sum =sum;
    }
}



