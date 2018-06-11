package design.observer.hand;

/**
 * Created by LiCola on 2018/3/14.
 * 实现观察者接口，具体处理内容变化
 */
public class ConcreteObserver implements Observer {

  @Override
  public void update(Subject subject) {
    if (subject instanceof ConcreteSubject) {
      String status = ((ConcreteSubject) subject).getStatus();
      System.out.println("观察者 收到新消息:" + status);
    }
  }
}
