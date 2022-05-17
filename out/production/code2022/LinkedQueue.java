public class LinkedQueue<T> implements QueueInterface<T> {
    class Node{
        private T data;
        private  Node next;

        public Node(T data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }
    //以下这两个，就是笔记majorNotes3 中第2233点中所说 “不存在的，不包含数据的”结点
    private Node first;
    private Node last;
    @Override
    public void enQueue(T elem) {
       Node newNode=new Node(elem);
       if (isEmpty()){
          first=newNode;
           last=newNode;
       }else {
          last.setNext(newNode);
          last=newNode;
       }

    }

    @Override
    public T deQueue() {
       if (isEmpty()){
         //  throw new Exception();
       }else {
           T data =first.getData();
           Node temp= first.getNext();
           first.setNext(null);//这一句在有GC的语言中是多余的，但在没有GC的语言如C语言则不一定
           //联系 linkedBag源代码注释 链表章节自测题13
           //一个原则就是，回收/内存泄漏取决于是不是有被引用关系，而不是引用关系，注意是被。
           //即一块内存（用内存来代称所有数据结构，或是对象等等）只要存在被引用，
           //那就不会被GC回收，此时内存泄露的情况，没有GC和有GC的语言是一样的。
           //只不过，还有其他情况存在，所以没有GC的语言内存泄漏情况要严重一些。
           first=temp;
           return data;
       }
       return  null;
    }

    @Override
    public T getFront() {
       if(isEmpty()){
           //throw  new Exception("试图操作的队列为空");
       }else {
           return first.getData();
       }
       return null;
    }

    @Override
    public boolean isEmpty() {
        return (first ==null) && (last ==null);
    }

    @Override
    public void clear() {
        first=null;
        last=null;
    }
}
