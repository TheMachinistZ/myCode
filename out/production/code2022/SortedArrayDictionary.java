import java.util.Iterator;

public class SortedArrayDictionary <K extends Comparable<? super K>,V> implements DictionaryInterface<K,V>{
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
    private Enrty<K,V>[] dictionary;
    private int numberOfEntries;
    private boolean initialized =false;
    //编码必然限制大小
    private final static  int DEFAULT_CAPACITY=25;
    private final static  int MAX_CAPACITY=10000;
    @Override
    public V add(K key, V value) {
        //检查输入
        if (key==null && value ==null){
            throw  new Exception();
        }else {
            V result=null;// 发生冲突时，返回替换值；没有发生冲突，返回null
            int index = locateIndex(key);
            if (index< numberOfEntries && value.equals(dictionary[index])){
                // get old value
                result=dictionary[index].getValue();
                // replace old value
                dictionary[index].setValue(value);
            }else {
                makeRoom(index);
                dictionary[index].setValue(value);
                numberOfEntries++;
            }
           return  result;
        }
    }

    @Override
    public V getValue(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        V reasult =null;
        int index= locateIndex(key);
        if (index!=numberOfEntries){
            reasult = dictionary[index].getValue();
            move(index,numberOfEntries);
            numberOfEntries--;
        }
        return reasult;
    }

    private void move(int start,int end) {
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
    //洗刷耻辱
    //returns the index of either the entry that contains key or
    // the location that the key should be ,if no such entry exists
    //顺序查找版本
    private int locateIndex(K key){
       int index=0;
       while (index<numberOfEntries && key.compareTo(dictionary[index].getKey())>0){
           index++;
       }
       return index;
    }
    //二分法查找版本
    private int locateIndex2(K key){
      return  locateIndexByBinarySearch(key,0,numberOfEntries);
    }
     //改变命运
    private int locateIndexByBinarySearch(K key, int start, int end) {
        int mid = start+ (start-end)/2;//防御大数组可能导致的数组索引运算出现的溢出
        int index=-1;
        if (end > start){
            if (dictionary[mid].getKey().compareTo(key)==0){
                index= mid;
            }else if (dictionary[mid].getKey().compareTo(key)<0){
                index= locateIndexByBinarySearch(key,mid+1,end);
            }else {
                 index= locateIndexByBinarySearch(key,start,mid-1);
            }
        }else {
            //错误做法：
            //这种写法是有错误的，因为这个算法再没有找到在数组中对应存在的key，也应该返回一个应该在的位置，而不是什么都不做返回-1
            //           if (dictionary[mid].getKey().compareTo(key)==0){
            //               index= mid;
            //           }
            //正确做法：
            mid=start;//无论如何都应返回一个值，即无论这个是确实数组中含有这个key并找到了对应位置，还是这个key并不存在，应该返回这个key应该在的位置

        }
        return index;
    }

    //make room for a new entry at a given index by shifting array entries
    // towards the end of array
    private void makeRoom(int keyIndex){

    }
}
