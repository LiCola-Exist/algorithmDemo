package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiCola on 2018/3/10.
 * 整数海量数据中统计重复出现的数
 * 这里的海量是有限定的，如10亿个整数，统计重复的数，输出结果要求得到重复的数
 * 简单的10亿的数是不能直接加载到内存的，一个int需要32bit=4byte，10亿*4byte~=3.72GB，已经超过大多数应用运行限制
 * 这里有个隐含条件，只要求统计重复，而不统计重复次数，存储这样的信息只需要boolean值（0/1）就能保存信息，而boolean可以就是bit。
 * 所以数据规模可以大幅度缩减，用一个bit替代一个int（32bit）内存压缩32倍，用一个bit保存是否重复，bit的位置代表整数，也就是bitmap结构。
 * 使用bitmap结构可以将10亿个整数所需内存压缩到=3.72G/32=119MB
 */
public class BitMapDuplicates {

  /**
   * 默认 两个数组有序 从小到大
   */
  public static List<Integer> duplicate(int[] src1, int[] src2) {
    int[] bigArray;
    int[] smallArray;
    int max;
    if (src1[src1.length - 1] > src2[src2.length - 1]) {
      max = src1[src1.length - 1];
      bigArray = src1;
      smallArray = src2;
    } else {
      max = src2[src2.length - 1];
      bigArray = src2;
      smallArray = src1;
    }

    //bitmap位图的大小 由两个数组中 最大值决定
    BitMap bitMap = new BitMap(max);
    for (int item :
        bigArray) {
      bitMap.add(item);
    }

    List<Integer> result = new ArrayList<>(smallArray.length);

    for (Integer target :
        smallArray) {
      if (bitMap.contain(target)) {
        result.add(target);
      }
    }
    return result;
  }

  public static class BitMap {

    private static final byte FLAG = 1;
    private byte[] bits;//保存全部数据 相当于二维数组

    /**
     * bitmap构造 因为结构被固定 需要一次性分配空间
     */
    public BitMap(int capacity) {
      this.bits = new byte[(capacity >> 3) + 1];//一个byte存储8个整数 右移3位=除以8 +1修正
    }

    public void add(int num) {
      int arrayIndex = num >> 3;// 除以8 得到所在数组索引 行数
      int position = num & 0x07;//与7得到 7位bit上的最大值 数组上位置索引 列数

      //操作目标槽点 或为1 即设置为标志位 表示存在这个数
      bits[arrayIndex] |= FLAG << position;
    }

    public boolean contain(int num) {
      int arrayIndex = num >> 3;// 除以8 得到所在数组索引 行数
      int position = num & 0x07;//与7得到 数组上位置索引 列数
      //当根据行列从bitmap中取出数据时 如3行6列 表示30（3*8+6）的槽点 取出值是 整数值是2^position 只能判断非0 表示存在
      return (bits[arrayIndex] & (FLAG << position)) != 0;
    }
  }
}
