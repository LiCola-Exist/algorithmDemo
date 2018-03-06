package DesignPattern.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiCola on 2017/7/8.
 */
public class ObjectStructure {

  private List<Element> elements = new ArrayList<>();

  public void handleRequest(Visitor visitor) {
    for (Element element :
        elements) {
      element.accept(visitor);
    }
  }

  public void addElement(Element element) {
    elements.add(element);
  }
}
