package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();//当前层的List

            int currentSize = queue.size();//每出队一层节点更新一次

            for(int i = 0;i < currentSize;i++){

                TreeNode temp = queue.poll();
                list.add(temp.val);

                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }

            }
            lists.add(list);

        }

        return lists;

    }
}


