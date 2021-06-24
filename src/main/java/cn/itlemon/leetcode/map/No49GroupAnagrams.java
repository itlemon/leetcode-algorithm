package cn.itlemon.leetcode.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * No.49 字母异位词分组 https://leetcode-cn.com/problems/group-anagrams/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-24
 */
public class No49GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> container = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> list = container.computeIfAbsent(new String(chars), k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(container.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            return new String(array);
        })).values());
    }

}
