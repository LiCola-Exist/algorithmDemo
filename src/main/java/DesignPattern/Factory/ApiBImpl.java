package DesignPattern.Factory;

/**
 * Created by LiCola on 2018/3/20.
 */
public class ApiBImpl implements Api {

  @Override
  public void operate(String arg) {
    System.out.println("api b impl run :"+arg);
  }
}
