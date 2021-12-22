package december;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, new String());
        return list;
    }

    public void dfs(int left, int right, String cur){
        if (left == 0 && right == 0) {
            list.add(cur);
        }

        if (left > 0) {
            dfs(left - 1, right, cur + '(');
        }
        if (right > left) {
            dfs(left, right - 1, cur + ')');
        }
    }
}
