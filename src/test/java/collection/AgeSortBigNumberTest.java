package collection;

import collection.AgeSortBigNumber.Employee;
import com.licola.llogger.LLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * Created by LiCola on 2018/3/7.
 */
public class AgeSortBigNumberTest {

  @Test
  public void sort() {
    List<AgeSortBigNumber.Employee> employees = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      employees.add(new Employee(18 + (i % 10), "a" + i));
    }
    Collections.shuffle(employees);

    LLogger.d("乱序输入---");
    for (Employee item :
        employees) {
      LLogger.d(item);
    }

    LLogger.d("排序结果---");
    List<Employee> result = AgeSortBigNumber.sort(employees);
    for (Employee item :
        result) {
      LLogger.d(item);
    }

  }
}