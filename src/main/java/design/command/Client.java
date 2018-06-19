package design.command;

/**
 * Created by LiCola on 2018/6/11.
 * 创建具体的命令对象，并设置命令对象的接收者
 * 客户端的功能添加了，组装命令对象和接收者,可以称为装配者
 */
public class Client {

  public static final void main(String[] args){

    //创建接收者
    Receiver receiver=new Receiver();

    //创建命令对象 并注入接收者
    Command command=new ActionCommand(receiver);

    //创建invoker对象 注入命令对象
    Invoker invoker=new Invoker();
    invoker.setCommandAction(command);

    //通过持有的命令对象 执行对应的命令
    invoker.runCommand();
  }
}
