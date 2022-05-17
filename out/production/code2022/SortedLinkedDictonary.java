import java.util.Iterator;

public class SortedLinkedDictonary<K extends Comparable<? super K>,V> implements DictionaryInterface<K,V> {
    class Node{
        K key;
        V value;
        Node nextNode;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;

        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node getNextNode() {
            return nextNode;
         }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
    private Node firstNode;
    private int numberOfEntries;
    private class KeyIterator implements Iterator<K>{
        private Node nextNode;//底层数据结构就是个“指针”（这里使用指针的含义在于要和Scanner的hasNext()，next（）等方法找出共通之处）
        public KeyIterator(){
            nextNode=firstNode;//构造方法 将“指针”初始化在被迭代对象的最开始
        }
        @Override
        public boolean hasNext() {
            return nextNode!=null;
        }

        @Override
        public K next() {//由这里的实现可以得知，Scanner实际上是一个字符文件设备的迭代器
            //字符文件设备实际上是一个严格具有线性顺序的读取设备，就像字符一样，有严格的线性顺序
            //所谓有严格的线性顺序：就是不能不需要其他部分，而读得字符正确的信息
            K result =null;
            if (hasNext()){
                result=nextNode.getKey();
                nextNode=nextNode.getNextNode();
            }
            return result;

            return nextNode.getKey();
        }
    }
    public SortedLinkedDictonary() {

    }
   public V add(V value){
     return null;
   }
    @Override
    public V add(K key, V value) {
        V result=null;
        Node currentNode = firstNode;
        Node nodeBefore=null;
        //search chain until you either find a node containing  the key
        //or locate where the key should be
        //当搜索停止时 只剩下 大于和相等两种情况
        //  等于代表找到含有这个键的结点 即 find a node containing the key
        //  大于代表找到了 这个键应该在的位置 locate where the key should be
        while (currentNode!=null && currentNode.getKey().compareTo(key) < 0){
            nodeBefore=currentNode;
            currentNode=currentNode.getNextNode();
        }
        if (currentNode!=null && currentNode.getKey().compareTo(key) == 0){//第一种情况
            result=currentNode.value;//get old value
            //repalce old value
            currentNode.setValue(value);
        }else {//第二种情况
            Node newNode = new Node(key,value);
            nodeBefore.setNextNode(newNode);
            newNode.setNextNode(currentNode);
        }
        return result;
    }

    @Override
    public V getValue(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
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
}
