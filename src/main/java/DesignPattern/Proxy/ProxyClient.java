package DesignPattern.Proxy;

public class ProxyClient {




  public static final void main(String[] args) {
    ProxyInstance proxyInstance = new ProxyInstance();
    Api api = proxyInstance.create(Api.class);
    String result = api.doSomething(12);
    System.out.println("result =" + result);


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
