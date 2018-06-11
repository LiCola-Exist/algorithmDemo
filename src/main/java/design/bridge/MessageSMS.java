package design.bridge;

/**
 * Created by LiCola on 2017/7/28.
 */
public class MessageSMS implements MessageImplementor {

  @Override
  public void send(String message, String toUser) {
    System.out.println("使用站内消息方式 发送消息:" + message + " 给:" + toUser);
  }
}
