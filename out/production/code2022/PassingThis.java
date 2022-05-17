
//定一个处理方法
class peeler{
    public static Apple peel(Apple apple){//外部的工具方法/处理方法一般定义为静态,之所以定义为工具类是因为它将要被应用到很多不同的类中
        //而我并不想重复这些代码
        return apple;
    }
}
//使用this来使得处理方法处理自己
class Apple{
   public Apple getPeel(){
       return peeler.peel(this);//类的这个方法的本质上是调用一个外部工具类
   }
}
//调用一个这个类中的自我处理方法
class Person{
    public void eat(Apple apple){
      apple.getPeel();
      System.out.println("oh!thats is great!");
    }

}
//整个程序执行入口
public class PassingThis {
    public static  void main(String[] args){//到目前为止程序是驻留在内存中即将待被执行一个线性执行序列，所以必须有一个执行开始位置
        new Person().eat(new Apple());
    }
}
