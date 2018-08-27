package design.visitor.base;

/**
 * Created by LiCola on 2017/7/8.
 */
public interface Visitor {

  /**
   * 访问元素A 相当于给元素A添加访问者功能
   * @param elementA
   */
  void visitConcreteElementA(ConcreteElementA elementA);

  void visitConcreteElementB(ConcreteElementB elementB);
}
