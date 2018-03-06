package DesignPattern.Iterator;

/**
 * Created by LiCola on 2017/8/1.
 */
public class IteratorClient {

  public static final void main(String[] args) {
    IteratorClient client = new IteratorClient();
    client.somOperate();

    System.out.println("data " + (100 * 0.75f));
    System.out.println("data " + (100 * 3 >> 2));
  }

  public void somOperate() {
    String[] data = new String[]{"data1", "data2", "data3"};

    Aggregate<String> aggregate = new ConcreteAggregate(data);
    Iterator<String> iterator = aggregate.createIterator();
    iterator.first();
    while (!iterator.isDone()) {
      String s = iterator.currentItem();
      System.out.println("item = " + s);
      iterator.next();
    }
  }
}
