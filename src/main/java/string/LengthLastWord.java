package string;

/**
 * Created by LiCola on 2018/1/9.
 * https://leetcode.com/problems/length-of-last-word/description/
 * 从一个包含大小写字母和空格的字符串中，返回最后一个单词的长度，如果没有最后的单词返回0
 * 提示：单词组成非空
 */
public class LengthLastWord {


  public static int length(String input) {
    int p = input.length() - 1;//得到字符串末尾索引
    //处理末尾包含空格的情况
    while (p >= 0 && input.charAt(p) == ' ') {
      p--;
    }
    int end = p;//实际的末尾
    //倒序得到末尾单词的索引
    while (p >= 0 && input.charAt(p) != ' ') {
      p--;
    }
    //索引相减才是最后的单词长度
    return end - p;
  }
}
