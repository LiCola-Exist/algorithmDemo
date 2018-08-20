package design.command;

import com.licola.llogger.LLogger;

/**
 * Created by LiCola on 2018/6/11. 具体的命令实现对象
 */
public class ActionCommand implements Command {

  /**
   * 持有相应的接受者对象
   */
  private Receiver receiver;

  public ActionCommand(Receiver receiver) {
    LLogger.d("注入实际命令执行者-接受者对象");
    this.receiver = receiver;
  }

  @Override
  public void execute() {
    //转调接收者对象的对应方法 让接收者来真正实现执行功能
    LLogger.d("命令对象转调接受者的执行方法");
    receiver.action();
  }
}
