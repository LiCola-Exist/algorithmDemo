package design.singleton;

import com.licola.llogger.LLogger;

/**
 * Created by LiCola on 2018/3/14.
 * 类级内部类的单例实现，由JVM类加载机制保证线程安全，巧妙的由类级内部类实现访问控制限制
 */
public class SingletonInnerHolder {

  public static String validate = "提供外部访问的字段";

  //类级内部类 作为类的变量 由JVM加载 保证了线程安全
  private static class SingletonHolder {

    //类级内部类的 静态变量 类级内部类可以访问到外部类的静态方法 所以可以访问到私有的构造方法
    private static SingletonInnerHolder INSTANCE = new SingletonInnerHolder();

    static {
      LLogger.d("内部类的初始化");
    }

  }

  //访问类级内部类 导致虚拟机加载类 线程安全的初始化实例
  public static SingletonInnerHolder getInstance() {
    return SingletonHolder.INSTANCE;
  }

  private SingletonInnerHolder() {
    LLogger.d("类级内部类的单例 实例化");
  }

  static {
    LLogger.d("外部类的初始化");
  }
}
