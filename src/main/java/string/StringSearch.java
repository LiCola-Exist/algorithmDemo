package string;

import sun.nio.cs.UnicodeEncoder;

/**
 * Created by LiCola on 2018/3/12.
 */
public class StringSearch {


  public static final void main(String[] args){
    String chinese="中";
    System.out.println(chinese.length());
  }


  /**
   * 暴力查找 文本长度为N，子串长度为N，时间复杂度为O（N*M）
   * @param pat
   * @param txt
   * @return
   */
  public static int searchViolent(String pat, String txt) {
    int M = pat.length();
    int N = txt.length();
    for (int i = 0; i <= N - i; i++) {
      int j;
      for (j = 0; j < M; j++) {
        if (txt.charAt(i + j) != pat.charAt(j)) {
          break;
        }
      }
      if (j == M) {
        return i;
      }
    }
    return -1;
  }

}
