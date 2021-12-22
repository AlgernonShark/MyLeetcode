package december;

import java.util.ArrayList;
import java.util.List;

public class PreOrder1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();

        List<Integer> list = new ArrayList<Integer>();
        preorder(list,root);
        return list;

    }

    public void preorder(List<Integer> list,TreeNode root){
        if(root == null) return;

        list.add(root.val);
        preorder(list,root.left);
        preorder(list,root.right);
    }
}
