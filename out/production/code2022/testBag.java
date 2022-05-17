public class testBag {
    Item[] items ={
      new Item("feeder",123),
            new Item("sword",567),
        new Item("gril",56898989),new Item("shell",567747)

    };
  //  BagInterface <Item> bagInterface =new Bag<>();
   //static
}
interface  BagInterface <T>{
    public int getCurrent();
    public boolean isEmpty();
    public boolean add(T newEntry);
    public T remove();
    public boolean   remove(T entry);//remove one occurence of given entry from this bag
    public void clear();
    public int getFrequencyOf();//Counts the number of times a given entry appears in this bag
    public boolean conrtains(T anEntry);
    public T[] toArray();//
}


class Bag implements BagInterface{

    @Override
    public int getCurrent() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean add(Object newEntry) {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public boolean remove(Object entry) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getFrequencyOf() {
        return 0;
    }

    @Override
    public boolean conrtains(Object anEntry) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}