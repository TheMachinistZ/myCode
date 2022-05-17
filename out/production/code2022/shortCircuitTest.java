public class shortCircuitTest {
    public static void main(String[] args){
        int A=1;
        int B=2;
        if ((++A) <1){
            boolean a=++B < 4;
        }else {

        }
//        if ((++A < 1)&&( ++B < 4)){
//
//        }
        System.out.println("A："+A);
        System.out.println("B："+B);
    }
}
