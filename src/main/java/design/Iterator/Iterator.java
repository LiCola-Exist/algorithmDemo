package design.Iterator;

/**
 * Created by LiCola on 2017/8/1.
 * 定义迭代器接口
 * 定义访问和遍历操作
 */
public interface Iterator<T> {
  void first();

  void next();

  boolean isDone();

  T currentItem();
}
