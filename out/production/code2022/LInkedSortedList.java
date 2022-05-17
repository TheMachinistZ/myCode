public class LInkedSortedList <T extends Comparable<? super  T>>implements SortedListInterface<T>{
   class Node {
       T data;
       Node next;
       public Node(T data){
           this.data=data;
       }
       //以某一个节点为后继节点的创造新节点
       public Node(T data,Node next){
           this.data =data;
           this.next=next;
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

       public void setNext(Node node) {
           this.next = node;
       }
   }
    private Node firstNode;
    private  int numberOfEntries;
    //由数据结构维护秩序，而非客户
    @Override
    public void add(T anEntry) {
       //准备整合进链表
        Node node = new Node(anEntry);
        Node nodeBefore = getNodeBefore(anEntry);
        if (isEmpty() && nodeBefore==null){
            firstNode=node;//这里高亮粉色是提示你在直接操作一个成员变量，提示你要注意避免一些直接操作成员变量可能带来的严重后果，和应该采取的措施
            // 譬如需要把这个方法设置为私有,或是添加一些额外的限制等等

        }else {
            node.setNext(nodeBefore.getNext());
            nodeBefore.setNext(node);
            //被别人引用，和引用别人
            //我一想到你就心痛。
            //交换的秘诀在于，只要没有被引用，就会被回收，不能没有引用，但可以有多个引用，添加到多个引用，再回收旧的，完成替换
            //向后引用的无所谓，不存在丢失风险，随便想咋换就咋换。就被引用需要被更换的比较有风险一点
        }
        numberOfEntries++;
    }
    //2022.1.10 第二版 有序表 添加元素方法
    private void add2(T anEntry){
        // 创建节点
        Node node = new Node(anEntry);
        Node nodeBefore = getNodeBefore(anEntry);
        if (isEmpty() && nodeBefore ==null){
            firstNode = node;
        }else {
            node.setNext(nodeBefore.getNext());
            nodeBefore.setNext(node);
        }
        numberOfEntries++;

    }
    private Node getNodeBefore(T Newentry) {//获取插入位置，由于链表的特殊性，插入位置需要插入位置前一个节点的引用
         Node currentNode=firstNode;
         Node nodeBefore=null;
         while ((currentNode!=null) &&
                 (Newentry.compareTo(currentNode.getData())>0)){//这两个布尔表达式的顺序是重要的，
              nodeBefore=currentNode;
              currentNode=currentNode.getNext();
         }
         return nodeBefore;
    }
    //2022.1.10 第二版
    private Node getNodeBefore1(T anEntry){
        Node currentNode =firstNode;
        Node nodeBefore=null;
       //循环停下时，变量总是保持在满足最后一次循环执行的状态
        while (currentNode !=null &&
             currentNode.getData().compareTo(anEntry) <0
        ){
            nodeBefore=currentNode;
            currentNode=currentNode.getNext();
        }
        return nodeBefore;
    }
    //添加一个元素到有序表，并且依旧维护有序表顺序方法的 递归实现
    //算法高层
    public void addByRecursion(T anEntry){
        firstNode=add(anEntry,firstNode);
        numberOfEntries++;
    }
    //算法底层
    private Node add(T anEntry,Node currentNode){
        if (currentNode ==null
            || currentNode.getData().compareTo(anEntry) >0){
            currentNode = new Node(anEntry,currentNode);
        }else {

            Node nodeAfter =add(anEntry,currentNode.getNext());//找到了正确的插入位置而返回
            currentNode.setNext(nodeAfter);

        }
        return  currentNode;
    }
    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public int getPosition(T anEntry) {
        return 0;
    }

    @Override
    public T getEntry(int position) {
        return null;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
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
