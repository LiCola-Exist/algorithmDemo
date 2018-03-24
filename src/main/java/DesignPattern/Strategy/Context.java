package DesignPattern.Strategy;

/**
 * Created by LiCola on 2018/3/23.
 */
public class Context {

  /**
   * 持有 具体的策略对象实例
   */
  private Strategy strategy;

  /**
   * 构造方法 依赖注入
   */
  public Context(Strategy strategy) {
    this.strategy = strategy;
  }

  public int calePrice(int price) {
    return strategy.algorithm(price);
  }
}
