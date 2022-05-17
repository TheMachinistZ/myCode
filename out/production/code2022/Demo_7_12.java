public class Demo_7_12 {
    public static   void  main(String[] args){
        lib lib= new lib();
        lib.breakInCycle();
        lib.ContinueInCycle();
        lib.returnInCycle();
    }

}
 class lib{
     public void breakInCycle(){
         int i=0;
         for ( i=0;i< 10;i++){
             if (i == 5)
                 break;
             System.out.println("i的数值当前为\t"+i);
         }
         System.out.println("breakInCycle is end and i is\n"+i);
     }
     public void ContinueInCycle(){
         int i=0;
         for ( i=0;i< 10;i++){
             if (i == 5)
                 continue;
             System.out.println("i的数值当前为\t"+i);
         }
         System.out.println("ContinueInCycle is end and i is\n"+i);
     }
     public void returnInCycle(){
         int i=0;
         while (true) {
             for (i = 0; i < 10; i++) {
                 if (i == 5)
                     return;
                 System.out.println("i的数值当前为\t" + i);
             }
             System.out.println("returnInCycle is end and i is\n" + i);
         }
         }
}