package DesignPattern.ProducerConsumer.SynchronizeWay;

/**
 * Created by LiCola on 2017/8/11.
 */
public class Consumer extends Thread {
  BlockingQueue<String> blockingQueue;

  public Consumer(BlockingQueue<String> blockingQueue) {
    this.blockingQueue = blockingQueue;
  }

  @Override
  public void run() {
    try {
      while (true){
        String take = blockingQueue.take();
        System.out.println("consumer user:"+take);
        Thread.sleep((long) (Math.random()*100));
      }
    }catch (InterruptedException e){

    }
  }
}
