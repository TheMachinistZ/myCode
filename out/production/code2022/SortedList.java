public class SortedList <T extends Comparable<? super T>> implements SortedListInterface<T>{
    private ListInterface<T> list;
    //构造方法应该显式的初始化数据
    public SortedList(ListInterface<T> list) {
        this.list = list;
    }

    @Override
    public void add(T anEntry) {
         int newPosition = getPosition(anEntry);
         list.add(newPosition,anEntry);
    }

    @Override
    public boolean remove(T anEntry) {
        boolean result =false;
        int position = getPosition(anEntry);
        if (position > 0){
            list.remove(position);
            result=true;
        }
        return result;
    }

    @Override
    public int getPosition(T anEntry) {
        int position=1;
        int length = list.getLength();
        if (list.getEntry(position).compareTo(anEntry) <0 &&
            position <length){
           position++;
        }
        if (position > length){
            position=-position;
        }
        return position;
    }

    @Override
    public T getEntry(int position) {
        return null;
    }

    @Override
    public boolean contains(T anEntry) {

        return getPosition(anEntry)>0;
    }

    @Override
    public T remove(int position) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }
}
