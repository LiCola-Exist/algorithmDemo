package DesignPattern.Observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by LiCola on 2017/8/24.
 */
public class ConcreteObserver implements Observer {

  public String name;

  public ConcreteObserver(String name) {
    this.name = name;
  }

  @Override
  public void update(Observable observable, Object arg) {
    System.out.println("name:"+name+" observable:"+observable+" arg:"+arg);
  }


}
