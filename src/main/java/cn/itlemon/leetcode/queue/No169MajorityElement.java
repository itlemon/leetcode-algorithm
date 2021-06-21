package cn.itlemon.leetcode.queue;

import java.util.HashMap;
import java.util.Map;

/**
 * No.169 多数元素 https://leetcode-cn.com/problems/majority-element/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-21
 */
public class No169MajorityElement {

    /**
     * 求众数
     *
     * @param nums 数组
     * @return 众数
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }
        return 0;
    }

}
