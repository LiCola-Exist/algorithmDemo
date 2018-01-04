package consumerproducer;

/**
 * Created by LiCola on 2017/11/20.
 */
public abstract class AbstractConsumer implements Consumer,Runnable{

  @Override
  public void run() {
     while (true){
       try {
         consume();
       } catch (InterruptedException e) {
         e.printStackTrace();
         break;
       }
     }
  }
}
