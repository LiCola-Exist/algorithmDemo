package design.bridge;

import com.licola.llogger.LLogger;

/**
 * Created by LiCola on 2017/7/28.
 */
public class MessageEmail implements MessageImplementor {

  @Override
  public void send(String message, String toUser) {
    LLogger.d("使用Email方式 发送消息:" + message + " 给:" + toUser);

  }
}
