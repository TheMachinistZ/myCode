import jdk.internal.dynalink.beans.StaticClass;

public class referNonStatic {
    private NonstaticClass nonstaticClass;
    public referNonStatic(){
        nonstaticClass=new NonstaticClass();
    }
    public static  void main(String[] args){
        referNonStatic referNonStatic = new referNonStatic();
        Staticmethod(referNonStatic.nonstaticClass);
        // StaticClassTest.c;//静态内部类的非静态成员依然不会加载
    }
    static  void Staticmethod(NonstaticClass nonstaticClass){
        nonstaticClass.print();
    }
    class NonstaticClass{
        private void print(){
            System.out.println("我是一条消息！");
        }
    }
   static class StaticClassTest{
        private int c;
   }
}
