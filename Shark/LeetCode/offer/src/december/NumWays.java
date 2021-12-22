package december;

public class NumWays {
    public int numWays(int n) {
        if (n == 0 || n == 1 ) return 1;

        // f(n) = f(n - 1) + f(n - 2)
        // 以i = n - 1作为循环终止条件
        // f(i + 1) = f(i) + f(i - 1)

        // 初始化sum = f(1)即f(i), cur = f(0)即f(i - 1)
        int sum = 1, cur = 1;
        for (int i = 1; i < n ; i++) {
            sum = sum + cur; // f(i + 1)
            cur = sum - cur; // f(i)
            sum %= 1000000007;
        }
        return sum;
    }
}
