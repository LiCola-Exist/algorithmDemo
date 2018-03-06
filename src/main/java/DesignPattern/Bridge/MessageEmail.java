package DesignPattern.Bridge;

/**
 * Created by LiCola on 2017/7/28.
 */
public class MessageEmail implements MessageImplementor {

  @Override
  public void send(String message, String toUser) {
    System.out.println("使用Email方式 发送消息:" + message + " 给:" + toUser);

  }
}
