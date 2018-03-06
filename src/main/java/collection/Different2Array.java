package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by LiCola on 2018/3/6.
 * 两个元素不重复的数组，求出重叠元素
 */
public class Different2Array {

  /**
   * 题目可以理解为求两个集合的并集。
   * 设有A和B两个集合，A的长度为N，B的长度为M
   * 如果简单的两个数组嵌套for循环，时间复杂度和数组大小成平方阶（N*M~=N^2）
   * 问题的根源在查找效率上，java中哈希表的查找效率最高且与数据量无关。
   *
   * 解题思路：
   * 使用HashSet构造目标集合，在HashSet上查找重叠部分，尽量使用
   */
  public List<String> overlaps(List<String> a, List<String> b) {
    List<String> overlaps = new ArrayList<>();
    //选择数据量较小的数组 构造HashSet 避免哈希表的slot槽上有链 提高在HashSet上的查找效率
    List<String> smallList;
    List<String> bigList;
    if (a.size() > b.size()) {
      bigList = a;
      smallList = b;
    } else {
      bigList = b;
      smallList = a;
    }
    HashSet<String> smallSet = new HashSet<>(smallList);

    for (String item : bigList) {
      if (smallSet.contains(item)) {
        overlaps.add(item);
      }
    }

    return overlaps;
  }
}
