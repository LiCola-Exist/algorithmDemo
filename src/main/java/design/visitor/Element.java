package design.visitor;

/**
 * Created by LiCola on 2017/7/8.
 * 被访问的元素的抽象
 */
public abstract class Element {

  /**
   * 接收访问者的访问
   * @param visitor 访问者对象
   */
  public abstract void accept(Visitor visitor);
}
