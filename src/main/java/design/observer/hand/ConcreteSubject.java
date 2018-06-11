package design.observer.hand;

/**
 * Created by LiCola on 2018/3/14.
 * 实现具体的目标对象，实现具体的数据内容，在变化时调用notify通知观察者
 */
public class ConcreteSubject extends Subject{

  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String newStatus){
    this.status=newStatus;
    this.notifyObservers();
  }
}
