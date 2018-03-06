package DesignPattern.Bridge;

/**
 * Created by LiCola on 2017/7/28.
 * 实现消息发送的统一接口
 */
public interface MessageImplementor {
  void send(String message,String toUser);
}
