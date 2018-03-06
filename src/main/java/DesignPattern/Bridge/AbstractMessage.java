package DesignPattern.Bridge;

/**
 * Created by LiCola on 2017/7/28. 抽象的消息对象
 */
public abstract class AbstractMessage {

  /**
   * 持有一个实现部分的对象
   */
  protected MessageImplementor impl;

  /**
   * 构造方法注入实现
   * @param impl
   */
  public AbstractMessage(MessageImplementor impl) {
    this.impl = impl;
  }

  /**
   * 发送消息 转调实现部分的方法
   * @param message
   * @param toUser
   */
  public void sendMessage(String message, String toUser) {
    this.impl.send(message, toUser);
  }
}
