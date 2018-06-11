package design.memento;

/**
 * Created by LiCola on 2017/7/4.
 * 备忘录管理者
 * 实现对备忘录窄接口实现类的保存和恢复
 */
public class Caretaker {

  /**
   * 为示例简单 只以内存形式保存
   */
  private Memento memento;

  /**
   * 保存到内存
   * @param memento
   */
  public void saveMemento(Memento memento) {
    this.memento = memento;
  }

  /**
   * 从内存中恢复数据
   * @return
   */
  public Memento retriveMemento() {
    return memento;
  }


}
