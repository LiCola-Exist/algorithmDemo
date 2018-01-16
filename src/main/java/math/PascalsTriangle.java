package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by LiCola on 2018/1/15.
 * https://leetcode.com/problems/pascals-triangle/description/
 * 根据输入的行数，输出Pascal's-Triangle（帕斯卡三角形，杨辉三角）
 * 如 numRows=5 输出：
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * Pascal三角性质：
 * 1：正整数构成，左右对称，由1开始
 * 2：第N行数字个数为N
 * 3：除每行最左侧和最右侧都为1外，其他数由左上和右上两数之和。
 */
public class PascalsTriangle {

  public static List<List<Integer>> generate(int numRows) {
    if (numRows <= 0) {
      return Collections.emptyList();
    }

    //构造二维数组
    List<List<Integer>> list = new ArrayList<>(numRows);
    for (int i = 0; i < numRows; i++) {
      //遍历构造 每个子数组 数量可以确定
      List<Integer> subList = new ArrayList<>(i + 1);
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          //最左/最右为1
          subList.add(1);
        } else {
          //其他都左上+右上之和
          List<Integer> upSubList = list.get(i - 1);
          subList.add(upSubList.get(j - 1) + upSubList.get(j));
        }
      }
      list.add(subList);
    }
    return list;
  }

  /**
   * [1],
   * [1,1],
   * [1,2,1],
   * [1,3,3,1],
   * [1,4,6,4,1]
   * 输入行数，得到某个行的杨辉三角
   */
  public static List<Integer> getRow(int k) {
    List<Integer> line = new ArrayList<Integer>();
    // 加入第一个1
    line.add(1);
    if (k <= 0) {
      return line;
    }
    for (int i = 1; i <= k; i++) {
      //从右向左的递进
      for (int j = i - 1; j >= 1; j--) {
        line.set(j, line.get(j) + line.get(j - 1));
      }
      // 加上最后一个1
      line.add(1);
    }
    return line;
  }
}
