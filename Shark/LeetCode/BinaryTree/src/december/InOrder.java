package december;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {
    public List<Integer> inOrderTraversal(TreeNode root){
        if(root == null) return new ArrayList<Integer>();

        List<Integer> list = new ArrayList<Integer>();

        inOrderTraversal(root,list);

        return list;

    }

    public void inOrderTraversal(TreeNode root,List<Integer> list){
        if(root == null) return;

        inOrderTraversal(root.left,list);
        list.add(root.val);
        inOrderTraversal(root.right,list);

    }

}


//后进先出！
class InOrderIrative{
    public List<Integer> inOrderTraversal(TreeNode root){
        if(root == null) return new ArrayList<Integer>();

        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null){
            // 一路沿着左子树入栈
            while (root != null){
                if(root.left != null) {
                    stack.push(root);
                    root = root.left;
                }
            }

            // 最后一个节点没有左子树则弹出
            if(!stack.isEmpty()){
                root = stack.pop();
                list.add(root.val);
                // 这里有两种情况
                // 如果root.right非空--执行以上的while循环，将该节点的右子树压入栈，并且继续沿着左子树入栈
                // 如果root.right为空--跳过以上的while循环，将该节点的上一级（根）结点弹出栈
                root = root.right;
            }
        }

        return list;

    }


}