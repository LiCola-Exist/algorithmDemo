package DesignPattern.Visitor;

/**
 * Created by LiCola on 2017/7/8.
 */
public class ConcreteElementB extends Element {

  @Override
  public void accept(Visitor visitor) {
    visitor.visitConcreteElementB(this);
  }

  /**
   * 假设已经存在的功能
   */
  public void opertionB(){

  }
}
