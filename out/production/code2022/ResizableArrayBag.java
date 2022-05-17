

import java.util.Arrays;

class TestEntry{

    public static void main(String[] args){
        {
            ResizableArrayBag resizableArrayBag= new ResizableArrayBag(3);
            resizableArrayBag.add(1);
            System.out.println(resizableArrayBag.getLength()+"\n");
            resizableArrayBag.add(1);
            System.out.println(resizableArrayBag.getLength()+"\n");
            resizableArrayBag.add(1);
            System.out.println(resizableArrayBag.getLength()+"\n");
            resizableArrayBag.add(1);
            System.out.println(resizableArrayBag.getLength()+"\n");
            //数据破坏实验 自测题21
            int[] a = new int[]{1,2,3,4,5,6,7,8};
            abc[] c=new abc[]{new abc(),new abc()};

            ResizableArrayBag resizableArrayBag1 = new ResizableArrayBag(c);//为何参数是泛型的函数参数不能是基本数据类型数组
            for (int i=0;i<c.length;i++){
                System.out.println(""+c[i]);
            }
            c[1]=null;//破坏数据
            Object[] d =  resizableArrayBag1.toArray();
            System.out.println(d.length);
           for (int i=0;i<c.length;i++){
               System.out.println(resizableArrayBag1.toArray()[i]);
           }

        }
    }
}
public class ResizableArrayBag <T> implements MyBagInterface<T>{//这是我设计的第一个java包
    private   T[] bag;
    private  int numberOfEntries;
    private static final int DEFAULT_CAPACITY=25;
    private  static  final int MAX_CAPACITY =1000    ;
    private boolean initialized =false;



    public int getLength(){
        return  bag.length;
    }


    public ResizableArrayBag(T[] contents){
//          checkCapacity(contents.length);
//          bag= Arrays.copyOf(bag,contents.length);
//          numberOfEntries = contents.length;//如果参数满包的话 那这句话就是对的，否则只是再将容量赋给
//          initialized=true;
          //自测题 21 可能引起数据被破坏的一种构造方法
        initialized=true;
        numberOfEntries=contents.length;
        bag=contents;//这只是使得几个引用指向了同一个内存区域，意味着只要持有这块内存引用的对象和个体就有可能修改这块内存的数据
    }
    public ResizableArrayBag(int desiredCapacity) {

        if (desiredCapacity <= MAX_CAPACITY){
            @SuppressWarnings("unchecked")//抑制编译器警告
                    T [] temBag=(T[])new Object[desiredCapacity];
            bag=temBag;
            numberOfEntries=0;
            initialized =true;//代表这次初始化的对象不是畸形对象
        }else throw  new IllegalStateException(
                "Attempt to create a bag whose capacity exceeds allowed maximum"
        );
    }
    public ResizableArrayBag(){ //这个实际上是方法 public ResizableArrayBag(int desiredCapacity)的特殊情况
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
        //第一版实现
        //        if (initialized){ //检测畸形对象的意义在于所有的工作都应建立在正确的基础上进行
//
//            boolean result =false;
//            if (isArrayFull()){
//                return result;
//            }else {
//                bag[numberOfEntries] = newEntry;
//                numberOfEntries++;
//                result =true;
//            }
//            return result;
//
//        }else  throw new IllegalStateException("ArrayBag object is not initialized properly");
      // 第二版实现
        checkInitialization();
        boolean result= true;
        if (isArrayFull()){
           doubleCapacity();
        }else {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return  result;
    }
    private  void doubleCapacity(){
        int newLength =bag.length * 2;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag,newLength);


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
    private void checkCapacity(int capacity){
         if (capacity > MAX_CAPACITY)
             throw new IllegalStateException("Attempt to create a bag whose capacity exeeds allowed Capacity");
    }
}