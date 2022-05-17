import java.io.IOException;

public class AlgorithmEfficiencyTestChapter4 {
    public static  void main(String[] args) throws IOException {
       long n=100000;
      int control=2;
      System.out.println(control);
      switch(control){
          case 1:
              long st = System.currentTimeMillis();
              algorithm1(n);
              long et = System.currentTimeMillis();
              System.out.println( et - st);
              break;
          case 2:
              long st2 = System.currentTimeMillis();
              algorithm2(n);
              long et2 = System.currentTimeMillis();
              System.out.println( et2 - st2);
              break;
          case 3:
              long st3 = System.currentTimeMillis();
              algorithm3(n);
              long et3 = System.currentTimeMillis();
              System.out.println( et3 - st3);
              break;
      }

    }
   static void algorithm1(long n){
       long sum =0;
        for (long i=1;i<=n;i++){
            sum=sum+i;
        }
       System.out.println(sum+"\n");
   }
    static void algorithm2(long n){
        long sum=0;
        for (long i=1;i<=n;i++){
            for (long c=0;c<i;c++){//这个是和循环次数相关的，所以从不从1开始无所谓
                sum=sum+1;
            }
        }
        System.out.println(sum+"\n");
    }
    static void algorithm3(long n){
        long sum=n * (n+1)/2;
        System.out.println(sum+"\n");
    }
    static boolean hasDuplicates(int array[],int n){//判断数组前N个像中是否含有重复
        for (int i=0;i<n;i++){
             for (int k=i+1;k<n;k++)
                 if (array[k] == array[i]){
                     return true;
                 }

        }
        return false;
    }
}
