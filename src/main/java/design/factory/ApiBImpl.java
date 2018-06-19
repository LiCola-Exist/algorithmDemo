package design.factory;

import com.licola.llogger.LLogger;

/**
 * Created by LiCola on 2018/3/20.
 */
public class ApiBImpl implements Api {

  @Override
  public void operate(String arg) {
    LLogger.d("api b impl run :"+arg);
  }
}
