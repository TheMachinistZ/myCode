public class SortArray {
    //<T extends ComparableInterface<? extends T>>
    // 表示实现了ComparableInterface接口的类及其子类们
    public static <T extends ComparableInterface<? super T>> void selectionSort(T[] a,int n){
        //第一版实现
                 for (int i=0;i<a.length-1;i++){
              int indexOfNextSmallest=getIndexOfNextSmallest(a,i,a.length-1);
              swap(i,indexOfNextSmallest,a);
             }


    }
    //第二版实现 recursive
    //迭代换递归
    public static <T extends ComparableInterface< ? super   T>> void selectionSortByRecursive(T[] a,int first,int last){
        if (first == last){
           //基本情况。基本情况是什么都不做，因为在本算法中当first=last的时候，前面的所有元素已经有序，换句话说，也就是
            //当除了自己之外的所有元素有序，那说明自己也在合适的位置上，至少在选择排序中是如此
        }else {
           int indexOfNextNextSmallest=getIndexOfNextSmallest(a,first,last);
           swap(first,indexOfNextNextSmallest,a);
           selectionSortByRecursive(a,first+1,last);
        }
    }
    private static void swap(int i,int j,Object[] a) {
        Object temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private static <T extends ComparableInterface<? super  T>> int getIndexOfNextSmallest(T[] a , int first,int last) {
          int indexOfNextSmallest=first;
          T min=a[first];
          for (int i=first+1;i<a.length;i++){
             if (a[i].compareTo(min) < 0){
                 min=a[i];
                 indexOfNextSmallest =i;
             }
          }
           return  indexOfNextSmallest;
    }
    private  static <T extends ComparableInterface<? super  T>> void insertionSort(T[] a,int first,int last){
         for (int i =first+1;i<=last;i++){
             T unsortedEntry=a[i];
             insertInOrder(a,first,i-1,unsortedEntry);
         }
    }

    public static<T extends  ComparableInterface<? super  T>> void insertInOrder(T[] a,int first,int last,T unsorted) {
        //第一版实现（未仔细检查）
        //        int location=last;
//        while (location >=first && a[location].compareTo(unsorted) >0){
//            location--;
//         }
//         if (location >=first){
//             for (int i=last;i>=location;i--){
//                   a[i+1]=a[i];
//             }
//             a[location]=unsorted;
//         }
        //第二版实现（未仔细检查）
//       int location=last;
//       boolean found=true;
//       while (location >=first && found){
//           if ( a[location].compareTo(unsorted) <0){
//               found=false;
//               for (int i= last;i>=location;i--){
//                  a[i+1]=a[i];
//               }
//               a[location]=unsorted;
//           }else {
//               location--;
//           }
//       }
        //第三版实现 课本实现
        int location=last;
        while (location >=first && a[location].compareTo(unsorted) >0){
             //开销均摊
            a[location+1]=a[location];
            location--;
        }
        //注意这里的下标是location+1而非location。因为循环总有越位性，这是为了破坏循环继续条件而产生的，一定要注意这个细节
        a[location+1] =unsorted;
    }
    //递归实现 选择排序
     public  static <T extends ComparableInterface<? super T>> void insertionSortByRecursive(T[] a,int first,int last){
        if (first <last){
            insertionSortByRecursive(a,first,last-1);
            insertInOrder(a,first,last-1,a[last]);
        }
     }
     //声明一个native函数，native为java关键字，表示它将由JNI层完成
     private  native void jniFunction();
     //
    public  static  <T extends  ComparableInterface<? super T>> void insertionSortByRecursive2(T[] a,int first,int last){
        if (first < last){
            //逐渐生成有序序列
            insertionSortByRecursive2(a,first,last-1);//从这条递归语句中返回时，前一部分已经排好序
            //扩充这个有序序列
          insertInOrderByRecursive(a[last],a,first,last-1);
        }
    }
    public static <T extends  ComparableInterface<? super T>> void insertInOrderByRecursive(T anEntry,T[] a,int first,int last){
        if (a[last].compareTo(anEntry)<0)//这条布尔语句决定了算法工作结果是升序还是降序,当前在括号中的决定了是升序
        {
            //停下来发生交换
            a[last+1]=anEntry;

        } else if (first < last){
            //继续移位并向前移动
            a[last+1]=a[last];
            insertInOrderByRecursive(anEntry,a,first,last-1);//只有当剩余项数大于1的时候才会正常工作
            }
            else
            {
             a[last+1]=a[last];
             a[last]=anEntry;
           }
    }
    //希尔排序 减小增量排序
    //希尔排序内部实现细节
    private <R extends ComparableInterface<? super R>> void increamtalInsertionSort(R[] a,int first,int last,int space){
//         int unsortedEntryIndex =  first+space;
//         int index=unsortedEntryIndex-1;
//         for (index = ){
//
//         }
        for (int unsortedEntryIndex =first+space;unsortedEntryIndex<=last;unsortedEntryIndex+=space){
            R unsorted = a[unsortedEntryIndex];
            int index=unsortedEntryIndex-space;
            while (unsortedEntryIndex >=first && unsorted.compareTo(a[index])<0){//可以说插入排序内含一个冒泡
                 a[index+space]=a[space];
                 index=index-space;
            }
            a[index+space]=unsorted;
        }
    }
   //希尔排序主要函数
    private <Z extends ComparableInterface<Z>> void  shellSort(Z[] a){
        int space=a.length/2;
        while (space >0){
            for (int first=0;first<first+space-1;first++){//子序列们
                increamtalInsertionSort(a,first,a.length-1,space);
            }
            space=space/2;
        }
    }
    //希尔排序算法复习
   //希尔间隔因子排序
    private <T extends ComparableInterface< ? super  T>> void increatmentalInsortionSort1(T[] a,int first,int last,int space){
        for (int unsorted=first+space;unsorted <= last;unsorted+=space){
            T nextToInSort =a[unsorted];
            int position = unsorted-space;
            while (position >= first && nextToInSort.compareTo(a[position])<0){
                a[position+space]=a[position];
                position-=space;
            }
            a[position+space]=nextToInSort;
        }
    }
    //希尔排序
   public <B extends ComparableInterface<? super  B>> void shellSort1(B[] a){
        for (int space=a.length /2;space >0;space=space/2){
            for (int first=0;first<=first+space-1;first++){
               increatmentalInsortionSort1(a,first,a.length-1,space);
            }
        }
   }
   //选择排序复习
    public  <C extends ComparableInterface<? super C >> void selectionSort1(C[] a){
       for (int index=0;index < a.length;index++){
           for (int i=index+1;i<a.length;i++){
               if (a[index].compareTo(a[i]) >0){
                   //交换位置
                   C temp=a[i];
                   a[i]=a[index];
                   a[index]=temp;
               }
           }

       }
    }
    //选择排序复习2
    public <T extends Comparable<? super T>> void selectionSort2(T[] a,int n){
        for (int index=0;index<n-1;index++){
            for (int i=index+1;i<n-1;i++){
                if (a[index].compareTo(a[i])>0){
                    //若不是最小的，就交换回未排序序列
                    T temp=a[index];
                    a[index]=a[i];
                    a[i]=temp;
                }
            }
        }
    }
    //插入排序复习
    public <T extends Comparable<? super T>> void insertionSort(T[] a){

    }

}


