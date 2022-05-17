import com.sun.org.apache.xerces.internal.xs.ItemPSVI;
import sun.text.normalizer.CharacterIteratorWrapper;

public class SortBiggerArray {
    public <T extends Comparable<? super T>> void mergeSort(T[] a,T[] tempArray,int first,int last){

           if (first <last){
               //数组项数不为1时的情况
               int mid =(first+last)/2;
               mergeSort(a,tempArray,first,mid);
               //至此生成第一个有序数组
               mergeSort(a,tempArray,mid+1,last);
               //至此生成第二个有序数组
               //合并有序的两半

           }else {
            //不处理数组项数为1甚至少于1的情况
           }




    }
   private <T extends Comparable<? super T>>void merge(T[] a,T[] tempArray,int first,int mid,int last){
        int beginHalf1=first;
        int endHalf1=mid;
        int beginHalf2=mid+1;
        int endHalf2=last;
        int index=0;
        while ((beginHalf1 < endHalf1) && ( beginHalf2< endHalf2)){
            if (lessThan(a[beginHalf1],a[beginHalf2])){
                tempArray[index]=a[beginHalf1];
                beginHalf1++;
            }else {
                tempArray[index]=a[beginHalf2];
                beginHalf2++;
            }
            index++;
        }
       //将其中一个有剩余的子数组的剩余项添加到临时数组后面
        //将临时数组的内容复制回原数组

   }
   private   <T extends Comparable<? super T>> boolean lessThan(T a,T b){
        return a.compareTo(b)<0;//a小于b与这个等式的值保持一致，所以直接返这个式子的值就行
   }
   //归并算法复习mergeSort()
    private  void mergeSort(int[] a,int[] temArray,int first,int last){
          if (first > last){
              int mid =(first+last)/2;
              //生成第一个有序序列
              mergeSort(a,temArray,first,mid);
              //生成第二个有序序列
              mergeSort(a,temArray,mid+1,last);
              //合并归并
              int beginHalf1=first;
              int endHalf1=mid;
              int beginHalf2=mid+1;
              int endHalf2=last;
              int indexForTempArray=0;
              while ((beginHalf1 < endHalf1) && (beginHalf2 <endHalf2)){
                  if (a[beginHalf1] <a[beginHalf2]){//这个布尔表达式决定了排出来的顺序是升序还是降序
                      temArray[indexForTempArray]=a[beginHalf1];
                      beginHalf1++;
                  }else {
                      temArray[indexForTempArray]=a[beginHalf2];
                      beginHalf2++;
                  }
                  indexForTempArray++;
              }
              //将还有剩余的数组的中的剩余项并入到临时数组中
              //复制临时数组到原数组
          }else {

          }
    }
    //归并算法复习mergeSort
    private  void mergeSort2(int[] a,int[] tempArrary,int first,int last){
        if(first < last){
            //把数组分成左右两半，排序每一半
            int mid =(first + last )/2;
            //排序左边
            mergeSort2(a,tempArrary,first,mid);
            //排序右边
            mergeSort2(a,tempArrary,mid,last);
            //有序的左半部分与有序的右半部分依然存储在原数组中
            //章节 更快的合并算法 自测题2 规避不必要的合并
            if (a[mid] > a[mid+1]){
                //合并工作
                //临时数组其实可以取消，可以直接在原数组上进行覆盖
                int beginHalf1=first;
                int endHalf1=mid;
                int beginHalf2=mid+1;
                int endHalf2=last;
                int index=0;
                while ((beginHalf1 < endHalf1) && (beginHalf2<endHalf2)){
                    if (a[beginHalf1] < a[beginHalf2]){//这个布尔表达式控制着排出来的序列是升序还是降序，目前谁小谁进，控制有序序列为升序
                        tempArrary[index] = a[beginHalf1];
                        beginHalf1++;
                    }else {
                        tempArrary[index]=a[beginHalf2];
                        beginHalf2++;
                    }
                    index++;
                }
                //将还有项剩余的数组的剩余项数追加进tempArray
                //将tempArray复制回原数组
            }

        }else {
           //项数只剩下一项什么都不做，只剩下一项可以用多种方式表示

        }

    }
    //章节 更快的排序 9.1.4 项目2 迭代版本的归并排序
    private  void mergeSortByInteration(int[] a,int[] tempArray){
        //一个小练习罢了 可以直接忽略
        //        int[] a=new int[]{2,3};
//        for(int c:a){//用一个临时声明的变量来遍历数组
//
//        }
        int n=1;
        while (n != a.length){
               for (int i=0;i<a.length;i=i+n+2){
                   int mid =n/2;
                   int beginHalf1=i;
                   int endHalf1=i+mid;
                   int beginHalf2=i+mid+1;
                   int endHalf2=i+n+1;
                   int index=beginHalf1;
                   while ( beginHalf1 < endHalf1 && beginHalf2 < endHalf2){
                       if (a[beginHalf1] < a[beginHalf2]){
                           tempArray[index] = a[beginHalf1];
                           beginHalf1++;
                       }else {
                           tempArray[index] =a[beginHalf2];
                           beginHalf2++;
                       }
                       index++;
                   }
                   n=n*2;
               }
        }
    }
    private void  quickSort(int[] a ,int first,int last){
          if (first < last){
             //确定枢轴
              //根据枢轴的位置划分数组
              //整理较小侧数组
              int pivotIndex =0;
              quickSort(a,first,pivotIndex-1);
              //整理较大侧数组
              quickSort(a,pivotIndex+1,last);
          }else {

          }
    }
    //快速排序 复习
    private  void quickSort2(int[] a,int first,int last){
        if (first <last){

            //确定枢轴
            //根据枢轴创造划分，也就是一小一大两块区域，并被枢轴隔开
            //以枢轴为界,整理两边数组
            int pivotIndex=0;
            quickSort2(a,first,pivotIndex);
            quickSort2(a,pivotIndex,last);
        }else {

        }
    }
    //快速排序划分算法 伪代码
    public void  quickSort3(int[] a ,int first,int last){
        if (first < last){
            //根据数组的现有情况创建划分——即a，first，last
           int pivotIndex=  partition(a,first,last);
            quickSort3(a,first,pivotIndex);
            quickSort3(a,pivotIndex+1,last);
        }else {

        }
    }
    private int partition(int[] a,int first,int last){
       //保险措施：使用三元枢轴法避免最坏情况下的枢轴选择
       int mid =first+(last-first)/2;//多亏了数学的演绎规则，我们才幸得知许多逻辑实际上是等价的，mid=first+last/2
       sortStartMiddleEnd(a,first,mid,last);
       int temp=a[mid];//实际是有个小问题的，当项数少于三项这个算法将不能正常工作
       a[mid]=a[last-1];
       a[last-1]=temp;
       int pivotIndex=last-1;
       int pivotValue=a[pivotIndex];
       int indexFromLeft=first+1;
       int indexFromRight=last-2;
       boolean done=false;
       while (!done){
           //寻找大于枢轴的第一项
           while (a[indexFromLeft] <= pivotValue)
                 indexFromLeft++;
           while (a[indexFromRight] >= pivotValue)
                 indexFromRight--;
           if (indexFromLeft < indexFromRight){
                 int temp1=a[indexFromLeft];
                 a[indexFromLeft]=a[indexFromRight];
                 a[indexFromRight]=temp1;
           }else {
               a[pivotIndex]=a[indexFromLeft];
               a[indexFromLeft]=pivotValue;
               pivotIndex=indexFromLeft;
                done=true;
           }
       }
       return pivotIndex;
    }
    private void sortStartMiddleEnd(int[] a,int first,int middle,int last){
      int A=0;
      int B=0;
      int C=0;
      if (a[first] < a[middle]){
          A--;
          B++;
      }else {
          A++;
          B--;
      }
      if (a[first]<a[last]){
          A--;
          C++;
      }else {
          A++;
          C--;
      }
      if (a[middle]<a[last]){
          B--;
          C++;
      }else {
          B++;
          C--;
      }
      int[] b={A,B,C};
      int[] c={a[first],a[middle],a[last]};
      int temp;
      for (int i =0;i<3;i++){
          switch (b[i]){
              case 2://此数为最大
                  temp=a[last];
                  a[last]=c[i];
                  c[i]=temp;
                  break;
              case -2:
                  temp=a[first];
                  a[first]=c[i];
                  c[i]=temp;
                  break;
              case 0:
                  temp=a[middle];
                  a[middle]=c[i];
                  c[i]=temp;

          }

      }


    }
    //快速排序复习  11.15
    public void quickSort4(int[]a,int first,int last){
        if (first <last){
            int mid=partition4(a,first,last);
            quickSort4(a,first,mid-1);
            quickSort4(a,mid+1,last);
        }else {


        }
    }

