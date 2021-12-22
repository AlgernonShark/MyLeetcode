package december;

//自顶向下
public class MaxDepthTop {

    private int answer;		// don't forget to initialize answer before call maximum_depth

    public int maxDepth(TreeNode root) {
        //如果为空
        if(root == null) return 0;

        this.answer = 1;
        this.maximum_depth(root,0);
        return answer;
    }

    private void maximum_depth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }

        maximum_depth(root.left, depth + 1);
        maximum_depth(root.right, depth + 1);
    }



}
