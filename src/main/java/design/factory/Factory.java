package design.factory;

/**
 * Created by LiCola on 2018/3/20.
 */
public class Factory {

  /**
   * 具体的创建Api对象的方法
   * @param type 从外部传入的选择条件 协商好的参数形式
   * @return 根据type选择 创建的对象
   */
  public static Api createApi(int type){
    if (type==0){
      return new ApiAImpl();
    }else if (type==1){
      return new ApiBImpl();
    }else {
      return null;
    }
  }
}
