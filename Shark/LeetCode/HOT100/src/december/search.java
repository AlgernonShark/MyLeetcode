package december;

public class search {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        // 二分查找
        while(left <= right){
            // 中间索引直接判断
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;

            else if (nums[mid] < nums[right]){
                // 右半边是有序数组
                if (nums[mid] < target && target <= nums[right])
                    // target 在右半边数组
                    left = mid + 1;
                else
                    // target 在左半边数组
                    right = mid - 1;
            }

            else{
                // 左半边是有序数组
                if (nums[left] <= target && target < nums[mid])
                    // target 在左半边数组
                    right = mid - 1;
                else
                    // target 在右半边数组
                    left = mid + 1;
            }
        }
        return -1;
    }

}
