public class StackOverFlowTest {
    public static void main(String[] args){
        byte[] a = new byte[12];
        for (int i=0;i<12;i++){
            a[i]=0;
        }
    }
    public void test(byte[] a){
        byte[] c= new byte[8];
        c=a;
    }
}
