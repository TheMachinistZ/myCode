public class stackOverFlowErrorTest {
  public static void main(String [] args){
      new StackOverFlowClass().test();//线程所请求的栈深度大于虚拟机所允许的深度 就是stackOverFlow
  }      //虚拟机申请不到足够的内存就会报出OutOfMemoryError(指扩展栈)
}
class  StackOverFlowClass{
    public void  test(){
        this.test();
    }
}