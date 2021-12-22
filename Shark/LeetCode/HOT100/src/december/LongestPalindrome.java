package december;

class MySolution {

    public String longestPalindrome(String s){

        if(s == null || s.length() == 0) return "";

        // 我们可以把最长回文子串看成由对称轴+两边轴对称的字符串组成的
        // 对称轴可以是一串相同的字符，也可以是单个字符，因此一定是回文字符串！

        // 存放该回文子串起始和终点字符的下标
        int[] range = new int[2];
        char[] chars = s.toCharArray();

        // 对称轴的左侧边界 -> 遍历数组，但是可以跳过一部分重复的对称轴字符
        for(int i = 0; i < s.length(); i++){
            // 更新对称轴的左侧边界
            // 找到下一个与当前对称轴字符不同的字符chars[next]
            i = findLongest(chars, i, range);
        }

        //左闭右开
        return s.substring(range[0], range[1] + 1);

    }

    public int findLongest(char[] chars, int left, int[] range){
        // 初始化对称轴的右侧边界
        int right = left;

        // 找对称轴：和chars[left]相等的字符 -> 可以是一串相同的字符，也可以是单个字符
        // 但对称轴本身一定是回文字符串
        //
        while(right < chars.length - 1 && chars[right + 1] == chars[left]) {
            // 更新对称轴的右侧边界
            right++;
        }

        // 将对称轴的右侧边界作为返回值，这样可以跳过前面重复的字符，在for循环中执行更新的i = right + 1
        int next = right;

        // 从对称轴出发，找轴对称的字符串
        // 前两个条件保证left - 1和right + 1不会越界
        while(left > 0 && right < chars.length - 1 && chars[left - 1] == chars[right + 1]){
            //更新左右边界
            left--;
            right++;
        }

        //将更新的边界和已有的边界比较
        if (right - left > range[1] - range[0]){
            //更新
            range[0] = left;
            range[1] = right;
        }

        return next;
    }
}

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // 保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            // 把回文看成中间的部分全是同一字符，左右部分相对称
            // 找到下一个与当前字符不同的字符
            // 找新的对称轴？
            i = findLongest(str, i, range);
        }

        // 左闭右开
        return s.substring(range[0], range[1] + 1);
    }

    public int findLongest(char[] str, int low, int[] range) {
        // 查找中间部分
        // 中间部分可以理解成对称轴~是一组相同的字符，可以是单个字符，也可以是一串相同的字符，它一定满足回文
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }

        // 定位中间部分的最后一个字符，可以跳过前面的部分字符
        int ans = high;


        // 从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        // 记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }
}
