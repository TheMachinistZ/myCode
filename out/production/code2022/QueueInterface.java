public interface QueueInterface <T>{
    public void enQueue(T elem);
    public T deQueue();
    public T getFront();
    public boolean isEmpty();
    public void clear();
}
//接口的其中一个实际意义在于，可以在完全不实现接口的前提下，完成与这个接口的相关，或者说有使用到这个接口的设计