package december;

public class Fib {

    int fib(int n) {
        if (n == 0 || n == 1) return n;

        // i = 1 开始
        // f(i + 1) = f(i) + f(i - 1)
        int sum = 1; // f(i)
        int cur = 0; // f(i - 1)

        for (int i = 1; i < n; i++) {
            sum = sum + cur; // f(i + 1)
            cur = sum - cur; // f(i)
            sum %= 100000007;
        }

        return sum;
    }
}
