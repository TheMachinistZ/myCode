public class ArrayQueue <T> implements QueueInterface<T>{
    //四个数据域，两个构造方法
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private int arrayLength;
    private static final int DEFAULT_SIZE=50;

    public ArrayQueue(){
      new  ArrayQueue(DEFAULT_SIZE);
    }
    public ArrayQueue(int initCapacity){
       @SuppressWarnings("unchecked")
               T[] tempQueue=(T[])new Object[initCapacity+1];
       queue=tempQueue;
       arrayLength=tempQueue.length;
       frontIndex=0;
       backIndex=initCapacity;//因为需满足，backIndex和FrontIndex之间总是
    }
    @Override
    public void enQueue(T elem) {
       ensureCapacity();//这是用来监测队列是否变满，变满则扩容
        backIndex=(backIndex+1) % arrayLength ;
        queue[backIndex]=elem;
    }

    private void checkCapacity(int capacity) {
    }

    private void ensureCapacity() {
        //第一版实现 自己的实现：忘记在复制进新数组以后，同时更新数据域
        //        if (frontIndex == (backIndex+2) % arrayLength){
//           int newSize=arrayLength *2;
//            @SuppressWarnings("unchecked")
//            T[] newQueue=(T[])new Object[newSize+1];
//            for (int i=0;i<arrayLength-1;i++){
//                newQueue[i]=queue[(frontIndex+i) % arrayLength];
//            }
//            queue=newQueue;
//
//        }else {
//
//        }
        if (frontIndex ==(backIndex+2) % arrayLength){
            int newSize=arrayLength *2;
            @SuppressWarnings("unchecked")
            T[] newQueue=(T[])new Object[newSize+1];
            for (int i=0;i<arrayLength-1;i++){
                //在扩容到新数组的重点在与维护队列的次序
                newQueue[i]=getFront();
                frontIndex=(frontIndex+1)*arrayLength;
            }
            //更新数据域
            queue=newQueue;
            frontIndex=0;
            backIndex=arrayLength-1;
            arrayLength=newQueue.length;
        }else {

        }
    }

    @Override
    public T deQueue() {
       if (isEmpty()){
           //throw  new Exception();
       }else {
           T data =getFront();
           queue[frontIndex]=null;
           frontIndex=(frontIndex+1) % arrayLength;
           return data;
       }
       return  null;
    }

    @Override
    public T getFront() {
        if (isEmpty()){
         //  throw new Exception("this  queue is empty");
        }else {
           return queue[frontIndex];
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return frontIndex ==(backIndex+1)%arrayLength;
    }

    @Override
    public void clear() {
        //第一个版本 是错误的，错误点以注释的形式在各行指出
        //       if (isEmpty()){
//
//       }else {
//           frontIndex=0;//本身这两条语句不能出现在dequeue()操作之前，会造成后者无法工作
//           backIndex=arrayLength-1;//而且需要注意dequeue()既将队列中对象的所分配的空间置为null
             //同时也会修改frontIndex的数值，当循环调用清空时，就会自己生成front=(backIndex+1)% arrayLength的正确关系


//           for (int i=0;i<arrayLength-1;i++){
//               deQueue();
//           }
//       }
      //第二版 自测题4
//        while (!isEmpty()){
//            deQueue();
//        }
      //第三版 自测3
        if (isEmpty()){

        }else {
         //值得注意的是，循环进行条件为index != backIndex，因为index<backIndex一定是队列中有元素
            //而index>=backIndex不一定队列中没有
            for (int index=frontIndex;index!=backIndex;index=(++index) % arrayLength){
             queue[index]=null;
         }
          queue[backIndex]=null;
          frontIndex=0;
          backIndex=arrayLength-1;//需停留在那1个不用的位置上
        }

        }
    }

