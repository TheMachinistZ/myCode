import javax.jws.WebParam;

class TestEntry1{
     public  static  void main(String[] args){
           LinkedBag<String> aBag =  new LinkedBag<>();
           display(aBag);
           String[] contents =new String[]{"A","B","C","D","E","F","G"};
           testAdd(aBag,contents);

     }




    private  static  void testAdd(LinkedBag<String> aBag,String[] input){//实际上用代码自动化测试ADT包提供的方法

        for ( int index=0;index<input.length;index++){
            //有可能中断循环
            if (aBag.add(input[index])){

            }else {
                System.out.println("unable to add elem"+index);

            }

        }
     //添加结束显示结果
        display(aBag);
    }
    //对于链表实现的ADT可能会出现倒序输出现象，因为LinkedBag默认是错头部添加元素的
    private  static  void  display(LinkedBag<String> aBag){//这段代码有点像个脚本，显示内容
        Object[] bag= aBag.toArray();
        System.out.println(""+bag.length);
        for (int index=0;index<bag.length;index++){
            System.out.println(""+bag[index]);
        }

    }
}

public class LinkedBag<T> implements MyBagInterface<T>{
    private class Node{
        private T data;
        private Node next;
        private  boolean initialized;
        public Node(T dataPortion){
            this(dataPortion,null);
        }
        public  Node(T dataPortion,Node nextNode){
             this.data =dataPortion;
             this.next=nextNode;
        }
        public Node getNextNode(){
            return this.next;
        }
        public T getData(){
            return  this.data;
        }
    }
    private Node firstNode;
    private int numberOfEnties;
    public LinkedBag(){

    }
    @Override
    public int getCurrent() {
        return 0;
    }

    @Override
    public boolean isEmpty() {

        return firstNode == null;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode =new Node(newEntry);//将数据newentry的引用通过构造方法传递给Node的数据域
        //引用交换
        newNode.next=firstNode;
        firstNode = newNode;
        numberOfEnties++;
        return true;
    }

    @Override
    public T remove() {
       //第一版实现
        //        Node result =null;
//        if (firstNode!=null){
//            //删除链表中的一个元素，就是让这个元素不指向任何元素（指向null）
//            // 也让链表中的任何元素不指向它，只保证有操作者持有唯一的引用
//            result = firstNode.next;
//            firstNode.next =result.next;//不被任何元素指
//            result.next=null;//也不指向任何元素
//            numberOfEnties--;//删除完成更新计数器
//        }
//        return (T) result;
    //第二版实现
     T resultData =null;
     if (firstNode!=null){//如果链表不为空,链表是不是空通过firstNode是不是空来判断，那就说明一件事，firstNode 默认是包含数据的
         resultData =firstNode.data;
         firstNode=firstNode.next;//
         numberOfEnties--;
     }
     return resultData;
    }
   private Node getReferenceTo(T anEntry){
        //第一版实现（与第二版差别不大）
        //        Node result =null;
//        Node currentNode =firstNode;
//        boolean found =false;
//        while (!found && currentNode.next!=null){
//            if (currentNode.data.equals(anEntry)){
//                found=true;
//                result =currentNode;
//            }
//            currentNode=currentNode.next;
//        }
//        return result;
//       //第二版
//       Node currentNode =null;
//       boolean found =false;//默认为没找到，找到还来调用搜索干啥
//       while (!found && currentNode.next !=null){//判断有问题
//            if (currentNode.data.equals(anEntry)){
//                return currentNode;//利用return中止循环,带着正确结果返回终止循环
//            }else {
//               currentNode= currentNode.next;
//            }
//       }
//        return null;//循环中断没有发生，说明没有这个元素，自然返回null
//       //第三版实现
//       //提问，while循环判断中currentNode.next!=null和currentNode!=null有什么区别
//       //如果是currentNode.next!=null将会总是有最后一个元素被检查不到，
//       //currentNode.next!=null作为循环判断，意味着最后一个元素进入不了判断
//       Node currentNode =null;
//       boolean found =false;
//       while (!found && currentNode!=null){
//           if (currentNode.data.equals(anEntry)){
//               found=true;
//           }else {
//               currentNode=currentNode.next;
//           }
//       }
//       return currentNode;
//       //第四版实现 自测题11
//       Node currentNode=null;
//       for (int i=0;i<numberOfEnties;i++){
//            if (currentNode.equals(anEntry)){
//                i=numberOfEnties;//或者直接break
//            }
//       }
//       return currentNode;
       //第五版实现 自测题11答案
       boolean found =false;
       Node currentNode =null;
       int counter =0;
       while (!found && (counter < numberOfEnties)){
           if (currentNode.equals(anEntry)){
               found=true;
           }else {
               counter++;
           }
       }
       return currentNode;
    }
    //remove the specified one
    @Override
    public boolean remove(T entry) {
        boolean result= false;
        Node node=getReferenceTo(entry);
        if (node !=null){
            //每次在头节点位置删除元素有个好处，因为头节点比较特殊，
            // 它没有前驱结点，这样在脱离链条时就不用获取前驱结点了
            node.data=firstNode.data;
            firstNode=firstNode.next;
            result =true;
            numberOfEnties--;
        }
        return result;
    }

