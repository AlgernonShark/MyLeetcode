package december;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView199 {
    public List<Integer> rightSideView(TreeNode root){
        if(root == null) return new ArrayList<Integer>();

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){

            int currentSize = queue.size();

            for(int i = 0;i < currentSize;i++){
                TreeNode p = queue.poll();
                if(p.left != null){
                    queue.offer(p.left);
                }
                if(p.right != null){
                    queue.offer(p.right);
                }
                if(i == currentSize - 1){
                    list.add(p.val);
                }
            }

        }

        return list;

    }
}
