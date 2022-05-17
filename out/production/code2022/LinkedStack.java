import java.util.EmptyStackException;

public final class LinkedStack<T> implements StackInterface<T> {
    private  Node typeNode;
    class  Node{
        private T data;
        private Node next;
        public Node(T data,Node next){
            this.data =data;
            this.next =next;
        }
        public Node(T data){
            new Node(data,null);
        }

        public Node getNext() {
            return next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    public LinkedStack(){
        this.typeNode =null;
    }
    @Override
    public void push(T newEntry) {
      Node newNodeInLink =new Node(newEntry,typeNode);
      typeNode =newNodeInLink;
    }

    @Override
    public T pop() {
       //第一版实现
        //        T data;
//        if (isEmpty())
//        {
//            throw  new EmptyStackException();
//        }
//        else
//        {
//            data = peek();
//            typeNode =typeNode.getNext();
//        }
//        return  data;
    //第二版实现 自测题1
        T data;
        if (isEmpty()){
            throw  new EmptyStackException();
        }
        else {
            data = typeNode.getData();
            typeNode =typeNode.getNext();
        }
        return  data;
    }

    @Override
    public T peek() {
        T data;
        if (isEmpty())
            throw  new EmptyStackException();
        else
             data =typeNode.getData();
        return data;
    }

    @Override
    public boolean isEmpty() {
        return typeNode == null;
        //至少在JVM中，判断链表的空与否的标准，这不是某种约定，这是有机制原因的——如果一个链表的头节点为null，那么按照没有引用的内存将会被GC的机制
        //处于这个链条上发生了引用链的节点将会被链式回收
        //也就是说，在JVM中，如果一个链表的头节点为null，这个链表必为空。但在C中就不一定了
        //由此我们可知，编程语言的特性，会影响数据结构的底层实现方法，比如c语言这种没有自动回收机制的语言，头节点置为null，
        // 如果没有在清空过程中手动free，那整个链都有可能依旧存活在内存中，并引起内存泄漏。
    }

    @Override
    public void clear() {
       typeNode =null;
    }

}
