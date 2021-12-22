package december;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode left,TreeNode right){
        //严密的条件推理——四种条件，前三种判断则抽丝剥茧
        if (left == null && right == null) return true;
        //如果左右子节点都为空，说明当前节点是叶子节点，返回true

        if (left == null || right == null || left.val != right.val) return false;
        // 如果当前节点只有一个子节点或者有两个子节点，但两个子节点的值不相同，直接返回false

        else return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
        //然后左子节点的左子节点和右子节点的右子节点比较，左子节点的右子节点和右子节点的左子节点比较
    }
}
