package DesignPattern.ProducerConsumer.ConditionWay;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by LiCola on 2017/11/20.
 */
public class BlockingQueueCondition<E> {

  private Queue<E> queue = null;
  private int limit;
  private Lock lock = new ReentrantLock();//重入锁
  private Condition notFull = lock.newCondition();//锁的显式条件 不满
  private Condition notEmpty = lock.newCondition();//锁的显示条件 不空

  public BlockingQueueCondition(int limit) {
    this.limit = limit;
    queue = new ArrayDeque<>(limit);
  }

  public void put(E e) throws InterruptedException {
    lock.lockInterruptibly();
    try {
      while (queue.size() == limit) {
        notFull.await();
      }
      queue.add(e);
      notEmpty.signal();
    } finally {
      lock.unlock();
    }
  }

  public E take() throws InterruptedException {
    lock.lockInterruptibly();
    try {
      while (queue.isEmpty()) {
        notEmpty.await();
      }
      E e = queue.poll();
      notFull.signal();
      return e;
    } finally {
      lock.unlock();
    }

  }
}
