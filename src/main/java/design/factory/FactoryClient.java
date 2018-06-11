package design.factory;

/**
 * Created by LiCola on 2018/3/20.
 */
public class FactoryClient {

  public static final void main(String[] args) {
    Api api = Factory.createApi(0);
    api.operate("正在使用抽象工厂 参数0 得到接口实现对象");

    Api api1 = Factory.createApi(1);
    api1.operate("正在使用抽象工厂 参数1 得到接口实现对象");
  }
}
