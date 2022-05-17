public class IfElseTest {
    public static  void main(String[] args){
         int a=0;
         int c=1;
         if (c>0){
             System.out.print(c+"分支1");
         }else if (a<0){//分支中的分支
            System.out.print(a+"分支2");
        }else {
            System.out.print(a+"分支3");
        }
    }
}
