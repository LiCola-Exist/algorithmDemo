package DesignPattern.Singleton;

/**
 * Created by LiCola on 2018/3/14.
 */
public class Client {

  public static final void main(String[] args) {
//    testStatic();
    testInnerClass();

  }

  private static void testInnerClass() {
    System.out.println(SingletonInnerHolder.validate);
    System.out.println(SingletonInnerHolder.getInstance());
  }

  private static void testStatic() {
    SingletonStatic singletonStatic;
    System.out.println(SingletonStatic.class);//访问class 只是得到该类的信息 与实例与类方法无关

    System.out.println(SingletonStatic.Validate_delivery_var);//访问final字段 编译器优化 字面量直接被传递过来 .class编译后文件可证实

    System.out.println(SingletonStatic.Invalidate_Var);//访问非final字段 没有优化 编译器为保证字段的正确赋值 需要client方法执行
  }
}
