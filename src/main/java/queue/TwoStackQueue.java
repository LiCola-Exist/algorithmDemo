package queue;

import java.util.Stack;

/**
 * 两个栈（先进后出FILO）是实现一个队列（先进先出FIFO） 可以知道栈和队列的出队规则刚好相反，所以可以使用两个栈的入栈出栈操作，实现反向操作，得到队列规则。
 * 具体就是：入栈：所有数据直接先入A栈（第一个栈），出栈：从B栈（第二个栈）取，而B栈的数据就是从A栈中出栈的数据（这样就刚好相反），
 * 同时考虑中间状态，B栈中已经有数据，根据上面的约定，即B栈中的数据是之前A栈的数据逆向，所以当B栈有数就也就直接取
 *
 * @author LiCola
 * @data 2018/7/23
 */
public class TwoStackQueue<E> {

  private Stack<E> stackA;
  private Stack<E> stackB;

  public TwoStackQueue() {
    this.stackA = new Stack<>();
    this.stackB = new Stack<>();
  }


  public boolean add(E e) {
    stackA.add(e);
    return true;
  }


  public E poll() {
    if (stackB.isEmpty() && stackA.isEmpty()) {
      return null;
    }

    if (stackB.isEmpty()) {
      while (!stackA.isEmpty()) {
        stackB.add(stackA.pop());
      }
    }

    return stackB.pop();
  }

  public E peek() {
    if (stackB.isEmpty() && stackA.isEmpty()) {
      return null;
    }

    if (stackB.isEmpty()) {
      while (!stackA.isEmpty()) {
        stackB.add(stackA.pop());
      }
    }

    return stackB.peek();
  }

}
