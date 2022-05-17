public interface SortedListInterface <T extends Comparable<? super T >> {
      public void add(T anEntry);
      public boolean remove(T anEntry);
      public int getPosition(T anEntry);
      public T getEntry(int position);
      public boolean contains(T anEntry);
      public T remove(int position);
      public void clear();
      public int getLength();
      public boolean isEmpty();
      public T[] toArray();
}
