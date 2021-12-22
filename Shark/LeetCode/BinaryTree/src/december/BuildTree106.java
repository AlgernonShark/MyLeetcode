package december;

import java.util.HashMap;

public class BuildTree106 {

    public int post_index;
    public int[] inorder;
    public int[] postorder;
    public HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

    public TreeNode buildTree(int left,int right){
        //递归结束条件
        if (left > right) return null;

        //创建root节点
        int val = postorder[post_index];
        TreeNode root = new TreeNode(val);

        //查找中序遍历中该节点对应的索引值，以进行二分递归
        int index = map.get(val);

        //更新后序遍历数组的遍历指针
        post_index--;

        //
        root.right = buildTree(index + 1, right);
        root.left = buildTree(left , index - 1);


        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        //这里必须加this
        this.postorder = postorder;
        post_index = postorder.length - 1;

        int index = 0;
        for(Integer i:inorder){
            map.put(i,index++);
        }

        return buildTree(0, inorder.length-1);
    }

}

class Solution {

    int post_index;
    int[] inorder;
    int[] postorder;
    HashMap<Integer,Integer> idx_map = new HashMap<Integer,Integer>();

    public TreeNode helper(int idx_left,int idx_right) {
        if(idx_left > idx_right) return null;

        //确定是根节点
        int root_val = postorder[post_index];
        TreeNode root = new TreeNode(root_val);

        //寻找后序遍历索引对应的根节点的值在中序遍历中映射的索引位置
        int index = idx_map.get(root_val);
        post_index--;
        //分成左右两棵子树继续递归
        root.right = helper(index + 1, idx_right);
        root.left = helper(idx_left, index-1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        post_index = postorder.length - 1;

        int idx = 0;
        for(Integer i:inorder) {
            //建立inorder数组中每个值和索引映射关系的键值对
            idx_map.put(i, idx++);
        }

        return helper(0, inorder.length - 1);

    }

}
