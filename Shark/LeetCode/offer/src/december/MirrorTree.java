package december;

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        // 递归结束：空节点或叶子结点
        if (root == null || (root.left == null && root.right == null)) return;

        // 交换左右节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 左右子树递归
        dfs(root.left);
        dfs(root.right);
    }
}
