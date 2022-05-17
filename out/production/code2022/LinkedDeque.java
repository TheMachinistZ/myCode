import org.w3c.dom.stylesheets.MediaList;

public class LinkedDeque <T> implements DequeInterface<T>{
    class DNode{
        DNode previous;
        DNode next;
        T data;

        public DNode(DNode previous, DNode next, T data) {
            this.previous = previous;
            this.next = next;
            this.data = data;
        }

        public DNode getNext() {
            return next;
        }

        public DNode getPrevious() {
            return previous;
        }

        public T getData() {
            return data;
        }

        public void setNext(DNode next) {
            this.next = next;
        }

        public void setPrevious(DNode previous) {
            this.previous = previous;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
    private DNode firstNode;
    private DNode lastNode;

    public LinkedDeque(DNode firstNode, DNode lastNode) {
        this.firstNode = firstNode;
        this.lastNode = lastNode;
    }

    public LinkedDeque() {
       new  LinkedDeque(null,null);
    }

    @Override
    public void addToFront(T newEntry) {
       DNode newNode= new DNode(null,firstNode,newEntry);
       if (isEmpty()){
           //如果是空上面那个构造方法中前两项参数为null
           firstNode=newNode;
           lastNode=newNode;
       }else {
          firstNode.setPrevious(newNode);
          firstNode=newNode;
       }
    }

    @Override
    public void addToBack(T newEntry) {
        DNode newDNode=new DNode(lastNode,null,newEntry);
        if (isEmpty()){
           firstNode=newDNode;
        }else {
           lastNode.setNext(newDNode);
        }
        lastNode=newDNode;
    }

    @Override
    public T removeFront() {
        //第一版， 没有考虑全面
        //        if (isEmpty()){
//            throw  new Exception("");
//        }else {
//            T data =firstNode.getData();
//            DNode node=firstNode.getNext();
//            firstNode.setNext(null);
//            node.setPrevious(null);
//            firstNode=node;
//            return data;
//        }
      T front=getFront();
       firstNode=firstNode.getNext();
       if (firstNode!=null){//意味着链表中至少有两项
           //每一个结点至少有两个引用，头节点也不例外， firstNode=firstNode.getNext()已经消除了其中了一个
           //下面的语句再消除另外一个，根据Java GC机制则该结点代表的内存空间被回收
           //因此remove操作是get和delete操作的组合
           firstNode.setPrevious(null);
       }else {
           lastNode=null;
       }
       return front;
    }

    @Override
    public T removeBack() {
        return null;
    }

    @Override
    public T getFront() {
        return null;
    }

    @Override
    public T getBack() {
        if (isEmpty()){
          //  throw  new Exception("???");
        }else {
            return  lastNode.getData();
        }
        return  null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
}
