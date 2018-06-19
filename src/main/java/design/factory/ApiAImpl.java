package design.factory;

import com.licola.llogger.LLogger;

/**
 * Created by LiCola on 2018/3/20.
 * 接口的具体实现类
 */
public class ApiAImpl implements Api {

  @Override
  public void operate(String arg) {
    LLogger.d("api a impl run :"+arg);
  }
}
