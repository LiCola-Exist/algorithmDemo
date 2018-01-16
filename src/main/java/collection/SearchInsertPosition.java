package collection;

import java.util.Collections;
import java.util.List;

/**
 * Created by LiCola on 2018/1/16.
 * https://leetcode.com/problems/search-insert-position
 * 已经给出有序数组且不重复和待插入元素，
 * 如果从数组中找到该插入元素，返回重复的位置索引，
 * 否则返回待插入索引，保证插入后数组有序
 */
public class SearchInsertPosition {

  /**
   * 根据题意就是，在有序数组中查找，第一个等于（重复位）或大于（插入位）插入元素的索引
   * 有序所以可以使用二分查找，{@link Collections#indexedBinarySearch(List, Object)}
   * 但是需要适当修改二分查找的返回值，返回低位索引值
   * 低位是从低到高逼近插入元素的索引
   */
  public static int searchInsert(int[] nums, int target) {

    int low = 0;//低位
    int height = nums.length - 1;//高位
    int mid = (low + height) >> 1;//中位
    while (low <= height) {
      if (target <= nums[mid]) {
        height = mid - 1;
      } else {
        low = mid + 1;
      }
      mid = (low + height) >> 1;
    }
    return low;
  }
}
