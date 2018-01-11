package collection;

/**
 * Created by LiCola on 2018/1/6.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * 从有序数组中移除重复元素，并返回之后的数组长度，要求实现原地算法不能申请新的数组空间
 */
public class RemoveDuplicates {

  /**
   * 数组无法直接删除元素，返回新长度相当于返回截断后的长度，数组任有冗余但是新长度下没有冗余
   * 这就需要比对和移动数组元素，需要一个tail作为指针
   */
  public static int removeDuplicates(int[] nums) {
    int length = nums.length;
    //处理小于等于1的情况
    if (length <= 1) {
      return length;
    }
    //只申请一个指针 保存长度 已经剔除了1个长度的特殊情况
    int tail = 1;
    for (int i = 1; i < length; i++) {
      if (nums[i - 1] != nums[i]) {
        nums[tail] = nums[i];//在新位置上保存 保证tail下全部是有效数据
        tail++;
      }
    }
    return tail;
  }
}
