

public class TestInterface {

}
 interface MyInterface {
      double value = 0;
      public void setValue(double value);
      public double getValue();
 }
 class ImplClass implements  MyInterface{
     private double value;

     @Override
     public void setValue(double value) {
         this.value =value;
     }

     @Override
     public double getValue() {
         return this.value;
     }
     public static  void main(String args[]){
         double  input = 12;
         ImplClass  implClass = new ImplClass();
          implClass.setValue(input);
          System.out.println(""+implClass.getValue());
     }
 }