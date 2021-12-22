package medium;

public class LowestCommonAncestor236 {
    /*
     * 找到符合这个条件的值就更新
     */

    private TreeNode ans;

    public LowestCommonAncestor236() {
        this.ans = null;
    }


    //注意dfs的定义：p或者q是否为root节点的子节点，如果是就返回true
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;


        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);

        //lson && rson == true：表示root的左子树包含p，右子树包含q或者左子树包含q，右子树包含p的情况--此时root就是最近公共祖先
        // (root.val == p.val || root.val == q.val) && (lson || rson) == true表示其中一个节点是root本身时的情况
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }

        //判断p或者q是否为root节点的子节点：自底向上
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
}


class MySolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //if(root == null) return null;

        //p,q本身
        if(isParent(p,q)) return p;
        if(isParent(q,p)) return q;

        // 最近公共祖先——【最近】 【公共祖先】
        // 1.isParent(root,p) && isParent(root,q) -> ture —— 【公共祖先】
        // 2.isParent(root.left,p)) && isParent(root.left,q) -> true 左子节点也是【公共祖先】，不满足【最近】；右子节点同理
        // 如果满足1和2，直接返回root
        while(isParent(root,p) && isParent(root,q)){
            if(isParent(root.left,p) && isParent(root.left,q)){
                root = root.left;
            }
            if(isParent(root.right,p) && isParent(root.right,q)){
                root = root.right;
            }
            //(isParent(root,p) && isParent(root,q) -> ture) && (isParent(root.left,p) && isParent(root.left,q) -> false) && (isParent(root.right,p) && isParent(root.right,q) -> false)
            else return root;
        }

        return root;


    }

    //递归判断是否为祖先节点
    public boolean isParent(TreeNode parent,TreeNode son){
        if(parent == son) return true;
        if(parent == null) return false;

        return (isParent(parent.left,son) || isParent(parent.right,son));
    }
}


