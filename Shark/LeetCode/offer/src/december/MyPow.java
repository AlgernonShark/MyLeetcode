package december;

public class MyPow {
    public double myPow(double x, int n) {
        // 模2取余的三种情况
        if (n == 1) return x;
        if (n == 0) return 1.0;
        if (n == -1) return 1 / x;

        // 二分计算 -> n = n / 2 + n / 2 + n % 2
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);

        return half * half * mod;
    }
}
