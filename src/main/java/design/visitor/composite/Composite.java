package design.visitor.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiCola
 * @date 2018/8/27
 */
public class Composite extends Component {

  private List<Component> childComponents=new ArrayList<>();
  private String name;

  public Composite(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitComposite(this);
    for (Component childComponent : childComponents) {
      childComponent.accept(visitor);
    }
  }

  @Override
  public void addChild(Component child) {
    childComponents.add(child);
  }

  @Override
  public void removeChild(Component child) {
    childComponents.remove(child);
  }

  @Override
  public Component getChild(int index) {
    return childComponents.get(index);
  }
}
