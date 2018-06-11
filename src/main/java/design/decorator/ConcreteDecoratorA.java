package design.decorator;

/**
 * Created by LiCola on 2018/4/17.
 */
public class ConcreteDecoratorA extends Decorator {

  public ConcreteDecoratorA(Component component) {
    super(component);
  }

  @Override
  public String operation() {
    System.out.println("动态添加了功能A");
    String old = super.operation();
    return "A动态修饰返回值 "+old;
  }
}
