import java.util.Iterator;

public class DictionaryTest {
    static class Name{
       String name;
       public Name(String name){
           this.name =name;
       }
    }
    static class  Dictionary<K ,V> implements DictionaryInterface<K,V>{

        @Override
        public V add(K key, V value) {
            return null;
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
    }
    public static  void main(String[] args){
       //自测题1，2，3
       Dictionary<Name,String> database = new Dictionary<>();
       database.add(new Name("张沛"),"18721809118");
       System.out.println(database.contains(new Name("Britney Storm"))? database.getValue(new Name("Britney Storm")):"there is no one like this");
  }
}
