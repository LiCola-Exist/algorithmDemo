package DesignPattern.Decorator;

/**
 * Created by LiCola on 2018/4/17.
 */
public abstract class Decorator extends Component{

  protected Component component;

  public Decorator(Component component) {
    this.component = component;
  }

  @Override
  public String operation() {
    //转发请求给包装对象 可以在转发前添加功能
    return component.operation();
  }
}
