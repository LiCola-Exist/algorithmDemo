package design.command;

import com.licola.llogger.LLogger;

/**
 * Created by LiCola on 2018/6/11.
 * 接受者对象
 */
public class Receiver {

  public void action(){
    //真正执行敏力操作的功能代码
    LLogger.d("命令的接收者，执行真正的命令 正向操作");
  }

  public void undo(){
    LLogger.d("反向操作");
  }
}
