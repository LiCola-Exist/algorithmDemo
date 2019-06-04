package design.proxy;

import com.licola.llogger.LLogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInstance<T> implements InvocationHandler {

  private Class<T> tClass;
  private T target;

  public static <T> T create(final Class<T> tClass) {
    ProxyInstance<T> proxyInstance = new ProxyInstance<>();
    proxyInstance.tClass = tClass;
    Object instance = Proxy
        .newProxyInstance(tClass.getClassLoader(),
            new Class[]{tClass}, proxyInstance);
    return tClass.cast(instance);
  }

  public ProxyInstance() {

  }

  public ProxyInstance(T target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


    Class<?> returnType = method.getReturnType();
    LLogger.trace();
    if (tClass == Api.class) {
      return "proxyValue";
    } else if (tClass == ServiceApi.class) {
      return "proxyValue with api";
    }

    if (target != null) {
      //经过代理方法调用 如果代理的方法有受检异常

      //直接的方法调用会变成未受检异常UndeclaredThrowableException
      return method.invoke(target, args);

      //手动catch捕获反射方法调用时的调用目标异常 并抛出实际异常
//      try {
//        return method.invoke(target, args);
//      } catch (InvocationTargetException e) {
//        throw e.getCause();
//      }

    }

    return null;
  }
}
