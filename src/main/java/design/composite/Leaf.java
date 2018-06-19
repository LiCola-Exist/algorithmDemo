package design.composite;

import com.licola.llogger.LLogger;

/**
 * Created by LiCola on 2017/8/4.
 */
public class Leaf extends Component {

  public Leaf(String name) {
    super(name);
  }

  @Override
  public void someOperation() {
    LLogger.d(name+" 子对象 操作方法调用");
  }
}
