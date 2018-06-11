package design.observer.hand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiCola on 2018/3/13.
 * 手工版 观察者模式
 * 目标对象，它持有观察者对象，提供注册和删除功能，最重要的是通知观察者
 *
 */
public class Subject {

  private List<Observer> observers=new ArrayList<>();

  public void attach(Observer observer){
    observers.add(observer);
  }

  public void detach(Observer observer){
    observers.remove(observer);
  }

  protected void notifyObservers(){
    for (Observer item :
        observers) {
      item.update(this);
    }
  }
}
