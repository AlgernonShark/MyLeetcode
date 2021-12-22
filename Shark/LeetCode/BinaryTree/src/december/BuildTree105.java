package december;

import java.util.HashMap;

public class BuildTree105 {

    private int[] inorder;
    private int[] preorder;
    private HashMap<Integer,Integer> map = new HashMap<>();
    int preorder_index ;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.preorder_index = 0;

        //K-V对：Key:树中的节点-V:在中序遍历数组中对应的索引
        int index = 0;
        for(Integer i : inorder){
            map.put(i, index++);
        }

        return buildTree(0,inorder.length-1);
    }

    public TreeNode buildTree(int left, int right) {
        //递归终止条件：叶子节点
        if (left > right) return null;

        //创建前序遍历索引指针对应的节点
        TreeNode root = new TreeNode(preorder[preorder_index]);
        //查找在节点-中序索引对中该节点对应的索引值
        int index = map.get(preorder[preorder_index]);
        //更新前序索引
        preorder_index++;

        //根据该index索引值递归建立左右子树
        root.left = buildTree(left, index - 1);
        root.right = buildTree(index + 1, right);

        return root;

    }
}
