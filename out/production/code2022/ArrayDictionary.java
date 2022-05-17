import java.util.Iterator;
import java.util.Map;

public class ArrayDictionary <K ,V> implements DictionaryInterface<K,V>{
    private  class  Enrty<K,V>{
        private K key;
        private V value;

        public Enrty(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public K getKey() {
            return key;
        }
    }
    //先声明最基础的数据结构
    //肯定是私有
    private Enrty<K,V> [] dictionary;
    private int numberOfEntries;
    private boolean initialized =false;
    //编码必然限制大小
    private final static  int DEFAULT_CAPACITY=25;
    private final static  int MAX_CAPACITY=10000;
    public ArrayDictionary(int capacity){
        checkCapacity(capacity);
        @SuppressWarnings("unchecked")
        Enrty<K, V>[] tempDictionary = (Enrty<K, V>[]) new Enrty[capacity];
        dictionary =tempDictionary;
        numberOfEntries=0;
        initialized =true;
    }

    private  ArrayDictionary(){
      this(DEFAULT_CAPACITY);
    }
    //return the index of the entry that contains the key
    //or returns the numberOfNumbers if no such entries exists
    private  int locateIndex(K key){
      int index =0;
      while (index<numberOfEntries && !key.equals(dictionary[index].getKey())){
          index++;
      }
      return index;
//        return null;//返回null代表着当时还没有实现的方法体,意味着这个语句仅是在设计框架时遗留下来的,因为设计框架就一定意味着有
//        意的留空实现
    }

    @Override
    public V getValue(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        V result =null;
        int index=locateIndex(key);
        if (index!=numberOfEntries){
            result= dictionary[index].getValue();
            dictionary[index]=dictionary[numberOfEntries-1];
            dictionary[numberOfEntries-1]=null;
            numberOfEntries--;
        }

        return result;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator<K> getKeyIterator() {
        return null;
    }

    @Override
    public Iterator<V> getValueIterator() {
        return null;
    }

    @Override
    public void add(V listWithIterator) {

    }
    private void checkCapacity(int capacity){

    }
    public V add(K key,V value){
        V result=null;
        if (key == null && value == null){
            throw  new Exception("");
        }
        //事情也许本来没有因果，所谓因果只是一个事物本质的不同体现
        int index =locateIndex(key);
        //对于这个项是否早已存在，分别对应着不同的处理
        if (index !=  numberOfEntries){//这个项存在，则在不允许键值重复的字典中，发生替换
            result = dictionary[index].getValue();
//            dictionary[index] = new Enrty(key,value);//替换一种更优雅的实现
            dictionary[index].setValue(value);
        }else {//这个项不存在，先检查数组是否已满，再添加至数组末尾
            dictionary[numberOfEntries] = new Enrty<>(key,value);
            numberOfEntries++;//所有维护的数据必须 同步更新
            ensureCapacity();
        }
        return  result;
    }
    //2022.2.28 复习
    public V add2(K key,V value){
        V result=null;
        V oldValue =getValue(key);
        if (oldValue!=null){//发生键值冲突
            result =oldValue;
            oldValue=value;//仅适用于引用型传值
        }else {//没有发生键值冲突
            dictionary[numberOfEntries]=new Enrty<>(key,value);
            numberOfEntries++;
            //给数组扩容
            ensureCapacity();
        }
        return result;//返回null，

    }
    // 2.28复习
    private int locateIndex2(K key){
        int index=0;
        while (!dictionary[index].getKey().equals(key) && index<numberOfEntries){//这个实现一定会有空指针异常
            //分析：我们知道变量截图一定是，变量第一次破坏循环条件的时候所处的情况（不过也只破坏一次，循环条件只需被一次破坏就够了）
            //也就是说当index为numberOfEntries是还会执行循环条件中语句，则会造成indexOutOfBound异常，与空指针
            index++;
        }
        return index;
    }
    private  void ensureCapacity(){}

}
