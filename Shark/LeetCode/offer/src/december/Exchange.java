package december;

public class Exchange {
    public int[] exchange(int[] nums) {
        if (nums.length == 0) return nums;

        int i = -1, j = nums.length;

        while(i < j){
            // 注意i + 1和j - 1不能越界
            // i + 1 <= num.length - 1 -> i < nums.length - 1
            // j - 1 >= 0 -> j > 0
            while(nums[++i] % 2 == 1 && i < nums.length - 1);
            while(nums[--j] % 2 == 0 && j > 0);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        return nums;

    }
}
