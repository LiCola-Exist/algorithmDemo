package linked;

import com.licola.llogger.LLogger;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * Created by LiCola on 2017/10/18.
 * 继承LinkedHashMap实现最简单的LRU
 */
public class LinkedHashMapLRU<K, V> extends LinkedHashMap<K, V> {

  private int size;

  public LinkedHashMapLRU(int size) {
    super(16, 0.75f, true);
    this.size = size;
  }

  @Override
  protected boolean removeEldestEntry(Entry<K, V> eldest) {
    return size() > size;
  }

  public static final void main(String[] args){
    //构造 插入排序的map
    LinkedHashMap<String,Integer> mapInsertOrder=new LinkedHashMap<>();

    mapInsertOrder.put("c",100);
    mapInsertOrder.put("d",200);
    mapInsertOrder.put("a",500);
    mapInsertOrder.put("d",300);

    //键是按照"c", "d", "a"的顺序插入的，修改"d"的值不会修改顺序
    LLogger.d("插入有序： 输出结果根据插入时顺序 后面相同key的修改 不会影响排序 \n"+mapInsertOrder+"\n");

    LinkedHashMap<String,Integer> mapAccessOrder=new LinkedHashMap<>(16,0.75f,true);

    mapAccessOrder.put("c",100);
    mapAccessOrder.put("d",200);
    mapAccessOrder.put("a",500);
    mapAccessOrder.get("c");
    mapAccessOrder.put("d",300);

    LLogger.d("访问有序：输出结果根据对Map的键操作顺序 \n"+mapAccessOrder+"\n");

    //默认情况下 LinkedHashMap是没有容量限制的 如果在访问有序的Mao中实现容量限制 就是LRU

    LinkedHashMapLRU<String,String> lrcCache=new LinkedHashMapLRU<>(3);
    lrcCache.put("a","abstract");
    lrcCache.put("b","basic");
    lrcCache.put("c","call");
    lrcCache.get("a");
    lrcCache.put("d","call");

    LLogger.d("cache \n"+lrcCache+"\n");
  }

}
