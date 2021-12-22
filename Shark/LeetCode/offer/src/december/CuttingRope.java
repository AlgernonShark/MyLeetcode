package december;

import org.junit.Test;



public class CuttingRope {
    @Test
    public void test(){
        System.out.println(cuttingRope(10));
    }

    public int cuttingRope(int n) {
        if (n == 2 || n == 3) return n - 1;

        long a = 1;
        while(n > 4){
            n -= 3;
            a *= 3 ;
            a = a % 1000000007;
        }
        return (int)(a * n % 1000000007);
    }
}
