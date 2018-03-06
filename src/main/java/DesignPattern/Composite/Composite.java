package DesignPattern.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiCola on 2017/8/4. 组合对象，通常需要存储子对象，实现操作子对象的方法
 */
public class Composite extends Component {

  private List<Component> childComponent = null;

  public Composite(String name) {
    super(name);
  }

  @Override
  public void someOperation() {
    System.out.println(name + " 组合对象遍历子对象");
    if (childComponent == null) {
      return;
    }
    /**
     * 组合操作方法 没有实际功能 只是遍历调用子对象
     */
    for (Component composite : childComponent) {
      composite.someOperation();
    }
  }

  @Override
  public int size() {
    if (childComponent == null) {
      return 0;
    }

    return childComponent.size();
  }

  @Override
  public void addChild(Component child) {
    if (childComponent == null) {
      childComponent = new ArrayList<>();
    }
    childComponent.add(child);

    child.setParent(this);//添加对父组件的依赖
  }

  @Override
  public void removeChild(Component child) {
    if (childComponent == null) {
      return;
    }

    int index = childComponent.indexOf(child);
    if (index>-1){
      for (Component component : child.getChild()) {
        component.setParent(this);//删除的组件对象是本实例的一个子组件对象
        childComponent.add(child);//把被删除的对象的子组件对象 添加到当前实例中
      }
    }

    childComponent.remove(child);
  }

  @Override
  public List<Component> getChild() {
    return childComponent;
  }

  @Override
  public Component getChild(int index) {
    if (childComponent == null) {
      return null;
    }
    if (childComponent.size() > index && index >= 0) {
      return childComponent.get(index);
    }

    return null;

  }
}
