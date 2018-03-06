package DesignPattern.Observer;

/**
 * Created by LiCola on 2017/8/24.
 */
public class ObserverClient {

  public static final void main(String[] args){
      ConcreteSubject subject=new ConcreteSubject();

      ConcreteObserver observer1=new ConcreteObserver("观察者1");
      ConcreteObserver observer2=new ConcreteObserver("观察者2");
      ConcreteObserver observer3=new ConcreteObserver("观察者3");

      subject.addObserver(observer1);
      subject.addObserver(observer2);
      subject.addObserver(observer3);

      subject.setContent("目标对象修改了数据");
  }
}
