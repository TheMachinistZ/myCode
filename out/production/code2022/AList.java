import java.lang.reflect.Array;
import java.util.Arrays;

public class AList <T>implements ListInterface<T> {
    //模仿java标准库中ArrayList，用数组实现线性表
    //声明数据域
    private T[] list;
    private int numberOfEntries;
    private boolean initialized=false;//这个为这个类所有实例一开始的默认值
    private static  final  int DEFAULT_CAPCITY=25;
    private static  final int MAX_CAPACITY=1000;
    //声明构造方法
    public AList(){
        this(DEFAULT_CAPCITY);
    }
    public AList(int desiredCapacity){
        //首先应检查输入值容量是否合法
        if (desiredCapacity<DEFAULT_CAPCITY){//是不是太小了
           desiredCapacity=DEFAULT_CAPCITY;
        }else {//是不是太大了
            //checkCapacity(desiredCapacity);

        }
        @SuppressWarnings("unchecked")
        T[] tempList =(T[]) new Object[desiredCapacity];
        list=tempList;
        numberOfEntries=0;
        initialized=true;
    }
    private void checkCapacity(int capacity) throws Exception{
        if (capacity > MAX_CAPACITY){
           throw new Exception("capacity is too big");
        }
    }
    @Override
    public void add(T newEnty) {

    }

    @Override
    public void add(int newPosition, T newEntry) {
        if ((newPosition>=1) && (newPosition > list.length+1)){//合法位置的情况
            if (newPosition <= numberOfEntries-1){
                makeRoom(newPosition);//挪位置
            }
            list[newPosition]=newEntry;
            numberOfEntries++;
            ensureCapacity();//ensure enough space for next add
        }else {//不合法位置的情况
//            throw  new Exception("position is illegal");
        }
    }

    private void makeRoom(int newPosition) {
        int firstIndex=newPosition;
        int lastIndex=numberOfEntries-1;
        for (int i=lastIndex;firstIndex<=i;i--){
           list[i+1]=list[i];
        }
    }
    //12.9练习
//    public void add1(T newEntry,int position){
//        if ((position >=1) && (position <=numberOfEntries+1)){
//            if (position <-1 numberOfEntries-1){
//                makeRoom(position);
//            }
//            list[position]=newEntry;
//            numberOfEntries++;
//            ensureCapacity();
//        }else {
//            throw new Exception("");
//        }
//    }
    @Override
    public T remove(int givenPosition) {//一个方法应该在其合理的前提下被执行，以免发生意料之外的情况，而这种前提条件的检查应该放在方法内部
        if ((givenPosition>=1) && (givenPosition<=numberOfEntries)){
            T entry=list[givenPosition-1];
            if (givenPosition < numberOfEntries){
                //转化为实际的数组下标
                int firstIndex=givenPosition-1;
                int lastIndex=numberOfEntries-1;
                for (int i=firstIndex;i<lastIndex;i++){
                   list[i]=list[i+1];
                }
            }
            numberOfEntries--;
            return entry;
        }else {
//            throw new Exception();
        }

       return  null;
    }

    @Override
    public void clear() {
       //第一版
        while (numberOfEntries!=0){
            remove(numberOfEntries--);
        }
        //第二版
        list=null;
        numberOfEntries=0;
    }

    @Override
    public T replacce(int givenPosition, T newEntry) {
       if ((givenPosition>=1) &&(givenPosition<numberOfEntries)){
           T data=list[givenPosition];
           list[givenPosition]=newEntry;
           return data;
       }else {

       }
       return null;
    }

    @Override
    public T getEntry(int givenPosition) {
        if ((givenPosition>=1) &&(givenPosition<numberOfEntries)){
            T data=list[givenPosition];
            return data;
        }else {

        }
        return null;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found=false;
        int index=0;
        while (!found){
            found=anEntry==list[index++];
        }
        return found;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
    public void ensureCapacity(){
        //获取当前容量
        int currentCapacity =list.length-1;
        if (numberOfEntries> currentCapacity){
            int newCapacity=currentCapacity *2;
          //  checkCapacity(newCapacity);
            list= Arrays.copyOf(list,newCapacity+1);

        }
    }
    public void displayList(){
        if (numberOfEntries>0){
            for (T entry:list){
                System.out.print(""+entry);
            }
        }else {
            System.out.print("为空");
        }
    }

}
