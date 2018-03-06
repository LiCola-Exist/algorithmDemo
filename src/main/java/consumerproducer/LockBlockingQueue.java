package consumerproducer;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by LiCola on 2018/3/3.
 */
public class LockBlockingQueue<E> {

  //任务队列
  private Queue<E> queue = null;
  //队列长度限制
  private int limit;

  private Lock lock = new ReentrantLock();
  private Condition notFull = lock.newCondition();
  private Condition notEmpty = lock.newCondition();

  public LockBlockingQueue(int limit) {
    this.limit = limit;
    queue = new ArrayDeque<>(limit);
  }

  /**
   * 存入操作
   * 和非满notFull条件相关
   */
  public void put(E e) throws InterruptedException {
    lock.lockInterruptibly();
    try {
      while (queue.size() == limit) {
        //数据量等于限定值 非满条件不满足 等待其他线程消耗任务
        notFull.await();
      }
      //成功保存数据 非空条件满足 通知其他线程
      queue.add(e);
      notEmpty.signal();
    } finally {
      lock.unlock();
    }
  }

  public E get() throws InterruptedException {
    lock.lockInterruptibly();
    try {
      while (queue.isEmpty()) {
        //任务队列为空 非空条件不满足 等待其他线程存入任务
        notEmpty.await();
      }
      //成功获取数据 非满条件满足 通知其他线程
      E e = queue.poll();
      notFull.signal();
      return e;
    } finally {
      lock.unlock();
    }
  }

  public static final void main(String[] args) {
//    runThread();

    Thread thread=new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        System.out.println(Thread.currentThread()+" running");
      }
    });

    thread.start();

//    try {
//      thread.join();
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
  }

  private static void runThread() {
    LockBlockingQueue<String> blockingQueue = new LockBlockingQueue<>(3);

    int putThreadNum = 1;
    Thread[] putThreads = new Thread[putThreadNum];
    for (int i = 0; i < putThreads.length; i++) {
      putThreads[i] = new Thread(new Runnable() {
        @Override
        public void run() {
          try {

            int id = 0;
            while (true) {
              blockingQueue.put("task:" + id + "-" + Thread.currentThread());
              Thread.sleep(1000);
              System.out.println(Thread.currentThread() + " put task:" + id);
              id++;
            }

          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      });
    }

    int getThreadNum = 3;
    Thread[] getThreads = new Thread[getThreadNum];
    for (int i = 0; i < getThreads.length; i++) {
      getThreads[i] = new Thread(new Runnable() {
        @Override
        public void run() {
          try {

            while (true) {
              String task = blockingQueue.get();
              System.out.println(Thread.currentThread() + " get task:" + task);
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      });
    }

    for (Thread thread :
        putThreads) {
      thread.start();
    }

    for (Thread thread :
        getThreads) {
      thread.start();
    }
  }
}
