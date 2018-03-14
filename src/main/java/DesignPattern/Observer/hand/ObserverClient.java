package DesignPattern.Observer.hand;

/**
 * Created by LiCola on 2018/3/14.
 * 手动版的 观察者模式。
 * 相比jdk版的观察者模式，代码稍多，但是定制化程度高，
 * 在Observer接口中明确定义将受到的消息类型，而不是为了兼容直接使用Object。
 * 而且JDK版本提供了多线程的控制（同步锁，同步容器），在一些场景中是多余的，
 * 典型如Android的点击事件，事件的发生全部在主线程中，且Observer传递的接口参数比较复杂，
 * 所以一般针对一种事件定义一种Observer观察者接口
 */
public class ObserverClient {

  public static final void main(String[] args) {
    ConcreteSubject subject = new ConcreteSubject();

    Observer observer = new ConcreteObserver();

    subject.attach(observer);//绑定观察者和观察目标对象

    subject.setStatus("change");

  }
}
