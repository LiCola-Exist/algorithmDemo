package design.visitor.composite;

/**
 * @author LiCola
 * @date 2018/8/27
 */
public class Leaf extends Component  {

  private String name;

  public Leaf(String name) {
    this.name = name;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitLeaf(this);
  }

  public String getName() {
    return name;
  }
}
