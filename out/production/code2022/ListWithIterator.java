import java.util.Iterator;

public interface ListWithIterator<T> extends ListInterface<T> {
    public Iterator<T> getIterator();
}
