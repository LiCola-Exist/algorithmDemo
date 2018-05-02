package DesignPattern.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.sql.SQLException;

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

    if (tClass == Api.class) {
      return "proxyValue";
    } else if (tClass == ServiceApi.class) {
      return "proxyValue with api";
    }

    if (target != null) {
      return method.invoke(target, args);
    }

    return null;
  }
}
