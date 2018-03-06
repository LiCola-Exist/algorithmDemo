package DesignPattern.ProducerConsumer.SynchronizeWay;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by LiCola on 2017/8/11.
 * 协作的共享变量，阻塞队列。
 * 生产者：往队列上放数据，如果数量满了，就wait等待消费。
 * 消费者：从队列上取数据，如果队列为空，就wait等待生产。
 *，put和take都调用了wait，但它们的目的是不同的，或者说，它们等待的条件是不一样的，
 * put等待的是队列不为满，而take等待的是队列不为空，
 * 但它们都会加入相同的条件等待队列。由于条件不同但又使用相同的等待队列，
 * 所以要调用notifyAll而不能调用notify，因为notify只能唤醒一个线程，如果唤醒的是同类线程就起不到协调的作用。
 */
public class BlockingQueue<E> {
  private Queue<E> queue =null;

  private int limit;

  public BlockingQueue(int limit) {
    this.limit = limit;
    queue=new ArrayDeque<>(limit);
  }

  /**
   * 数据的存入put方法，提供给生产者使用。
   * 当长度等于限定就wait。否则就存入数据并调用notifyAll通知可能的消费者
   * @param e
   * @throws InterruptedException
   */
  public synchronized void put(E e) throws InterruptedException {
    while (queue.size()==limit){
      wait();
    }
    queue.add(e);
    notifyAll();
  }

  /**
   * 数据的取出take方法，提供给消费者使用。
   * 当队列为空就wait，否则取出数据并调用notifyAll通知可能的生产者。
   * @return
   * @throws InterruptedException
   */
  public synchronized E take() throws InterruptedException {
    while (queue.isEmpty()){
      wait();
    }
    E e=queue.poll();
    notifyAll();
    return e;
  }
}
