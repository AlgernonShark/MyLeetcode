package december;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//就是说你跟层序遍历有啥区别0.0

public class PreOrder2 {
    public List<Integer> preorderTraversal(TreeNode root){
        if(root == null) return new ArrayList<Integer>();

        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);

            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return list;
    }
}
