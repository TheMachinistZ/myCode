public class SwtichNoBreakTest {
    public static  void main(String[] args){
        int a=0;
        SwitchNoBreak(a);
    }

    private static void SwitchNoBreak(int a) {
        switch(a){
            case 0:
                System.out.println(""+0);
            case 1:
                System.out.println(""+1);
            case 2:
                System.out.println(""+2);
                break;
            case 3:
                System.out.println(""+3);
        }
    }
}
