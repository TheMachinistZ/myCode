public class Leaf {
   int i=0;
   Leaf increment(){
       i++;
       return this;
   }
  void print(){
      System.out.println("i is"+i);
   }
  public static  void main(String args[]){
       Leaf leaf =new Leaf();
       leaf.increment().increment().increment().print();//使用return this 返回对象的引用，很容易在一条语句中对一个对象进行多次操作
  }
}
