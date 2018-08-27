package design.visitor.composite;

/**
 * @author LiCola
 * @date 2018/8/27
 */
public interface Visitor {

  void visitComposite(Composite composite);

  void visitLeaf(Leaf leaf);
}
