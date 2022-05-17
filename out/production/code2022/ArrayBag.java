import java.util.*;
interface  MyBagInterface <T>{//像使用饮料机一样使用ADT（设计）
   /**  这是一个注释 */
    public int getCurrent();
    public boolean isEmpty();
    public boolean add(T newEntry);
    public T remove();
    public boolean   remove(T entry);//remove one occurence of given entry from this bag
    public void clear();
    public int getFrequencyOf(T anEntry);//Counts the number of times a given entry appears in this bag
    public boolean conrtains(T anEntry);
    public T[] toArray();//
    public boolean isArrayFull();
}
class testEntry{//测试入口类
    public static  void main(String[] args){
       ArrayBag<String> aBag = new ArrayBag<>();//声明一个引用
       String [] contentOfString1 =new String[]{"A1","A2","A3","A4","A5","A6"};
       testAdd(aBag,contentOfString1);
       System.out.println(""+aBag.conrtains("A2"));
      // aBag =new ArrayBag<>(2);
    //   display(aBag);
      ArrayBag<String> bBag= new ArrayBag<>(2);
       String [] contentOfString2 =new String[]{"A1","A2","A3","A4","A5","A6","A7","A8","A9","A10","A11","A12"};
       testAdd(bBag,contentOfString2);
     //自测题18
        String[] text ={"cat","dog","bird","snake"};
        text = Arrays.copyOf(text,text.length+5);
        //1，用一个复制引用来同时指向原先的数组
        //2,用指定大小创建一个新数组，并将引用赋给原先数组的引用
        //3，通过复制引用来访问旧数组，来进行复制工作。
        //4，释放复制引用
    }
   private  static  void testAdd(ArrayBag<String> aBag,String[] input){

       for ( int index=0;index<input.length;index++){
           //有可能中断循环
           if (aBag.add(input[index])){

           }else {
               System.out.println("unable to add elem"+index);

           }

       }

       display(aBag);
   }
   private  static  void  display(ArrayBag<String> aBag){
         //迭代地定义
         Object[] bag= aBag.toArray();
         System.out.println(""+bag.length);
         for (int index=0;index<bag.length;index++){
             System.out.println(""+bag[index]);
         }

   }



}

public class ArrayBag <T> implements MyBagInterface<T>{//这是我设计的第一个java包
    private   T[] bag;
    private  int numberOfEntries;
   private static final int DEFAULT_CAPACITY=25;
   private  static  final int MAX_CAPACITY =1000    ;
   private boolean initialized =false;
   public ArrayBag(int desiredCapacity) {

           if (desiredCapacity <= MAX_CAPACITY){
               @SuppressWarnings("unchecked")//抑制编译器警告
                       T [] temBag=(T[])new Object[desiredCapacity];
                       bag=temBag;
                       numberOfEntries=0;
                       initialized =true;//代表这次初始化的对象不是畸形对象
           }else throw  new IllegalStateException(
                   "Attempt to create a bag whose capacityexceeds allowed maximum"
           );
    }
   public ArrayBag(){ //这个实际上是方法 public ArrayBag(int desiredCapacity)的特殊情况
       this(DEFAULT_CAPACITY);
    }

    @Override
    public int getCurrent() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean add(T newEntry) {
        if (initialized){ //检测畸形对象的意义在于所有的工作都应建立在正确的基础上进行

            boolean result =false;
            if (isArrayFull()){
                return result;
            }else {
                bag[numberOfEntries] = newEntry;
                numberOfEntries++;
                result =true;
            }
            return result;

        }else  throw new IllegalStateException("ArrayBag object is not initialized properly");



    }

