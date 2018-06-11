package design.composite;

import java.util.List;

/**
 * Created by LiCola on 2017/8/4.
 * 抽象的组件对象，为组合中的对象声明统一的抽象方法，并提供缺省行为
 */
public abstract class Component {

  protected String name;

  /**
   * 记录父组件
   */
  protected Component parent=null;

  public Component(String name) {
    this.name = name;
  }

  public Component getParent() {
    return parent;
  }

  public void setParent(Component parent) {
    this.parent = parent;
  }

  public List<Component> getChild(){
    throw new UnsupportedOperationException("抽象对象不支持该方法");
  }

  /**
   * 示意方法 子组件对象可能有得操作方法
   */
  public abstract void someOperation();

  public int size(){
    throw new UnsupportedOperationException("抽象对象不支持该方法");
  }

  public void addChild(Component child){
    throw new UnsupportedOperationException("抽象对象不支持该方法");
  }

  public void removeChild(Component child){
    throw new UnsupportedOperationException("抽象对象不支持该方法");
  }

  public Component getChild(int index){
    throw new UnsupportedOperationException("抽象对象不支持该方法");
  }
}
