package design.strategy;

import com.licola.llogger.LLogger;
import design.strategy.Strategy.ConcreteStrategyOriginal;

/**
 * Created by LiCola on 2018/3/23.
 * 策略模式的本质：分离算法，选择实现
 * 把一系列算法封装起来，使得能够互相替换。
 */
public class StrategyClient {

  public static final void main(String[] args) {
    Strategy strategy = new ConcreteStrategyOriginal();
    Context context = new Context(strategy);
    int price = context.calePrice(100);
    LLogger.d("price:" + price);


  }
}
