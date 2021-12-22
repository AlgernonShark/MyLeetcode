package december;


import java.util.LinkedList;
import java.util.Stack;

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

public class CQueue {

    LinkedList<Integer> in;
    LinkedList<Integer> out;

    public CQueue() {
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        in.add(value);
    }

    public int deleteHead() {
        if (in.isEmpty() && out.isEmpty()) return -1;

        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.add(in.removeLast());
            }
        }

        return out.removeLast();

    }
}
