package math;

public class BigNumberSum {

  /**
   * 大数（超过int存储范围的大数）相加
   * 1：首先因为大数已经超过的int的存储能力，所以需要int[]数组来存储
   * 2：考虑到进位需要判断最长数且近1位，即maxLength+1
   * 3：把输入值都格式化成统一长度的数组，逆序（方便相加）存储。
   * 4：使用模拟竖式计算，记得从个位开始依次相加，加入进位
   * @param bigNumberA 大数A
   * @param bigNumberB 大数B
   * @return 去除首位0的结果
   */
  public static String sum(String bigNumberA, String bigNumberB) {

    //考虑进位 结果数组长度为最长数组+1
    int lengthA = bigNumberA.length();
    int lengthB = bigNumberB.length();
    int maxLength = lengthA > lengthB ? lengthA : lengthB;
    int sumLength = maxLength + 1;
    //数组 逆序存储数值
    int[] numberA = new int[sumLength];
    for (int i = 0; i < lengthA; i++) {
      //采用 char的ASCII码修正出int值
      numberA[i] = bigNumberA.charAt(lengthA - 1 - i) - '0';
    }

    int[] numberB = new int[sumLength];
    for (int i = 0; i < lengthB; i++) {
      numberB[i] = bigNumberB.charAt(lengthB - 1 - i) - '0';
    }

    int[] result = new int[sumLength];

    //遍历数组 按位相加
    for (int i = 0; i < sumLength; i++) {
      int temp = result[i];
      temp += numberA[i];
      temp += numberB[i];

      if (temp >= 10) {
        temp -= 10;
        result[i + 1] = 1;
      }
      result[i] = temp;
    }

    StringBuilder stringBuilder = new StringBuilder(sumLength);

    for (int i = result.length - 1; i >= 0; i--) {
      int value = result[i];
      //剔除首位的0无效值
      if (value <= 0 && stringBuilder.length() <= 0) {
        continue;
      }
      stringBuilder.append(value);
    }

    return stringBuilder.toString();
  }
}
