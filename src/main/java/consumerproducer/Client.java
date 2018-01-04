package consumerproducer;

/**
 * Created by LiCola on 2017/11/20.
 */
public class Client {

  public static final void main(String[] args) {

    Model model = new BlockingQueueModel(3);

    int consumerSize = 1;
    int producerSize = 1;

    for (int i = 0; i < consumerSize; i++) {
      new Thread(model.newRunnableConsumer()).start();
    }

    for (int i = 0; i < producerSize; i++) {
      new Thread(model.newRunnableProducer()).start();
    }


  }
}
