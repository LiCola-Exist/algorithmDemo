package consumerproducer;

/**
 * Created by LiCola on 2017/11/20.
 */
public interface Model {

  Runnable newRunnableConsumer();

  Runnable newRunnableProducer();
}
