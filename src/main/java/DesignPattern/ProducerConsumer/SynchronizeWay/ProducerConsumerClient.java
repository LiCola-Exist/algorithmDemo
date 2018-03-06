package DesignPattern.ProducerConsumer.SynchronizeWay;

/**
 * Created by LiCola on 2017/8/11.
 */
public class ProducerConsumerClient {

  public static final void main(String[] args) {
     BlockingQueue<String> queue=new BlockingQueue<>(10);
     new Producer(queue).start();
     new Consumer(queue).start();
  }
}
