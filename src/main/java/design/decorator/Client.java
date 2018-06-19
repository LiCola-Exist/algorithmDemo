package design.decorator;

import com.licola.llogger.LLogger;

/**
 * Created by LiCola on 2018/4/17.
 */
public class Client {

  public static final void main(String[] args) {
    Component component = new ConcreteDecoratorA(new ConcreteComponent());
    String result = component.operation();
    LLogger.d("装饰模式 得到的动态修饰结果:"+result);

  }
}
