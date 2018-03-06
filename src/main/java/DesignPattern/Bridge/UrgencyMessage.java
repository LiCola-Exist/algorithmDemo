package DesignPattern.Bridge;

/**
 * Created by LiCola on 2017/7/28.
 */
public class UrgencyMessage extends AbstractMessage {

  /**
   * 构造方法注入实现
   */
  public UrgencyMessage(MessageImplementor impl) {
    super(impl);
  }

  /**
   *
   * @param message
   * @param toUser
   */
  @Override
  public void sendMessage(String message, String toUser) {
    message="加急："+message;
    super.sendMessage(message, toUser);
  }

  /**
   * 扩展自己的新功能 监控某个消息的处理过程
   * @param messageId
   * @return
   */
  public Object wath(String messageId){
    return null;
  }
}
