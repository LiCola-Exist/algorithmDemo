package DesignPattern.ProducerConsumer.SynchronizeWay;

/**
 * Created by LiCola on 2017/8/11.
 */
public class Producer extends Thread {
  BlockingQueue<String> blockingQueue;

  public Producer(BlockingQueue<String> blockingQueue) {
    this.blockingQueue = blockingQueue;
  }

  @Override
  public void run() {
    int number=0;
    try {
      while (true){
        String task = String.valueOf(number);
        blockingQueue.put(task);
        System.out.println("producer make:"+task);
        number++;
        Thread.sleep((long) (Math.random()*100));
      }
    }catch (InterruptedException e){

    }
  }
}
