package DesignPattern.Memento;

/**
 * Created by LiCola on 2017/7/4.
 * 备忘录使用示例
 */
public class MementoClient {


  public static void main(String[] args) {
    Originator originator = new Originator();
    originator.doSomething();//使用对象 做了一些操作

    Caretaker caretaker = new Caretaker();
    caretaker.saveMemento(originator.createMemento());//保存原发器某个瞬间状态

    //假设被置空 回收了
    originator = null;

    Originator originatorRebuild = new Originator();//创建新的对象

    originatorRebuild.setMemento(caretaker.retriveMemento());//从管理器中恢复保存状态

    System.out.println(originatorRebuild.toString());//输出 "Originator{status='run'}"表示成功恢复内部状态

  }
}
