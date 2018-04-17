package DesignPattern.Decorator;

/**
 * Created by LiCola on 2018/4/17.
 */
public class ConcreteDecoratorB extends Decorator {

  public ConcreteDecoratorB(Component component) {
    super(component);
  }

  private void addFunciton(){
    System.out.println("动态添加了方法B");
  }

  @Override
  public String operation() {
    String old = super.operation();
    return "B修饰返回值" +old;
  }
}
