public class ConditionOprandTest {//条件运算符，是一个三目运算符
    public static  void main(String[] args){
         int a=0;
         String region=a==0?" region true":"region false";
         System.out.println(region);
         int b=1;
         String nested=a==2?b==1?"nested true in region true":"nested false in region false":" regionfalse";
        System.out.println(nested);
    }
}
