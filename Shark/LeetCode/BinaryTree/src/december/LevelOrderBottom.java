package december;


import java.util.*;

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();//当前层的List

            int currenSize = queue.size();
            for(int i = 0;i < currenSize;i++){

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

        int length = lists.size();
        List<List<Integer>> lists1 = new ArrayList<List<Integer>>();
        for(int i = 0; i < length;i++)
        {
            lists1.add(lists.get(length - (1 + i)));
        }

        return lists1;
    }
}
