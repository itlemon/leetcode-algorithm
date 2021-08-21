package cn.itlemon.leetcode.string;

/**
 * No.443 字符串压缩 https://leetcode-cn.com/problems/string-compression/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-21
 */
public class No443StringCompression {

    public static int compress(char[] chars) {
        int length = chars.length;
        if (length == 1) {
            return 1;
        }
        char lastChar = chars[0];
        int lastCharCount = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < length; i++) {
            if (lastChar == chars[i]) {
                lastCharCount++;
            } else {
                result.append(lastChar).append(lastCharCount == 1 ? "" : lastCharCount);
                lastChar = chars[i];
                lastCharCount = 1;
            }
        }
        // 处理最后一波
        result.append(lastChar).append(lastCharCount == 1 ? "" : lastCharCount);
        String resultString = result.toString();
        for (int i = 0; i < resultString.length(); i++) {
            chars[i] = resultString.charAt(i);
        }
        return resultString.length();
    }
}
