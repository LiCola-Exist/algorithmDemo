package design.visitor.composite;

/**
 * @author LiCola
 * @date 2018/8/27
 */
public class ObjectStructure {

  private Component root;

  public ObjectStructure(Component root) {
    this.root = root;
  }

  public void handleRequest(Visitor visitor) {
    if (root != null) {
      root.accept(visitor);
    }
  }

}
