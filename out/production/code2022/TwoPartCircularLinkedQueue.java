public class TwoPartCircularLinkedQueue <T> implements QueueInterface<T>{
    private class Node{
       private T data;
       private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    private Node queueNode;
    private Node freeNode;

    public TwoPartCircularLinkedQueue() {
        Node newNode = new Node(null,null);
        freeNode =newNode;
        queueNode=newNode;
        newNode.setNext(newNode);
    }

    @Override
    public void enQueue(T elem) {
        if (isChainFull()){
            Node newNode=new Node(null,queueNode);
            freeNode.setNext(newNode);

        }
        //总是新项放进freeNode当前所指的结点中，而新结点的来源，要么来自于已经有的储备
        //要么来自于新的创建，新的创建则需要多余进行入圈连接的操作而已
        freeNode.setData(elem);
        freeNode=freeNode.getNext();
    }

    @Override
    public T deQueue() {
        if (isEmpty()){
            //throw  new Exception("");
        }else {
            T data =queueNode.getData();
            queueNode.setData(null);
            queueNode=queueNode.getNext();
            return data;
        }
        return  null;
    }

    @Override
    public T getFront() {
      if (isEmpty()){
      //   throw  new Exception("");
      }else {
          return queueNode.getData();
      }
    }

    @Override
    public boolean isEmpty() {
        //不用位置，可用位置和已用位置三合一
        return queueNode == freeNode;
    }

    @Override
    public void clear() {
       Node workNode=queueNode;
       while (workNode!=freeNode){
           workNode.setData(null);
           workNode=workNode.getNext();
       }//因为freeNode永远不指向含有数据的一项，所以不用专门设置freeNode为null
       queueNode=freeNode;// freeNode=queueNode;都可以，只要指向同一个就可

        while (!isEmpty()){
            deQueue();
        }

    }
    private boolean isChainFull(){
        return freeNode.getNext() == queueNode;
    }
}