    private int partition4(int[] a, int first, int last) {
        //使用三元枢轴法避免最坏情况：有序
        int mid=(first+last)/2;
        sortStartMiddleEnd(a,first,mid,last);
        int pivotValue=a[mid];
        int pivotIndex=last-1;
        a[mid]=a[last-1];
        a[last-1]=pivotValue;
        int indexFromLeft=first+1;
        int indexFromRight=last-2;
        boolean done=false;
        while (!done){
            while (a[indexFromLeft] < pivotValue){
                indexFromLeft++;
            }
            while (a[indexFromRight] > pivotValue)
                indexFromRight--;
            if (indexFromLeft <indexFromRight){
                int temp = a[indexFromLeft];
                a[indexFromLeft] =a[indexFromRight];
                a[indexFromRight]= temp;
            }else {
               pivotIndex =indexFromLeft;
               a[last-2]=a[indexFromLeft];
               a[indexFromLeft]=pivotValue;
               done=true;
            }
        }
        return pivotIndex;
    }
    //改进型 规避小数组的快速排序
    public  void quickSortx(int[] a,int first,int last,int minSize){
        if (last -first+1 < minSize){
            insertionSort(a,first,last);
        }else {
            int pivoutIndex=partition4(a,first,last);
            quickSortx(a,first,pivoutIndex-1,minSize);
            quickSortx(a,pivoutIndex+1,last,minSize);
        }
    }

