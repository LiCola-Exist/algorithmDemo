package string;

import com.licola.llogger.LLogger;

/**
 * @author LiCola
 * @date 2018/8/27
 */
public class StringList {

  private static char[] reverse(char[] chars, int start, int end) {
    if (chars == null || start < 0 || end >= chars.length || start >= end) {
      return chars;
    }

    while (start < end) {
      char temp = chars[start];
      chars[start] = chars[end];
      chars[end] = temp;
      start++;
      end--;
    }

    return chars;
  }

  public static String reverse(String sentence) {
    if (sentence == null | sentence.isEmpty()) {
      return sentence;
    }

    int length = sentence.length();
    //第一步 整体翻转
    char[] chars = reverse(sentence.toCharArray(), 0, length - 1);
    LLogger.d(new String(chars));

    //第二步 开始以空格 为分割符 翻转单词内部顺序
    int start = 0;
    int end = 0;
    while (start < length) {
      if (chars[start] == ' ') {
        // 遇到空格就向右边继续查找
        start++;
        end++;
      } else if (end == length || chars[end] == ' ') {
        // 遇到空格或者已经到了字符串末尾，此时翻转找到的单词内部字符，这里需要注意end-1
        chars = reverse(chars, start, end - 1);
        // 重新制定检查索引start
        start = end++;
      } else {
        // end加1，为了检查单词是否结束
        end++;
      }
    }
    return new String(chars);
  }
}
