public class TestStatic {//
   private int c;
   private Test test;
   private class Test{
        int i=48;
        public Test(){}

    }
    public static void main(String[] args){

       TestStatic testStatic = new TestStatic();

       TestStatic testStatic1 =new TestStatic(2);//获取一个没有实例化内部类的testStatic
      // 错误 TestStatic.Test test2 = new TestStatic.Test();//非静态内部类不能在静态上下文中实例化
       testStatic1.c=2;
       System.out.println("test2 is: not null\\n");
       testStatic.TestMethod();
       testStatic.c = 6;
       System.out.println(""+testStatic.test.i);//这种就是对的
       //类静态方法不能引用自己的非静态内部类变量成员，即使就在静态方法内现场实例化？
      //Test test =new testStatic1.Test();
       // c =6;

   }

   //default constructor
    public TestStatic(){
         test =new Test();
   }
    public TestStatic(int c){

    }
   void TestMethod(){


        Test test = new Test();
   }
   public void Method(){
        System.out.println("66666");
   }

}

