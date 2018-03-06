package DesignPattern.Bridge;

/**
 * Created by LiCola on 2017/7/28.
 */
public class CommonMessage extends AbstractMessage {

  /**
   * 构造方法注入实现
   */
  public CommonMessage(MessageImplementor impl) {
    super(impl);
  }

  /**
   * 对于普通消息 直接调用父类方法 发送消息
   * @param message
   * @param toUser
   */
  @Override
  public void sendMessage(String message, String toUser) {
    super.sendMessage(message, toUser);
  }
}
