package sort;

import com.licola.llogger.LLogger;

/**
 * Created by LiCola on 2018/3/2.
 */
public class Example {

    public static boolean less(Comparable v,Comparable w){
      return v.compareTo(w)<0;
    }

    public static void exch(Comparable[] a,int i,int j){
      Comparable temp=a[i];
      a[i]=a[j];
      a[j]=temp;
    }

    public static void show(Comparable[] a){
      for(int i=0;i<a.length;i++){
        System.out.print(a[i]+" ");
      }
      LLogger.d("");
      LLogger.d("输出结束----");
    }

    public static boolean isSorted(Comparable[] a){
      for(int i=1;i<a.length;i++){
        if (less(a[i],a[i-1])){
          return false;
        }
      }
      return true;
    }


}