    @Override
    public void clear() {
       //第一版实现
        while (firstNode != null){
            remove();//因为定义好是从头节点删除，删光就是删到头节点也为空的程度
        }
       //第二版实现
        while (!isEmpty()){
            remove();
        }
       //自测题13 作答
      //firstNode =null;掩耳盗铃，只是失去了对链表的引用，而这段链表仍然存在于内存中（错误，在java系统中不是这样，在C中或许会这样）
        // 不能将链表结点释放
        //自测题13 答案 见课本
        // 你的想法是对的：没有指向任何内存的引用，会引起空指针异常，
        // 而没有拥有任何引用的的内存，将会使得系统将其回收（java系统中）
        //因此，至少在java中，一块内存区域可以有多个引用，但不能没有引用，否则将会被系统回收
        //所以我们进一步推断，这种java系统将失去引用的内存会自动回收，而 C与C++的系统做不到
        //所以我推测，如果在C语言中使用自测题13这种clear方式 直接将头节点置为null会引起内存泄漏
        //毕竟内存泄露的本质是，无法消除一块只存在引用而在其上不存在使用的内存
        //所以在java中firstNode =null;这种方式实际上是利用java系统的GC机制来销毁链表
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        Node currentNode =firstNode;
        int frequency =0;
        while (currentNode!=null){
            if (currentNode.data.equals(anEntry))
                 frequency++;
            currentNode=currentNode.next;
        }
        return frequency;
    }



    @Override
    public boolean conrtains(T anEntry) {
        //第一版实现
        //        return getFrequencyOf(anEntry)>0;
//        //第二版实现
//        Node currentNode = firstNode;
//        while (currentNode!=null){
//             if (currentNode.equals(anEntry))
//                 return true;
//        }
//        return false;
//        //第三版实现
//        boolean found=false;
//        Node currentNode = firstNode;
//        while ( !found && currentNode!=null){
//            if (currentNode.equals(anEntry)){
//                found = true;//破坏循环条件的动作
//            }
//        }
//        return  false;
        //第四版实现
        return getReferenceTo(anEntry)!=null;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")//这里必须注释忽略编译器错误的原因
        T[] result = (T[])new Object[numberOfEnties];
        Node currentNode =firstNode;
        int index =0;
        while (currentNode!=null){
            result[index] =currentNode.data;
            index++;
            currentNode =currentNode.next;
        }
        return result;
    }

    @Override
    public boolean isArrayFull() {
        return false;
    }

    private void displayChain(Node nodeOne){
       if (nodeOne != null){
           System.out.print(nodeOne.getData());
           displayChain(nodeOne.getNextNode());
       }
    }
    public void display(){
        displayChain(firstNode);
    }
   private  void displayBackward(Node nodeOne){
       if (nodeOne != null){
           displayChain(nodeOne.getNextNode());
           System.out.print(nodeOne.getData());

       }
   }

}
