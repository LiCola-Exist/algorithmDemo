package DesignPattern.Iterator;

/**
 * Created by LiCola on 2017/8/1.
 */
public class ConcreteIterator implements Iterator<String> {

  /**
   * 持有被迭代的具体聚合对象
   */
  private ConcreteAggregate aggregate;

  private int index=-1;

  /**
   * 外部依赖注入
   * @param aggregate
   */
  public ConcreteIterator(ConcreteAggregate aggregate) {
    this.aggregate = aggregate;
  }

  @Override
  public void first() {
    this.index=0;
  }

  @Override
  public void next() {
    if (index<this.aggregate.size()){
      index++;
    }
  }

  @Override
  public boolean isDone() {
    return index >= this.aggregate.size();
  }

  @Override
  public String currentItem() {
    return this.aggregate.get(index);
  }
}
