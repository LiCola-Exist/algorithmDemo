package sort;

/**
 * Created by LiCola on 2018/3/2.
 */
public abstract class Example {
    public abstract void sort(Comparable[] a);

    public boolean less(Comparable v,Comparable w){
      return v.compareTo(w)<0;
    }

    public void exch(Comparable[] a,int i,int j){
      Comparable temp=a[i];
      a[i]=a[j];
      a[j]=temp;
    }

    public void show(Comparable[] a){
      for(int i=0;i<a.length;i++){
        System.out.print(a[i]+" ");
      }
      System.out.println("");
      System.out.println("输出结束----");
    }

    public boolean isSorted(Comparable[] a){
      for(int i=1;i<a.length;i++){
        if (less(a[i],a[i-1])){
          return false;
        }
      }
      return true;
    }


}
