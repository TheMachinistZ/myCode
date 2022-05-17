public class JVMRunTImeErrorTest {
    public static void main(String[] args){

        try{
            int a[] =new int[]{1,2,3};
            System.out.println(""+a[3]);
        }catch (Exception e){
            System.out.println("6666");//异常处理机制使得程序能够处理预期之外的情况
        }

    }
}
