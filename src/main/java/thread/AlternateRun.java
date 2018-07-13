package thread;

import com.licola.llogger.LLogger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by LiCola on 2018/7/13. 两个线程交替打印奇偶数
 */
public class AlternateRun {

  private static final int MAX_LIMIT = 10;

  private int start = 1;

  private boolean oddEvenFlag = false;

  private final static Lock LOCK = new ReentrantLock();

  public static final void main(String[] args) {
    AlternateRun alternateRun = new AlternateRun();

    Thread threadOdd = new Thread(new OddRunnable(alternateRun));
    threadOdd.setName("odd-thread");
    Thread threadEven = new Thread(new EvenRunnable(alternateRun));
    threadEven.setName("even-thread");

    threadOdd.start();
    threadEven.start();

  }

  static class OddRunnable implements Runnable {

    private AlternateRun instance;

    public OddRunnable(AlternateRun instance) {
      this.instance = instance;
    }

    @Override
    public void run() {
      while (instance.start <= MAX_LIMIT) {
        if (!instance.oddEvenFlag) {
          try {
            LOCK.lock();
            LLogger.d(instance.start);
            instance.start++;
            instance.oddEvenFlag = true;
          } finally {
            LOCK.unlock();
          }
        } else {
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

  static class EvenRunnable implements Runnable {

    private AlternateRun instance;

    public EvenRunnable(AlternateRun instance) {
      this.instance = instance;
    }

    @Override
    public void run() {
      while (instance.start <= MAX_LIMIT) {
        if (instance.oddEvenFlag) {
          try {
            LOCK.lock();
            LLogger.d(instance.start);
            instance.start++;
            instance.oddEvenFlag = false;
          } finally {
            LOCK.unlock();
          }
        } else {
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
