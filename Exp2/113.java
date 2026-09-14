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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        findPaths(root, targetSum, curr, ans);
        return ans;
    }

     void findPaths(TreeNode root, int targetSum, List<Integer> curr, List<List<Integer>> ans) {
        if (root == null) return;

        curr.add(root.val);

        if (root.left == null && root.right == null && targetSum == root.val) {
            ans.add(new ArrayList<>(curr)); 
        } else {
            findPaths(root.left, targetSum - root.val, curr, ans);
            findPaths(root.right, targetSum - root.val, curr, ans);
        }

        curr.remove(curr.size() - 1);
    }
}
