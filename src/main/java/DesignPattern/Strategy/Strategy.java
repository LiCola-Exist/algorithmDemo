package DesignPattern.Strategy;

/**
 * Created by LiCola on 2018/3/23.
 * 策略模式 定义算法接口
 */
public interface Strategy {

  int algorithm(int price);

  class ConcreteStrategyOriginal implements Strategy{

    @Override
    public int algorithm(int price) {
      System.out.println("具体算法A的实现 原值");
      return price;
    }
  }

  class ConcreteStrategyHalf implements Strategy{


    @Override
    public int algorithm(int price) {
      System.out.println("具体算法B的实现 折半");
      return price<<1;
    }
  }

}
