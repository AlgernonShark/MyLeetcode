package december;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LCSolution {
    public List<List<Integer>> threeSum(int[] nums) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;

        Arrays.sort(nums); // O(nlogn)

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++; right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }
}

public class ThreeSum {
        public List<List<Integer>> threeSum(int[] nums) {
            if(nums == null || nums.length < 3) return new ArrayList<List<Integer>>();

            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            // 对数组进行排序
            Arrays.sort(nums);

            // 从nums[i]为目标值，在[i + 1,length - 1]的区间使用双指针left&right找目标元素nums[left]&nums[right]
            for(int i = 0; i < nums.length - 2; i++){
                if (nums[i] > 0) break;
                // 跳过相等的元素
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                // 初始化双指针left和right，分别指向左右区间的端点
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    // 首先判断是否符合条件，符合就添加进去
                    if (nums[i] + nums[left] + nums[right] == 0) {
                        List<Integer> list = new ArrayList<>();

                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        lists.add(list);

                        // 指针向中间移动
                        left++;
                        right--;

                        // 跳过相等的元素
                        while (left < right && nums[left - 1] == nums[left]) left++;
                        while (right  > left && nums[right + 1] == nums[right]) right--;
                    }
                    else if (nums[i] + nums[left] + nums[right] < 0) left++;
                    else right--;
                }
            }

            return lists;

        }
}
