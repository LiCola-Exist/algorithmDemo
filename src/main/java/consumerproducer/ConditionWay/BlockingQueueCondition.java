package consumerproducer.ConditionWay;

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
  private Condition notFull = lock.newCondition();//锁的显式条件 非满
  private Condition notEmpty = lock.newCondition();//锁的显示条件 非空

  public BlockingQueueCondition(int limit) {
    this.limit = limit;
    queue = new ArrayDeque<>(limit);
  }

  public void put(E e) throws InterruptedException {
    lock.lockInterruptibly();
    try {
      while (queue.size() == limit) {
        //任务队列已满 等待非满条件信号
        notFull.await();
      }
      //成功添加新任务 非空条件唤醒
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
        //任务队列为空 等待非空条件信号
        notEmpty.await();
      }
      //成功取出任务 非满条件唤醒
      E e = queue.poll();
      notFull.signal();
      return e;
    } finally {
      lock.unlock();
    }

  }
}
