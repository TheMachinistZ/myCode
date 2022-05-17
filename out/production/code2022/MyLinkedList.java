import java.util.List;

public class MyLinkedList<T> implements ListInterface<T>{
    public static void main(String[] args){
        //开始测试核心方法
        ListInterface<String> myList=new MyLinkedList<>();
        System.out.println("list shoud be empty:"+myList.isEmpty());
        myList.add("熊");
        myList.add("汝");
        myList.add("涵");
        displayList(myList);
        System.out.println("list is not empty:"+!myList.isEmpty());
        //test method clear()
        myList.clear();
        System.out.println();
        System.out.println("list should be empty:"+myList.isEmpty());
        // test method remove()
        myList.add("熊");
        myList.add("汝");
        myList.add("涵");
        String removedElem=myList.remove(3);
        displayList(myList);
        System.out.println("and,removed entry is "+removedElem);
        // test method contains（）
        System.out.println("is contains?"+ myList.contains(removedElem));
        System.out.println("is contains?"+ myList.contains("熊"));

    }
    public static void displayList(ListInterface<String> list){
       System.out.println("The list contains "+list.getLength()+" entries, as follows:");
       Object data[]=list.toArray();
       for (int index=0;index<data.length;index++){
           System.out.println(data[index]);
       }
        //换行一次
       System.out.println();

    }
    class Node{
        T data;
        Node next;

