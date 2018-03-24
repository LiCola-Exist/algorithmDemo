package DesignPattern.Proxy;

public class ProxyClient {

  public static final void main(String[] args) {

    //设置属性 保留ProxyGenerator类生成的字节码文件
//    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

    ProxyInstance proxyInstance = new ProxyInstance();
    Api api = proxyInstance.create(Api.class);
    String result = api.doSomething(12);
    System.out.println("result =" + result);

    System.out.println("class:"+api.getClass().toString());

    ProxyInstance proxyInstanceService=new ProxyInstance();
    ServiceApi serviceApi = proxyInstanceService.create(ServiceApi.class);
    String input = serviceApi.input(new Api() {
      @Override
      public String doSomething(int type) {
        throw new RuntimeException("不应该被调用");
//        return null;
      }
    });
    System.out.println("input = "+input);
  }
}
