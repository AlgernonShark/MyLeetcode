package december;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum) return true; //root是叶子结点时 root.left == null && root.right == null

        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);

    }
}
