package DesignPattern.Observer.hand;

/**
 * Created by LiCola on 2018/3/13.
 * 观察者接口，
 * 定义更新方法，暴露给目标对象发生变化后调用
 */
public interface Observer {
  void update(Subject subject);
}
