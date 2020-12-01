class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = {-1,-1};

        int index = indexOfTarget(nums,target,left,right);
        int temp = index;

        if(index == -1) return result;

        else{
            while(temp >=0 && nums[temp] == target){
                result[0] = temp--;
            }

            temp = index;

            while(temp <= nums.length - 1 && nums[temp] == target){
                result[1] = temp++;
            }
            return result;
        }
    }

    public int indexOfTarget(int[] nums,int target,int left,int right){
        while(left <= right){
            int mid = (left + right) / 2;

            if(target == nums[mid]) return mid;

            if(nums[mid] > target) {
                right = mid - 1;
                return indexOfTarget(nums,target,left,right);
            }

            if(nums[mid] < target) {
                left = mid + 1;
                return indexOfTarget(nums,target,left,right);
            }
        }

        return -1;
        }
}
