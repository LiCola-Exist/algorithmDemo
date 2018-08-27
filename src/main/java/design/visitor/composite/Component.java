package design.visitor.composite;


/**
 * @author LiCola
 * @date 2018/8/27
 */
public abstract class Component {
  public abstract void accept(Visitor visitor);

  public void addChild(Component child){
    throw new UnsupportedOperationException("默认不支持该方法");
  }

  public void removeChild(Component child){
    throw new UnsupportedOperationException("默认不支持该方法");
  }
  public Component getChild(int index){
    throw new UnsupportedOperationException("默认不支持该方法");
  }
}
