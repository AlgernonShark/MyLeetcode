package december;


import java.util.LinkedList;
import java.util.Queue;

public class Connect {
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution1 {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0;i < currentSize; i++) {
                Node p = queue.poll();

                if (p.left != null)  queue.offer(p.left);
                if (p.right != null) queue.offer(p.right);

                if (i == currentSize - 1)  p.next = null;
                else p.next = queue.peek();

            }

            currentSize = queue.size();

        }
        return root;

    }
}
