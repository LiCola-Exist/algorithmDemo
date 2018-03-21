package DesignPattern.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInstance implements InvocationHandler {



  public <T> T create(final Class<T> tClass){
    Object instance = Proxy.newProxyInstance(tClass.getClassLoader(), new Class[]{tClass}, this);
    return tClass.cast(instance);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (args==null||args.length==0){
      return null;
    }

    Class<?> returnType = method.getReturnType();

    if (returnType.equals(String.class)){
      return "proxyValue";
    }
    else {
      return null;
    }
  }
}
