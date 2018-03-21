package collection;

import collection.AgeSortBigNumber.AgeHashMap.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiCola on 2018/3/7.
 * 对公司2万人进行年龄排序
 */
public class AgeSortBigNumber {


  /**
   * 对一定年龄范围内的员工的年龄 进行排序 数据较大
   * 首先简答的一般的排序算法可以实现，但是根据分析，大数据量情况下，员工年龄重叠是大分部。
   * 可以使用哈希表，优化排序插入的时的插入，为O（1），在输出迭代时根据哈希表的数组从头到尾遍历得到有序，其中哈希表上存在大量的年龄重叠
   */
  public static List<Employee> sort(List<Employee> des) {
    List<Employee> result = new ArrayList<>(des.size());

    AgeHashMap<Employee> ageHashMap = new AgeHashMap<>();
    for (Employee employee : des) {
      ageHashMap.put(employee);
    }

    for (int i = 0; i < ageHashMap.getSlotSize(); i++) {
      Node<Employee> node = ageHashMap.get(i);

      while (node != null) {
        result.add(node.value);
        node = node.next;
      }
    }

    return result;
  }

  static class AgeHashMap<E extends Employee> {

    //确定年龄范围 一般来说 公司在职人员 年龄范围可以固定
    static final int MIN_AGE = 18;
    static final int MAX_AGE = 65;

    private Node[] hashMap;

    AgeHashMap() {
      this.hashMap = new Node[MAX_AGE - MIN_AGE];
    }

    void put(E e) {
      int index = index(e);

      Node<E> target = hashMap[index];
      if (target == null) {
        //空槽 直接插入
        hashMap[index] = new Node<>(e, null);
      } else {
        //非空槽 头插法 不用遍历链表 缺点：就会导致排序不稳定 后面插入的值在新值前面 输出时主键相同元素间的相对位置被调整
        hashMap[index] = new Node<>(e, target);
      }
    }

    /**
     * 返回哈希表的槽的个数 不是实际数据
     */
    int getSlotSize() {
      return hashMap.length;
    }

    Node<E> get(int index) {
      return hashMap[index];
    }

    static class Node<E> {

      E value;
      Node<E> next;

      Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
      }
    }

    /**
     * 根据员工年龄 计算索引
     */
    static int index(Employee employee) {
      return employee.age - MIN_AGE;
    }
  }


  public static class Employee {

    public int age;
    public String name;


    public Employee(int age, String name) {
      this.age = age;
      this.name = name;
    }


    @Override
    public String toString() {
      return "Employee{" +
          "age=" + age +
          ", name='" + name + '\'' +
          '}';
    }
  }
}
