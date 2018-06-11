package design.memento;

/**
 * Created by LiCola on 2017/7/4.
 * 原发器
 * 持有内部状态 以及一些方法操作等
 * 实现备忘录数据封装 提供内部状态的封装实现功能 、从外部恢复内部数据功能
 */
public class Originator {

  /**
   * 需要保存的 内部状态
   */
  private String status;


  /**
   * 运行方法 修改内部状态
   */
  public void doSomething() {
    status = "run";
  }

  /**
   * 创建基于窄接口的内部类
   * 并保存内部状态到内部类
   */
  public Memento createMemento() {
    MementoImpl memento = new MementoImpl();
    memento.status = status;//保存操作
    return memento;
  }

  /**
   * 从外部 恢复内部状态
   */
  public void setMemento(Memento memento) {
    if (memento instanceof MementoImpl) {
      status = ((MementoImpl) memento).status;//恢复操作
    }
  }


  @Override
  public String toString() {
    return "Originator{" +
        "status='" + status + '\'' +
        '}';
  }

  /**
   * 窄接口的内部实现类
   */
  private static class MementoImpl implements Memento {

    /**
     * 使用默认修饰符
     * 简化数据的set和get方法
     */
    String status;

    public MementoImpl() {
    }
  }
}