    @Override
    public T remove() {
       //第一种实现方式
       //       checkInitialization();
//       T result =null;
//       if (numberOfEntries >0){//代表当前结构还有元素剩余可以删除
//           result =bag[numberOfEntries-1];
//           bag[numberOfEntries-1]=null;
//           numberOfEntries--;
//
//       }
//       return result;
      //第二种实现方式
        checkInitialization();
      return removeEntry(numberOfEntries-1);

    }
    @Override
    public boolean remove(T entry) {
       checkInitialization();
       int index=getIndexOf(entry);
       T removedEntry= removeEntry(index);
        return removedEntry!=null;//代表检测removeEntry（）方法执行的结果是不是为空
       //或者为return entry.equals(removedEntry);//检测removeEntry(）方法的结果与entry是否相等，
        // 只有两种情况removeEntry(）方法结果为null
    }
    private int getIndexOf(T anEntry){
       boolean found=false;
       int where =-1;
       int index =0;
       while(!found && index < numberOfEntries){
           if (anEntry.equals(bag[index])){
               found=true;
               where=index;
           }
       index++;
       }
     //我的做法  assert index == numberOfEntries:index;//这里无论找得到找不到index都不会有index == numberOfEntries，所以这里必中断且返回index
      //课本做法 与我的思想类似，就是无论如何强制中断程序执行并返回一个值 用||就是成功或者失败都会触发断言
        assert  ((where >0) &&(where<numberOfEntries)) || (where <0);//一定要限制小于numberOfEntries，
        return where;
//      或是这种做法
//       if (found == false){
//           index =-1;
//       }
//     return index;
   }
    private T removeEntry(int givenIndex){
       checkInitialization();
       T result =null;
       if (numberOfEntries!=0 && givenIndex >0){
           result =bag[givenIndex];
           bag[givenIndex] =bag[numberOfEntries -1];
           bag[numberOfEntries-1]=null;
           numberOfEntries--;
       }
       return result;
    };
    @Override
    public void clear() {
       //实现方法一
        while (!isEmpty()){
                remove();
                }
//        //实现方法二 ：不调用isEmpty(） 自测题10
//        while (remove()!=null){
//
//        }
      //实现方式三 ：使用numberOfEntries =0 自测题11 有什么缺点？
//        while (numberOfEntries != 0){
//            remove();
//            numberOfEntries--;
//        }
    }

    @Override
    public boolean isArrayFull() {
        return this.numberOfEntries >= bag.length;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
       checkInitialization();
       int counter=0;
       for (int i=0;i<numberOfEntries;i++){//标准的遍历监测
           if (bag[i].equals(anEntry))
               counter++;
       }
       return counter;
    }

    @Override
    public boolean conrtains(T anEntry) {
       // 实现方式一，这个方法实际上是getFrequency的特殊情况
       //        checkInitialization();
      //        return getFrequencyOf(anEntry)!=0;
        // 缺陷 必须遍历
//      //实现方式二
//        boolean found =false;
//        int index =0;
//        while (!found && index<numberOfEntries){
//            if (bag[index].equals(anEntry)){
//                found=true;
//            }
//            index++;
//        }
//        return found;
//        //实现方式三
//       boolean found =false;
//       if (getIndexOf(anEntry)!= -1){
//                 found=true;
//       }
//       return found;
        //实现方式四
        checkInitialization();
        return getIndexOf(anEntry) >-1;
   }

    @Override
    public T[] toArray() {
       @SuppressWarnings("unchecked")//这里必须注释忽略编译器错误的原因
       T[] result =(T[])new Object[numberOfEntries]; //尽管代码是机器或者技术相关的，但是命名一定要尽可能地贴近业务和口语化
       for (int index=0;index<numberOfEntries;index++){
          result[index] = bag[index];
       }
        return result;
    }
    private  void checkInitialization(){
       if (!initialized)throw   new SecurityException("ArrayBag object is not initialized properly");
    }
    private  void display(){
        //递归的定义
        displayArray(0,numberOfEntries-1);
    }

    private void displayArray(int i, int numberOfEntries) {
        if (i == numberOfEntries){
            System.out.print(i+"\t");
        }else {
            displayArray(i,numberOfEntries-1);
            System.out.print(numberOfEntries+"\t");
        }
    }
    private void displayArray1(int first,int last){
         if (first == last){
            System.out.print(bag[first]);
         }else {
            int mid = (first + last)/2;
            displayArray1(first,mid);
            displayArray1(mid+1,last);
         }
    }
}

