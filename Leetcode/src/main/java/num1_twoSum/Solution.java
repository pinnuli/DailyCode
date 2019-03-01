package num1_twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * author@ pinnuli
 * date@ 2019/3/1
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int anotherNum = target- nums[i];
            if (map.containsKey(anotherNum)) {
                return new int[]{i, map.get(anotherNum)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
