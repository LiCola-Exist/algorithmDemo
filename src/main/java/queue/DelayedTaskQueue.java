package queue;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by LiCola on 2017/11/27. 多考生考试： 1：考试总时间为10秒，至少2秒后才可进行交卷。 2：考生可在2-10秒这段时间内的任意时间交卷。
 * 3：考试时间一到，所有未交卷的学生必须交卷。
 */
public class DelayedTaskQueue {


  enum Times {
    SUBMIT_TIME(10),
    SUBMIT_LIMIT(2),
    MAX_RAND_TIME(15);
    private final int value;

    Times(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }


  static class Student implements Delayed {

    private String name;
    private long delay;
    private long expire;

    public static int getRandomSeconds() { // 获取随机花费时间，范围：2-10秒
      return new Random().nextInt(Times.MAX_RAND_TIME.getValue() - Times.SUBMIT_LIMIT.getValue())
          + Times.SUBMIT_LIMIT.getValue();
    }

    /**
     * 构造随机生成的考试花费时间
     */
    public Student(String name) {
      this.name = name;
      this.delay = TimeUnit.MILLISECONDS
          .convert(getRandomSeconds(), TimeUnit.SECONDS); // 随机生成考试花费时间
      this.expire = System.currentTimeMillis() + this.delay;
    }

    /**
     * 构造 指定过期时间（即考试花费时间）
     */
    public Student(String name, long delay, TimeUnit unit) {
      this.name = name;
      this.delay = TimeUnit.MILLISECONDS.convert(delay, unit);
      this.expire = System.currentTimeMillis() + this.delay;
    }

    /**
     * 设置花费时间和交卷时间，考试时间结束强制交卷时调用此方法
     */
    public Student submit() {
      setDelay(Times.SUBMIT_TIME.getValue(), TimeUnit.SECONDS);
      setExpire(System.currentTimeMillis());
      return this;
    }

    public void setDelay(long delay, TimeUnit unit) {
      this.delay = TimeUnit.MILLISECONDS.convert(delay, TimeUnit.SECONDS);
    }

    public void setExpire(long expire) {
      this.expire = expire;
    }

    @Override
    public long getDelay(TimeUnit unit) {// 这里返回的是剩余延时，当延时为0时，此元素延时期满，可从take()取出
      return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) { // 此方法的实现用于定义优先级
      long td = this.getDelay(TimeUnit.MILLISECONDS);
      long od = o.getDelay(TimeUnit.MILLISECONDS);
      return Long.compare(td, od);
    }

    @Override
    public String toString() {
      return "学生姓名：" + this.name + ",考试用时：" + TimeUnit.SECONDS.convert(delay, TimeUnit.MILLISECONDS)
          + ",交卷时间："
          + DateFormat.getDateTimeInstance().format(new Date(this.expire));
    }
  }

  public static final void main(String[] args) throws InterruptedException {
    DelayQueue<Student> delayQueue = new DelayQueue<>();
    for (int i = 0; i < 10; i++) {
      delayQueue.add(new Student("student:" + i));
    }

    //添加一个 特殊的点 根据优先级
    delayQueue.add(new Student("submit",
        Times.SUBMIT_TIME.getValue(), TimeUnit.SECONDS));

    System.out.println("开始考试:" + DateFormat.getDateTimeInstance().format(new Date()));
    while (true) {
      //延时的取出元素（这里空队列的阻塞不会发生 因为队列构造在之前）
      //取出方法 会改变堆结构 保证当前堆按照优先级排序
      Student student = delayQueue.take();

      if (student.name.equals("submit")) {
        //取出特殊的 终止节点 根据规则强制全部结束
        System.out.println("终止时间到， 全部人交卷");
        delayQueue.parallelStream()
            .filter(item -> item.expire
                >= student.expire)//过滤 取出超时的节点 其实可以不执行 因为根据 延时操作 当前节点中保存的全部是 超时节点
            .map(Student::submit)//对取出的超时列表元素 强制调用方法 结束
            .forEach(System.out::println);//输出节点信息
       return;
      } else {
        //取出普通的元素 延时的取出 说明该元素到期
        System.out.println(student);
      }
    }


  }

}
