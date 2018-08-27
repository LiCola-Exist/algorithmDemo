package design.visitor.base;

/**
 * Created by LiCola on 2017/7/8.
 */
public class VisitorClient {

  public static void main(String[] args) {
    ObjectStructure objectStructure = new ObjectStructure();

    //创建要加入对象结构的元素
    Element elementA = new ConcreteElementA();
    Element elementB = new ConcreteElementB();

    //把元素加入对象结构
    objectStructure.addElement(elementA);
    objectStructure.addElement(elementB);

    Visitor visitor = new ConcreteVisitor();
    objectStructure.handleRequest(visitor);
    objectStructure.handleRequest(new Visitor() {
      @Override
      public void visitConcreteElementA(ConcreteElementA elementA) {

      }

      @Override
      public void visitConcreteElementB(ConcreteElementB elementB) {

      }
    });
  }

}
