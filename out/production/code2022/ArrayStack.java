import com.sun.xml.internal.bind.v2.schemagen.xmlschema.TopLevelAttribute;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

// A class of stacks whose entries are stored in array
//用数组组织的栈结构
public class ArrayStack<T> implements  StackInterface<T>{
    private T[] stack;
    private  int topIndex;
    private  boolean initialized =false;
    private  final  int DEFAULT_CAPACITY=50;
    private  final int MAX_CAPACITY=10000;
    public ArrayStack(){
       new ArrayStack(DEFAULT_CAPACITY);
    }
    public ArrayStack(int desiredCapacity){
        if (desiredCapacity <= MAX_CAPACITY){
            @SuppressWarnings("unchecked")//抑制编译器警告
                    T [] temBag=(T[])new Object[desiredCapacity];
                    stack = temBag;
                    initialized =true;
                    topIndex =-1;
        }else {
            throw   new IllegalStateException(
                    "Attempt to create a bag whose capacity exceeds allowed maximum"
            );
        }
    }
    @Override
    public void push(T newEntry) {
        //第一版实现
        //           if (initialized){
//               if (topIndex == stack.length -1){
//                   //扩容
//                   int newLength = 2 * stack.length;//以原有最大容量两倍扩容
//                   if (newLength <= MAX_CAPACITY){
//                       @SuppressWarnings("unchecked")//抑制编译器警告
//                               T [] newBag=(T[])new Object[newLength];
//                       for (int i =0;i<stack.length;i++){
//                            newBag[i]=stack[i];
//                       }
//                       stack[++topIndex] =newEntry;
//                   }
//               }else {
//                   stack[++topIndex] =newEntry;
//
//               }
//           }else {
//               throw   new IllegalStateException(
//                       "Attempt to push a bag who is not initialized properly"
//               );
//           }
        //第二版实现
        //一个操作总是在在若干正确的条件下才能被执行
        checkInitialized();
        ensureCapacity();
        stack[topIndex+1]=newEntry;
        topIndex++;

    }

    private void ensureCapacity() {
        if (topIndex == stack.length-1){
            int newLength = stack.length * 2;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack,newLength);//在原来引用的基础上,修改内容属于是
        }
    }

    private void checkCapacity(int newLength){
        if (newLength > MAX_CAPACITY)throw new IllegalStateException("this stack is full");
    }

    @Override
    public T pop() {
     //第一版实现
        //        checkInitialized();
//        T topData=null;
//        if (!isEmpty()){
//             topData = stack[topIndex];
//             topIndex--;
//        }
//        return topData;
//     //第二版实现
//        checkInitialized();
//        if (isEmpty()){
//            throw  new EmptyStackException();
//        }else {
//            T top =stack[topIndex];
//            stack[topIndex] =null;//这是针对栈中的元素是对象而不是基本类型所做的安全处理
        //因为：如果是基本类型的栈，栈中存储的是数据对象，如果是对象的栈，栈中存储的是这些数据对象的引用
        //当栈是对象的栈时，由于实际存储的是对象的引用，所以在删除栈顶元素时，应有置元素为null的安全操作，
        //因为，由于存储对象为引用，所以对象数组的下标索引，是对引用的引用
        //当下标回退1，只是将引用链条的长度减一，并没有完全消除引用链（即对象数组的下标引用指向对象的引用，对象的引用再指向对象）
        //依据GC机制 不会消除带有引用的对象。所以如果不在对象数组中的元素置为null，那么就有造成内存泄漏风险
//            topIndex--;
//            return  top;
//        }
        //第三版实现
        T top =peek();
        stack[topIndex]=null;
        topIndex--;
        return top;
    }

    @Override
    public T peek() {
    //第一版实现
//        checkInitialized();//一起操作应在正确的基础上进行 //正如我前面所说，操作是在若干前提，条件成立的情况下才能发生
//        T topData=null;
//        if (!isEmpty()){
//            topData = stack[topIndex];
//
//        }//缺少了栈为空时，取栈顶元素时的情况处理，在这种情况下，函数的结果会引起用户的困惑（如果用户的正常元素也为null）
//        return topData;
        //第二版实现
        checkInitialized();
        if (isEmpty()){
            throw  new EmptyStackException();
        }else {
            return  stack[topIndex];
        }
    }

    @Override
    public boolean isEmpty() {

//        return stack.length == 0;//错误，此时栈中还有一个元素
        //应为
        return  stack.length <=0;//数组的length属性是一个只读的量,实际上它的含义更贴切于数组的最大容量，而非数组目前的长度
        //所以,数组的length是一个分配给数组用于存储它的元素的内存的大小
    }

    @Override
    public void clear() {
//       //第一版实现 自测题8 练习
//       for (T top:stack){
//             pop();
//       }
       //第二版实现 自测题7 练习
       checkInitialized();
       while (topIndex > -1){
           stack[topIndex] =null;
           topIndex--;
       }

    }
    private  void checkInitialized(){
        if (!initialized) throw new IllegalStateException("Stack is not initialized properly");
    }
}
