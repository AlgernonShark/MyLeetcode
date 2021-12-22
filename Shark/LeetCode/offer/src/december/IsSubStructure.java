package december;

public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return isSame(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    // 判断是否结构相同
    public boolean isSame(TreeNode A, TreeNode B){
        // B被遍历完，说明相同 -> 先判断B
        if (B == null) return true;
        if (A == null) return false;
        // 判断结构是否相同
        return A.val == B.val && isSame(A.left, B.left) && isSame(A.right, B.right);
    }
}

