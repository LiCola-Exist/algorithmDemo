package design.command;

import com.licola.llogger.LLogger;

/**
 * Created by LiCola on 2018/6/11.
 * 要求命令对象执行请求，可以持有多个命令对象
 * 这是暴露给外部触发命令执行的对象
 * 相当于命令对象入口
 */
public class Invoker {

  /**
   * 持有命令对象
   */
  private Command commandAction;

  public void setCommandAction(Command command) {
    LLogger.d("命令运行入口-组装命令对象");
    this.commandAction = command;
  }

  private Command commandUndo;

  public void setCommandUndo(Command commandUndo) {
    this.commandUndo = commandUndo;
  }

  /**
   * 提供给外部，运行命令
   */
  public void runCommand(){
    LLogger.d("命令运行入口 开始运行");
    commandAction.execute();
  }

  public void undoCommand(){
    commandUndo.execute();
  }
}