        public Node(T data){
            this(data,null);
        }
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
    int numberOfEnties;
    Node firstNode;
    Node lastNode;//新增一个尾引用，几个方法也要随之更改，以增加对这个数据域的维护
    public void MylinkedList(){
        firstNode=null;
        lastNode =null;//新增
        numberOfEnties=0;
    }
    @Override
    public void add(T newEntry) {

       //第一版实现 官方
        Node newNode =new Node(newEntry);
        if (isEmpty()){
            firstNode=newNode;
            lastNode=newNode;//新增
        }else {
            try {
                 //以前只有firstNode的版本
                //                Node lastNode=getNodeAt(numberOfEnties);
//                lastNode.setNext(newNode);
                //新增
                lastNode.setNext(newNode);
                lastNode=newNode;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        numberOfEnties++;
     //第二版实现 尽可能的重用代码的设计原则
//        add(numberOfEnties+1,newEntry);
    }

    @Override
    public void add(int newPosition, T newEntry)  {
        //检查参数合法性，程序必须在正确的前置条件下工作，在合法性的前提下，根据不同参数采取不同的动作
//
//        Node newNode= new Node(newEntry);
//        if (isEmpty()){
//            firstNode = newNode;
//        }else {
//            if ((newPosition>1) && (newPosition <=numberOfEnties+1)){
//
//                try {
//                    Node beforeNode=getNodeAt(newPosition-1);
//                    Node nodeToMove=beforeNode.getNext();
//                    newNode.setNext(nodeToMove);
//                    beforeNode.setNext(newNode);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }else if (newPosition ==1){
//                   newNode.setNext(firstNode);
//                   firstNode=newNode;
//            }
//
//
//        }
//        numberOfEnties++;
        //第二个版本

        if ((newPosition >=1) && (newPosition <= numberOfEnties+1)){
            Node newNode =new Node(newEntry);
             //没有lastNode数据域时的情况

            //            if (newPosition ==1 ){
//               newNode.setNext(firstNode);
//               firstNode=newNode;
//            }else {
//               Node nodeBefore=getNodeAt(newPosition-1);
//               newNode.setNext(nodeBefore.getNext());
//               nodeBefore.setNext(newNode);
//            }
//            numberOfEnties++;
            //有lastNode数据域时的情况
            if (isEmpty()){//空线性表
                firstNode =newNode;
                lastNode =newNode;
            }else if (newPosition ==numberOfEnties+1){//非空线性表的末尾
               lastNode.setNext(newNode);
               lastNode=newNode;
            //其余两种不影响尾引用的添加情况
            }else if (numberOfEnties ==1){
                newNode.setNext(firstNode);
                firstNode=newNode;
            }else {
                Node nodeBefore=getNodeAt(newPosition-1);
               newNode.setNext(nodeBefore.getNext());
               nodeBefore.setNext(newNode);
            }
        }

    }

    @Override
    public T remove(int givenPosition) {
        T result =null;
         //没有LastNode的情况
        //        if ((givenPosition>=1) && (givenPosition<=numberOfEnties)){
//            if (givenPosition ==1){
//                result =firstNode.getData();
//                firstNode=firstNode.getNext();
//            }else {
//                Node nodeBefore=getNodeAt(givenPosition-1);
//                Node nodeToMove=nodeBefore.getNext();
//                result=nodeToMove.getData();
//                Node nodeAfter=nodeToMove.getNext();
//                nodeBefore.setNext(nodeAfter);
//                nodeToMove=null;//可以但没必要，nodeToMove只要不会被外面的引用，也就是内存泄漏逃逸
//
//            }
//            numberOfEnties--;
//        }
        //新增
        if ((givenPosition >=1) && (givenPosition<=numberOfEnties)){
            if (givenPosition == 1){
                if (givenPosition==1){
                    result=firstNode.getData();//先取数据
                    //再对结构进行调整
                    firstNode=firstNode.getNext();
                    if (numberOfEnties==1){
                    lastNode=null;
                    }
                }
            }else {
                Node nodeBefore=getNodeAt(givenPosition-1);//无论有没有持有lastNode，都得知道前一个结点，这是单链表即便有尾巴引用也无法做到的
                Node nodeToMove=nodeBefore.getNext();
               result=nodeToMove.getData();
                Node nodeAfter=nodeToMove.getNext();
               nodeBefore.setNext(nodeAfter);
               nodeToMove=null;//可以但没必要，nodeToMove只要不会被外面的引用，也就是内存泄漏逃逸
                if(givenPosition==numberOfEnties){//只在一种情况下触发，对lastNode这个数据域的更新
                    lastNode=nodeBefore;
                }
            }
            numberOfEnties--;
        }
        return result;
    }
     //remove 方法 第二版 练习
    private T remove2(int givenPosition){
        T result =null;
        if ((givenPosition >=1) && (givenPosition <=numberOfEnties)){
             if (givenPosition==1){
                 result = firstNode.getData();
                 firstNode=firstNode.getNext();
                 if (numberOfEnties==1){
                     lastNode=null;
                 }

             }else {
                Node nodeBefore =getNodeAt(givenPosition-1);
                Node nodeToMove =nodeBefore.getNext();
                result =nodeToMove.getData();
                nodeBefore.setNext(nodeToMove.getNext());
                if (givenPosition == numberOfEnties){
                    lastNode=nodeBefore;
                }

             }
        numberOfEnties--;
        }
        return  result;
    }
    private T remove3(int givenPosition){
        T result=null;
        if ((givenPosition>=1) && (givenPosition<=numberOfEnties)){
            if (givenPosition==1){
                 result = firstNode.getData();
                 firstNode=firstNode.getNext();
                 if (numberOfEnties == 1){
                     lastNode=null;
                 }
            }else {
                Node nodeBefore =getNodeAt(givenPosition-1);
                Node nodeToMove=nodeBefore.getNext();
                result=nodeToMove.getData();
                nodeBefore.setNext(nodeToMove.getNext());
                if (givenPosition == numberOfEnties){
                    lastNode=nodeBefore;
                }
            }
            numberOfEnties--;
        }
        return  result;
    }

    @Override
    public void clear() {
       firstNode =null;
       numberOfEnties =0;
    }

    @Override
    public T replacce(int givenPosition, T newEntry) {
        //捍卫你的尊严
        T result =null;
        if ((givenPosition>=1) &&(givenPosition <=numberOfEnties)){
             Node nodeNeedReplace=getNodeAt(givenPosition);
             result =nodeNeedReplace.getData();
             nodeNeedReplace.setData(newEntry);
         }
        return result;
    }

    @Override
    public T getEntry(int givenPosition) {
        return null;
    }

    @Override
    public T[] toArray() {
       //先在方法内部申请内存创建一个泛型数组
        @SuppressWarnings("uncheck")
                T[] result=(T[])new Object[numberOfEnties];
        //然后把挨个读取链表，将内容读取到这个数组中
        int index=0;//访问链表的同时，也需要访问数组，这是需要一个额外数组下标的原因，只不过访问链表是读，访问数组是写
        Node currentNode=firstNode;
        while ((index <numberOfEnties) && (currentNode!=null)){
            result[index++]=currentNode.getData();
            currentNode=currentNode.getNext();
        }
        //返回这个内部生成的数组的引用

        return result;
    }

    @Override
    public boolean contains(T anEntry) {
       boolean found=false;
       Node currentNode=firstNode;
       while (!found && currentNode!=null){
           if (anEntry.equals(currentNode.getData())){
              found=true;
           }else {
               currentNode=currentNode.getNext();
           }

       }

        return found;
    }

    @Override
    public int getLength() {
        return numberOfEnties;
    }

    @Override
    public boolean isEmpty() {
       if (numberOfEnties==0){
           assert firstNode==null;
           return true;
       }else {
           assert  firstNode!=null;
           return false;
       }

    }
    private Node getNodeAt(int position) {
        if (((position>=1) && (position <= numberOfEnties)) && (firstNode !=null)){
            Node result=firstNode;
            for (int counter=1;counter<position;counter++)//需要注意的是控制循环的是循环次数
                result=result.getNext();
            return result;
        }else {
            return null;
        }
    }
    //优化版本
    private  Node getNodeAt2(int givenPosition){
        if ((givenPosition >=1) && (givenPosition<=numberOfEnties)){
            Node result=firstNode;
            if (givenPosition==numberOfEnties){
                result=lastNode;
            }else {
                for (int i=1;i<givenPosition;i++){
                    result=result.getNext();
                }
              return result;
              }
        }else {
            return  null;
        }
        return  null;
    }
}