    private static void insertionSort(int[] a, int first, int last) {
    }
    public void radixSort(int[] a,int first,int last,int maxDigit){
        //LSD
        for (int i=0;i<maxDigit-1;i++){
            int[][] bucket=new int[maxDigit-1][a.length];//主序代表有多少种桶（比如十位数就有0到9总共10种桶），后面一个分量代表每种有多少
            int counter=0;
            for (int j=first;j<last;i++){
                int digitOfItem=getDigit(a[j]);
                //将a[index]插入对应的bucket[digit]种类里,所对应的种类的计数器加一
                 //入桶
                bucket[digitOfItem][counter++]=a[j];
            }

        }
        //依次复制bukcet到原数组
    }

    private int getDigit(int a) {
        return  0;
    }
    //桶排序复习 11.21
    public void radixSrot2(int[] a,int first,int last,int maxDigits){//写成first和last将会更加通用，毕竟全部是某一部分的特殊情况
        int[][] bucket=new int[maxDigits][a.length];//0到maxDigits-1
        for(int i=0;i<maxDigits;i++){
            for (int j=0;j<a.length;j++){
                bucket[i][j]=-1;
            }
        }
        for (int i=0;i<maxDigits;i++){
           for (int j=first;j<=last;j++){//保持心情愉悦的学习 //遍历每个元素给他们寻找正确的位置
               //错误代码
               //               int counter=0;
//               if ((getDigit(a[j])-1)==i){
//                   //这个桶中的数就增加
//                   bucket[i][counter]=a[j];
//                   counter++;
//                }
               bucket[getNumberOfDigit2(a[j],i)][j]=a[j];//不必每次进桶的时候都从0开始，,可以每级都错开，只要最后拼接在一起保持一个顺序就可以，何况j是当数组长度为a.length时永远合法的的下标，所以用在这里毫无并无问题
           }
           //因为下一次的排序要在上次的排序的基础上进行，复制回原数组，或者直接在bucket矩阵的基础上进行
           for (int c=0;c<maxDigits;c++){
              for (int k=0;k<a.length;k++){
                  if (bucket[c][k]!=-1){
                      a[k]=bucket[c][k];
                  }
              }
           }
        }

    }
    private int getNumberOfDigit(int a,int digit){//个位从0开始
        int number=a/((int)Math.pow(10,digit));
        if ( number >=10 ){
            return 0;
        }else {
            return number;
        }
    }
    //取个位数字稳定版本
    public  static int getNumberOfDigit2(int a,int digit){
        int mod=10;
        int number;
        if (digit == 0){
             number=a %(int) Math.pow(mod,digit+1);
        }else {
             number=a %(int) Math.pow(mod,digit+1);
            number=number /(int)Math.pow(mod,digit);
        }


        return number;
    }
}
