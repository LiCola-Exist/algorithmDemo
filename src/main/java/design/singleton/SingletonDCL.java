package design.singleton;

import com.licola.llogger.LLogger;

/**
 * Created by LiCola on 2018/3/14. DCL（Double Checked Lock）双重检查锁的单例 由同步锁和volatile保证 线程安全
 * 缺点是：代码比较复杂，同步机制会损失一些性能， 在一些场景中是饿汉单例模式的替换方案 典型如，EventBus中，因为需要引入其他的设计模式（Builder建造者模式）配置EventBus
 * 代码无法直接使用饿汉模式，使用DCL替换实现单例
 *
 * 因为单例的实例化是在静态方法中调起的，所以即使通过反射Class.forName也不会导致单例的实例化启动
 */
public class SingletonDCL {

  //volatile原子 修饰 保证内存可见性以及指令重排
  private volatile static SingletonDCL INSTANCE = null;

  public static SingletonDCL getInstance() {
    //先检查实例是否存在 如果不存在 才进入类同步代码块 优化处理 避免每次都需要加锁
    if (INSTANCE == null) {
      //对类加锁
      synchronized (SingletonDCL.class) {
        //再次检查 最后同步后还不存在 才会真正的实例化
        if (INSTANCE == null) {
          INSTANCE = new SingletonDCL();
        }
      }
    }
    return INSTANCE;
  }

  private SingletonDCL() {
    LLogger.d("单例被实例化");
  }

  static {
    LLogger.d("单例类初始化");
  }
}
