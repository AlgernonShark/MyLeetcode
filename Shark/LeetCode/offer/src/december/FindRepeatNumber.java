package december;

import java.util.HashSet;

public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(set.add(nums[i]) == false) return nums[i];
        }

        return -1;
    }
}

//使用二分法 待补充
class MySolution {

}

