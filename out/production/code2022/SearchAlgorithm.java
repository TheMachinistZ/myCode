public class SearchAlgorithm {
   public static void main(String[] args){
       System.out.println(""+1%2);
   }
    //泛型元素数组中的特定元素查找的迭代算法
    public static<T> boolean inArray(T[] array,T anEntry){
        boolean found =false;
        int index =0;
        while (!found && index < array.length){
            if (anEntry.equals(array[index])){
                found=true;
            }else {
                index++;
            }
        }
        return found;
    }
   //自测题1版本
    public static <T> int inArray1(T[] array,T anEntry){
        boolean found =false;
        int index =0;
        int result=-1;
        while (!found && index < array.length){
            if (anEntry.equals(array[index])){
                found=true;
                result =index;
            }else {
                index++;
            }
        }
        return result;
    }
    public static<T> boolean inList(ListInterface<T> list,T anEntry){
        boolean found =false;
        int position =1;
        while (!found && position < list.getLength()){
            if (anEntry.equals(list.getEntry(position))){
                found=true;
            }else {
                position++;
            }
        }
        return found;
    }
    public static<T> boolean  inArrayByRecursion(T[] array,T anEntry,int index){
        if (index >= array.length ){
            return false;
        }else if (array[index].equals(anEntry)){
            return true;
        }else {
            return inArrayByRecursion(array,anEntry,++index);
        }
    }
    //二分法
    public static  <T extends ComparableInterface<? extends T>> boolean binarySearch(T[] array,T anEntry,int first,int last){
       if (first > last){
           return  false;
       }else {
          int mid =first+(last-first)/2;
          if (anEntry.equals(array[mid])){
              return true;
          }else if (anEntry.compareTo(array[mid])>0){//决定是在升序数组还是降序数组中搜索
              return binarySearch(array,anEntry,mid+1,last);//在升序数组中搜索的语句
              //在降序数组中搜索的语句
              // return  binarySearch(anEntry,anEntry,first,mid-1);
          }else {
             return  binarySearch(array,anEntry,first,mid-1);
           //  return  binarySearch(array,anEntry,mid+1,last);

          }
       }
    }
    //2022/1/30 二分法复习
    public static <T extends  ComparableInterface<? extends T>> boolean binarySearch2(T[] array,T anEntry,int first,int last){
      if (first > last){
          return false;
      }  else {
          int mid =first+(last-first)/2;
          if (array[mid].equals(anEntry)){
              return true;
          }else if (array[mid].compareTo(anEntry) >0){//默认是在升序序列中搜索
              return  binarySearch2(array,anEntry,first,mid-1);
          }else {
              return  binarySearch2(array,anEntry,mid+1,last);
          }


      }
    }
    //在无序线性表链式实现基础之上的迭代搜索算法
    public static <T> boolean contain(MyLinkedList.Node firstNode, T anEntry){
       boolean found=false;
        MyLinkedList.Node currentNode = firstNode;
        while (!found && currentNode!=null){
            if (currentNode.equals(anEntry)){
                found=true;
            }else {
                currentNode=currentNode.getNext();
            }
        }
        return found;
    }
    //在无序线性表的链式实现基础之上的递归搜索算法
    public <T> boolean containByRecursion(MyLinkedList.Node currentNode,T anEntry){
        if (currentNode == null){
            return false;
        }else if (currentNode.equals(anEntry)){
           return true;
        }else {
            return containByRecursion(currentNode.getNext(),anEntry);
        }
    }
    //在有序线性表的链式实现基础之上的顺序搜索算法
    public <T extends  ComparableInterface<? extends T>> boolean contains(MyLinkedList.Node firstNode,T anEntry){
        MyLinkedList.Node currentNode =firstNode;

        while(currentNode!=null && anEntry.compareTo(currentNode.getData()) >0){
           currentNode =currentNode.getNext();
        }
        //判断是哪个循环条件被破坏，从而返回正确的结果
        if (anEntry.compareTo(currentNode.getData())==0){
            return  true;
        }else {
            return false;
        }
        if (currentNode!=null){
            return  false;
        }
    }

}
