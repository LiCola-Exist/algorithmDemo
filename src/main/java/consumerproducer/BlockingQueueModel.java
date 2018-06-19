package consumerproducer;

import com.licola.llogger.LLogger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by LiCola on 2017/11/20. LinkedBlockingQueue内部实现了有容量限制的阻塞链表 take取时：数量为0阻塞 put存时：数量超过容量阻塞
 * 内部实现生产者/消费者模型
 */
public class BlockingQueueModel implements Model {

  //数据核心组件
  private final BlockingQueue<Task> queue;

  //原子id
  private final AtomicInteger increateTaskIds = new AtomicInteger(0);

  public BlockingQueueModel(int cap) {
    this.queue = new LinkedBlockingQueue<>(cap);
  }

  @Override
  public Runnable newRunnableConsumer() {
    return new ConsumerImpl();
  }

  @Override
  public Runnable newRunnableProducer() {
    return new ProducerImpl();
  }

  private class ConsumerImpl extends AbstractConsumer implements Consumer, Runnable {

    @Override
    public void consume() throws InterruptedException {
      Task task = queue.take();
      Thread.sleep(500 + (long) (Math.random() * 500));
      LLogger.d("consume:" + task.taskId);
    }
  }

  private class ProducerImpl extends AbsrcactProducer implements Producer, Runnable {

    @Override
    public void produce() throws InterruptedException {
      Thread.sleep((long) (Math.random() * 1000));
      Task task = new Task(increateTaskIds.getAndIncrement());
      queue.put(task);
      LLogger.d("produce:" + task.taskId);
    }
  }


}
