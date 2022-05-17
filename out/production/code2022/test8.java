
class test{
    public void A(){
       B();
       this.B();
    }
    public void B(){


    }
}
public class test8 {
   public static void main(String[] args){
       test test1= new test();
       test1.A();
   }
}
