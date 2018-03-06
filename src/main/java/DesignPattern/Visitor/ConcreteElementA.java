package DesignPattern.Visitor;

/**
 * Created by LiCola on 2017/7/8.
 * 具体的元素实现对象
 */
public class ConcreteElementA extends Element{

  @Override
  public void accept(Visitor visitor) {
    //回调访问者对象的相应方法
    visitor.visitConcreteElementA(this);
  }

  /**
   * 假设已经存在的功能
   */
  public void opertionA(){

  }
}
