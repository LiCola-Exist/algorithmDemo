package DesignPattern.Composite;

/**
 * Created by LiCola on 2017/8/4.
 */
public class CompositeClient {
  public static final void main(String[] args){
    Component root=new Composite("root");

    Component component1=new Composite("component1");
    Component component2=new Composite("component2");
    Component component3=new Composite("component3");

    Component leaf1=new Leaf("leaf1");
    Component leaf2=new Leaf("leaf2");
    Component leaf3=new Leaf("leaf3");
    Component leaf4=new Leaf("leaf4");

    component2.addChild(leaf2);
    component3.addChild(leaf3);
    component3.addChild(leaf4);

    root.addChild(component1);
    root.addChild(leaf1);
    root.addChild(component2);
    root.addChild(component3);

    for (int i = 0; i < root.size(); i++) {
      root.getChild(i).someOperation();
    }

  }
}
