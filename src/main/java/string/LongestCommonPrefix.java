package string;

/**
 * Created by LiCola on 2018/1/11.
 * https://leetcode.com/problems/longest-common-prefix/description/
 * 从字符串数组中找到 最长的公共前缀
 */
public class LongestCommonPrefix {

  public static String getCommonPrefix(String[] strs) {
    int length = strs.length;
    if (length == 0) {
      return "";
    }

    int minLength = Integer.MAX_VALUE;//最短的字符串长度
    for (String item : strs) {
      minLength = Math.min(minLength, item.length());
    }

    //外层遍历 以最短字符串长度为准
    for (int i = 0; i < minLength; i++) {
      //内层遍历 比对全部的字符串 以0下标为基准
      for (int j = 1; j < length; j++) {
        if (strs[0].charAt(i) != strs[j].charAt(i)) {
            return strs[0].substring(0,i);
        }
      }
    }
    return strs[0].substring(0,minLength);
  }
}
