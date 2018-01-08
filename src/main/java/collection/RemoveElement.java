package collection;

/**
 * Created by LiCola on 2018/1/8.
 * https://leetcode.com/problems/remove-element/description/
 * 从数组中移除指定元素，返回新数组长度，要求实现原地算法
 */
public class RemoveElement {

  public static int removeElement(int[] nums, int val) {
    //从0计的数组下标
    int tail = 0;
    for (int i = 0, length = nums.length; i < length; i++) {
      if (nums[i] != val) {
        //找到目标元素 替换nums的某个位置
        nums[tail] = nums[i];
        tail++;
      }
    }
    return tail;
  }

}
