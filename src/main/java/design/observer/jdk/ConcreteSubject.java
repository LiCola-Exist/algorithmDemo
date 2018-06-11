package design.observer.jdk;

import java.util.Observable;

/**
 * Created by LiCola on 2017/8/24.
 * 具体的目标对象 继承可观察类，因为通过继承得到父类的功能和变量
 */
public class ConcreteSubject extends Observable{
  private String content;

  public String getContent() {
    return content;
  }

  public void setContent(String content){
    this.content=content;
    this.setChanged();
    /**
     * 推模式：目标对象主动向观察者 推送数据
     * 而不管观察者是否需要，可以推送部分内容
     */
    this.notifyObservers(this.content);
    /**
     * 拉模式：目标对象在通知观察者时只传递少量，甚至不传递数据
     * 如果观察者需要更多数据，由观察者主动到目标对象中获取，一般传递目标对象自己，由观察者使用
     */
//    this.notifyObservers();
  }
}
