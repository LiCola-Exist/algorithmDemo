package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个栈，这个栈除了可以进行普通的push、pop操作以外，还可以进行getMin的操作，getMin方法被调用后，会返回当前栈的最小值
 *
 *
 * <i>
 * 版本1：基本思路：一个min变量，在push入口每次入栈都比对最小值，但是在pop出栈时，需要监听栈状态，遍历比对最小值 优点：空间复杂度低，空间复杂度O(1)，只需要一个变量保存min。 *
 * 缺点：时间复杂度高，时间复杂度-O(n)。
 * </i>
 *
 *
 * 版本2：{ 基本思路：以空间换时间，新开最小值辅助栈，每次push都比对出当前最小值入最小值栈mins。pop就可以直接pop最小值栈顶
 * 优点：时间复杂度降低，都是O(1)操作栈顶元素。缺点：空间复杂度高O(n)，可能出现min大量重复情况，如入栈2，1，3，4，5（mins=2，1，1，1，1） }
 *
 * @author LiCola
 * @date 2018/9/28
 */
public class MinStack<T extends Comparable> {

  private List<T> data = new ArrayList<>();
  private List<Integer> mins = new ArrayList<>();

  public void push(T value) {
    data.add(value);
    if (mins.isEmpty()) {
      mins.add(0);
    } else {
      T min = peekMin();
      if (min.compareTo(value) > 0) {
        //最小栈 栈顶元素大于value value是新的最小值
        mins.add(data.size() - 1);
      }
    }
  }

  public T pop() {
    if (data.isEmpty()) {
      return null;
    }

    //pop时先取索引
    int popIndex = data.size() - 1;

    //获取min栈顶元素 是最小值索引
    Integer minIndex = mins.get(mins.size() - 1);

    if (popIndex == minIndex) {
      mins.remove(mins.size() - 1);
    }

    return data.remove(data.size() - 1);
  }

  public T peekMin() {
    if (mins.isEmpty()) {
      return null;
    }
    //获取min栈顶元素 最小值索引
    Integer minIndex = mins.get(mins.size() - 1);
    return data.get(minIndex);
  }
}
