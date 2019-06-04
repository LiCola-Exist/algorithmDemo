package design.proxy;

import com.licola.llogger.LLogger;
import java.lang.reflect.Proxy;
import java.sql.SQLException;

public class ProxyClient {

  public static final void main(String[] args) {

    LLogger.init();

    //设置属性 保留ProxyGenerator类生成的字节码文件
    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

    testApi();

//    testService();

//    testException();
  }


  private static void testApi() {
    Api api = ProxyInstance.create(Api.class);
    String result = api.doSomething(12);

    LLogger.d("api: result =" + result);

    LLogger.d("api: class:" + api.getClass().toString());
  }

  private static void testService() {
    ServiceApi serviceApi = ProxyInstance.create(ServiceApi.class);
    String input = serviceApi.input(new Api() {
      @Override
      public String doSomething(int type) {
        throw new RuntimeException("不应该被调用");
//        return null;
      }
    });
    LLogger.d("service: input = " + input);
  }

  private static void testException() {

    ApiException apiExceptionImpl = new ApiExceptionImpl();
    ApiException apiException = (ApiException) Proxy
        .newProxyInstance(apiExceptionImpl.getClass().getClassLoader(),
            apiExceptionImpl.getClass().getInterfaces(), new ProxyInstance<>(apiExceptionImpl));

    try {
      apiException.throwException();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  private static class ApiExceptionImpl implements ApiException {

    @Override
    public void throwException() throws SQLException {
      throw new SQLException("故意抛出的受检异常");
    }
  }
}
