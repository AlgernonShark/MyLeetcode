package december;

public class HammingWeight {
    public int hammingWeight(int n) {
        // 记录次数
        int ret = 0;
        // 将最低位的1翻转为0
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        // 做了多少次位运算，就反转了多少个1
        return ret;
    }

}
