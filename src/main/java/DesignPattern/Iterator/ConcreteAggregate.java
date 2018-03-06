package DesignPattern.Iterator;

/**
 * Created by LiCola on 2017/8/1.
 */
public class ConcreteAggregate extends Aggregate<String> {

  /**
   * 示意 表示聚合对象持有的具体内容
   */
  private String[] array=null;

  /**
   * 构造方法 外部注入依赖
   * @param array
   */
  public ConcreteAggregate(String[] array) {
    this.array = array;
  }

  @Override
  public Iterator<String> createIterator() {
    return new ConcreteIterator(this);
  }

  public int size(){
    return array.length;
  }

  public String get(int index) {
    String data=null;
    if (index<size()){
      data=array[index];
    }
    return data;
  }
}
