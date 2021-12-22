package december;

//双指针问题
public class MaxArea {
    public int maxArea(int[] height) {
        // 初始化双指针的区间[0,length - 1]
        int i = 0, j = height.length - 1, ans = 0;

        // j - i > 0
        while (i < j) {
            // 判断较小一方，计算面积并更新当前答案，并往中间移动较小一方的指针
            if (height[i] <= height[j]) {
                ans = Math.max(ans , height[i] * (j - i));
                i++;
            }
            else {
                ans = Math.max(ans , height[j] * (j - i));
                j--;
            }
        }
        return ans;
    }
}
