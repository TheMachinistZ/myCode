public class GenricTypeTest {
}
 interface Pairable<T>{//像使用饮料机一样使用ADT,而接口就是在定义这个饮料机的操作界面，
    // 就像是面向着类的客户程序员设计我这个类的操作界面
   public T getFirst();
   public T getSecond();
   public void changeOder(T first,T second);
}
class PairableClass<C> implements  Pairable<C>{//只是一个占位符罢了，是什么不要紧
    private  C first;
    private C second;
    public  PairableClass(C first, C second){
        this.first= first;
        this.second =second;
    }
    @Override
    public C getFirst() {
        return first;
    }

    @Override
    public C  getSecond() {
        return second;
    }

    @Override
    public void changeOder(C first,C second) {
        C temp =first;
        first= second;
        second =temp;
    }
    public String toString(){
        return ""+first+"\t"+second;
    }
   public static  void main(String[] args){
     PairableClass<fater> pairableClass =new PairableClass<>(new fater(),new son());
   }
}
class fater{

}
class  son extends  fater{

}