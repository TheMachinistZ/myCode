import java.util.Iterator;

public interface DictionaryInterface<K,V> {
    public V add(K key,V value);//将一个给定查找键和值的项 添加进字典 键值不允许重复，如果重复则进行替换，并且返回被替换的值，而允许键值重复情况下，什么都不输出
    public V getValue(K key);//获取给定查找键的项
    public V remove(K key);//删除给定查找键的项
    public boolean contains(K key);//
    public boolean isEmpty();
    public int getSize();
    public void clear();
    //两个迭代器
    public Iterator<K> getKeyIterator();
    public Iterator<V> getValueIterator();

    void add(V listWithIterator);
}
