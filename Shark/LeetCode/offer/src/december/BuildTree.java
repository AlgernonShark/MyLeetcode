package december;

import java.util.HashMap;

public class BuildTree {

    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> in_map = new HashMap<>();
    int pre_index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.pre_index = 0;

        for(int i = 0; i < inorder.length; i++){
            in_map.put(inorder[i], i);
        }

        return buildTree(0, inorder.length - 1);
    }

    public TreeNode buildTree(int left, int right ){

        if (left > right) return null;

        TreeNode root = new TreeNode(preorder[pre_index]);
        int in_index = in_map.get(preorder[pre_index]);
        pre_index++;

        root.left = buildTree(left, in_index - 1);
        root.right = buildTree(in_index + 1, right);

        return root;
    }

}
