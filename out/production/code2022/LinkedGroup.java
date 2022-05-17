public class LinkedGroup<T extends  ComparableInterface<? super T>> {
   private LinkedStack.Node firstNode;
   private int length;
   private void insertInOrder(LinkedStack.Node nodeToInsert){
         T item =(T) nodeToInsert.getData();
         LinkedStack.Node previousNode=null;
         LinkedStack.Node currentNode=firstNode;
         while (currentNode !=null && item.compareTo((T)currentNode.getData())>0){
               previousNode =currentNode;
               currentNode=currentNode.getNext();
         }
         if (previousNode!=null){//判断插入位置
              previousNode.setNext(nodeToInsert);
              nodeToInsert.setNext(currentNode);
         }else {
             nodeToInsert.setNext(firstNode);
             firstNode=nodeToInsert;
         }
   }
   public void insertionSort(){
        if (length >1){
            LinkedStack.Node unsorted=firstNode.getNext();
            firstNode.setNext(null);
            while (unsorted!=null){
                //错误写法：如果 unsorted=unsorted.getNext()在insertInOrder(nodeToInsert)之后
                //由于是引用传递，即操作时同一块内存区域，方法insertInOrder对unsorted产生的影响会同时作用于nextNode,
                //而方法insertInOrder带来的影响，无非是让unsorted指向有序部分中的一个结点或者指向null，
                //所以会使nextNode同样的指向有序部分中的一个结点或者指向null
                //                LinkedStack.Node nextNode=unsorted.getNext();
//                insertInOrder(unsorted);
//                unsorted=nextNode;
                //正确写法
                LinkedStack.Node nodeToInsert=unsorted;
                unsorted=unsorted.getNext();//在受影响之前就应该赋值
                insertInOrder(nodeToInsert);
            }


        }
   }
   //链表上的插入排序复习
   public void insertionSort2(){
       if (length>1){
         LinkedStack.Node unsorted=firstNode.getNext();
         firstNode.setNext(null);
         while(unsorted!=null){
            LinkedStack.Node nodeToInsert=unsorted;
            unsorted=unsorted.getNext();
            insertInOrder2(nodeToInsert);
         }

       }else {
           //长度为1的链表是一个有序序列,对有序序列本身就什么都不做
       }
   }

    private void insertInOrder2(LinkedStack.Node nodeToInsert) {
       //进入一个新的子链表
        LinkedStack.Node previousNode=null;
        LinkedStack.Node currentNode=firstNode;
        //逐个比较,寻找位置
        while (currentNode!=null &&
                ((T)nodeToInsert.getData()).compareTo((T)currentNode.getData())>0){
            previousNode=currentNode;
            currentNode=currentNode.getNext();
        }
        if (previousNode==null){
               nodeToInsert.setNext(firstNode);
               firstNode=nodeToInsert;
        }else {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
   }

}
