package design.bridge;

import com.licola.llogger.LLogger;

/**
 * Created by LiCola on 2017/7/28.
 */
public class MessageSMS implements MessageImplementor {

  @Override
  public void send(String message, String toUser) {
    LLogger.d("使用站内消息方式 发送消息:" + message + " 给:" + toUser);
  }
}
