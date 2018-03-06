package DesignPattern.Bridge;

/**
 * Created by LiCola on 2017/7/28.
 */
public class BridgeClient {
  public static final void main(String[] args){
    MessageImplementor implementor=new MessageSMS();

    AbstractMessage manager=new CommonMessage(implementor);
    manager.sendMessage("消息内容","Li");

    manager=new UrgencyMessage(implementor);
    manager.sendMessage("消息内容","Li");

    implementor=new MessageEmail();
    
    manager=new CommonMessage(implementor);
    manager.sendMessage("消息内容","Li");

    manager=new UrgencyMessage(implementor);
    manager.sendMessage("消息内容","Li");

  }
}
