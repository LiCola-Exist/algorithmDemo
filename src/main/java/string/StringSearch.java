package string;

/**
 * Created by LiCola on 2018/3/12.
 */
public class StringSearch {


  /**
   * 暴力查找 文本长度为N，子串长度为M，时间复杂度为O（N*M）
   *
   * @param pat 查找字符串
   * @param txt 查找的目标文本
   */
  public static int searchViolent(String pat, String txt) {
    int patLength = pat.length();
    int txtLength = txt.length();

    for (int i = 0; i <= txtLength - patLength; i++) {
      int j;
      for (j = 0; j < patLength; j++) {
        if (txt.charAt(i + j) != pat.charAt(j)) {
          break;
        }
      }
      if (j == patLength) {
        //j 子字符串索引能够 完整的递增到子字符串长度 表示完全匹配
        return i;
      }
    }
    return -1;
  }

  public static int searchBack(String pat, String txt) {
    int M = pat.length();
    int N = txt.length();

    int i;
    int j;
    for (i = 0, j = 0; i < N && j < M; i++) {
      if (txt.charAt(i) == pat.charAt(j)) {
        j++;
      } else {
        i -= j;//回退到 本次匹配的开始位置的 搭配for的++移动到下一个字符
        j = 0;//重新指向pat的开头
      }
    }

    if (j == M) {
      return i - M;//找到匹配
    }
    return -1;
  }

}
