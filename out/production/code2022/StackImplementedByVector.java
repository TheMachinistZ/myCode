import java.util.EmptyStackException;
import java.util.Vector;

public class StackImplementedByVector<T>  implements StackInterface<T>{
   private Vector<T> stack;
   private  boolean initialized =false;
   private static final int DEFAULT_CAPACITY=50;
   final private static  int MAX_CAPACITY=10000;
    public StackImplementedByVector (int desiredCapacity){
        if (desiredCapacity <= MAX_CAPACITY){
            Vector<T> vector =new Vector(desiredCapacity);
            stack =vector;
            initialized =true;
        }

    }
    public StackImplementedByVector(){
         new StackImplementedByVector(DEFAULT_CAPACITY);//?
    }
    @Override
    public void push(T newEntry) {
         checkInitialization();
         if (stack.size() < MAX_CAPACITY){
               stack.add(newEntry);
         }else {
             throw  new IllegalStateException("oversize");
         }
    }

    @Override
    public T pop() {
        checkInitialization();
        if (!isEmpty()){
            T top =stack.remove(stack.size() -1);
            return top;
        }else throw  new EmptyStackException();
       
    }

    @Override
    public T peek() {
        checkInitialization();
        if (!isEmpty()){
          return stack.lastElement();
        }else throw new EmptyStackException();

    }

    @Override
    public boolean isEmpty() {
        checkInitialization();
        return stack.isEmpty();
    }

    @Override
    public void clear() {
       checkInitialization();
       if (!isEmpty()){
           stack.clear();
       }
    }
    private  void checkInitialization(){
        if (!initialized) throw  new IllegalStateException("This stack is not initialized properly");
    }
}
