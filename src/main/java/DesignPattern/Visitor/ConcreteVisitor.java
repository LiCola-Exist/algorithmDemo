package DesignPattern.Visitor;

/**
 * Created by LiCola on 2017/7/8.
 * 具体的访问者实现
 */
public class ConcreteVisitor implements Visitor {

  @Override
  public void visitConcreteElementA(ConcreteElementA elementA) {
    /**
     * 把要访问ConcreteElementA时 需要执行的功能实现在这里
     * 可能需要访问元素已有得共
     */
    elementA.opertionA();
  }

  @Override
  public void visitConcreteElementB(ConcreteElementB elementB) {
    elementB.opertionB();
  }
}
