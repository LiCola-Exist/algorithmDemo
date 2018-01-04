package consumerproducer;

/**
 * Created by LiCola on 2017/11/20.
 */
public abstract class AbsrcactProducer implements Producer, Runnable {

  @Override
  public void run() {
    while (true) {
      try {
        produce();
      } catch (InterruptedException e) {
        e.printStackTrace();
        break;
      }
    }
  }
}
