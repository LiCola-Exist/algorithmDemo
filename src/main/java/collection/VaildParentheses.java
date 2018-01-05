package collection;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by LiCola on 2018/1/5.
 * https://leetcode.com/problems/valid-parentheses/description/
 * 检查输入的字符串中括号匹配，如果匹配返回true，否则返回false
 */
public class VaildParentheses {

  /**
   * 括号匹配 在计算机的内部实现就是栈 这里就可以用栈处理入栈和出栈
   * 一旦使用集合类就引入泛型也就引入包装类，
   * 当基本类和包装的比对就发生自动拆包行为，但是null自动拆包就发生NPE异常，需要处理
   */
  public static boolean isValidStack(String input) {


    if (input == null || input.equals("")) {
      return true;
    }

    Deque<Character> stack = new ArrayDeque<>(input.length());
    for (char item : input.toCharArray()) {

      if (item == '(' || item == '[' || item == '{') {
        stack.push(item);
      } else if (')' == item && (stack.peek() == null || '(' != stack.poll())) {
        return false;
      } else if (']' == item && (stack.peek() == null || '[' != stack.poll())) {
        return false;
      } else if ('}' == item && (stack.peek() == null || '{' != stack.poll())) {
        return false;
      }
    }
    return stack.isEmpty();
  }
}
