package design.Iterator;

/**
 * Created by LiCola on 2017/8/1.
 * 聚合对象的抽象类
 * 定义创建相应迭代器的对象方法
 */
public abstract class Aggregate<T> {
  public abstract Iterator<T> createIterator();
}
