package design.visitor.composite;

import com.licola.llogger.LLogger;

/**
 * @author LiCola
 * @date 2018/8/27
 */
public class Client {

  public static final void main(String[] args) {
    Component root = new Composite("根节点");

    root.addChild(new Leaf("叶子-左"));
    Component childRight = new Composite("子树-右");
    childRight.addChild(new Leaf("唯一叶子"));
    root.addChild(childRight);

    root.accept(new Visitor() {
      @Override
      public void visitComposite(Composite composite) {
        LLogger.d(composite.getName());

      }

      @Override
      public void visitLeaf(Leaf leaf) {
        LLogger.d(leaf.getName());
      }
    });


  }
}
