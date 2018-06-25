package design.singleton;

import com.licola.llogger.LLogger;
import java.io.BufferedReader;

/**
 * Created by LiCola on 2018/3/14.
 */
public class Client {

  public static final void main(String[] args) {
//    testStatic();
//    testInnerClass();
//    testDCL();
    testClassLoad();
  }

  private static void testClassLoad() {
    //这个只是获取一些类信息 加载类但是不会初始化类
    Class<SingletonStatic> singletonStaticClass = SingletonStatic.class;
    LLogger.d(singletonStaticClass);

    BufferedReader reader=null;

    //反射获取类
    try {
      //默认会进行类加载和初始化，进而使得类的静态变量加载，使得懒汉模式单例失效。
      Class<?> forName = Class.forName("design.singleton.SingletonStatic");

      //方法中指定不初始化类
//      Class<?> forName = Class.forName("design.singleton.SingletonStatic",false,singletonStaticClass.getClassLoader());
      LLogger.d(forName);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }

  private static void testDCL() {

    Thread[] threads = new Thread[100];
    for (int i = 0; i < threads.length; i++) {
      threads[i] = new Thread(new Runnable() {
        @Override
        public void run() {
          LLogger.d(
              "Thread :" + Thread.currentThread().toString() + " instance:" + SingletonDCL
                  .getInstance().hashCode());
        }
      });
    }

    for (Thread itemThread :
        threads) {
      itemThread.start();
    }
  }

  private static void testInnerClass() {
//    LLogger.d(SingletonInnerHolder.validate);
    LLogger.d(SingletonInnerHolder.getInstance());
  }

  private static void testStatic() {
    SingletonStatic singletonStatic;
    LLogger.d(SingletonStatic.class);//访问class 只是得到该类的信息 与实例与类方法无关

    System.out
        .println(SingletonStatic.Validate_delivery_var);//访问final字段 编译器优化 字面量直接被传递过来 .class编译后文件可证实

    LLogger.d(SingletonStatic.Invalidate_Var);//访问非final字段 没有优化 编译器为保证字段的正确赋值 需要client方法执行
  }
}
