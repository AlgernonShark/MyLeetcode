package december;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return ;

        if (nums.length == 2) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }

        int i = nums.length - 1;
        int j = i - 1;
        while(i > 0) {

            // 找到小于目标值的数，直到nums[j] < nums[i]时停止循环
            while(j >= 0 && nums[j] >= nums[i]) {
                j--;
                i--;
            }
            //数组遍历完毕
            if (j == -1) break;

            //将j后的下标为[i,length - 1]的元素排序，找到大于nums[j]的最小值
            // 因为上面已经有nums[j] < nums[i]，所以该数组必然存在nums[i] > nums[j]
            Arrays.sort(nums, i, nums.length);
            while(i < nums.length - 1 && nums[i] <= nums[j]) {
                i++;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            return;
        }

        Arrays.sort(nums);

    }

}
