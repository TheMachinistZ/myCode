public class zuoye {
    public static void main(String[] args){
        int a=12345;
        int count=5;
        int mod=10;
        int[] b= new int[5];
       System.out.print("这个数的逆序数为:");
        for (int i=0;i<5;i++){
//           b[i]=(a % mod);
//           b[i]=b[i]/(mod/10);
//           mod=mod*10;
            b[i]=SortBiggerArray.getNumberOfDigit2(a,i);
           System.out.print(b[i]+"\t");
       }
       for (int i=4;i>=0;i--){
           if (b[i]==0){
               count--;
           }else {
               break;
           }
       }
       System.out.print("\n这个数是"+count+"位数\n");

    }
}
