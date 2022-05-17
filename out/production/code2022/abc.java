public class abc {
    public static  void main(String[] args){

        System.out.print(get(5,5));
    }
    public static int get(int a, int b){
        int c = a/b;
        if (a % b !=0){
            c++;
        }
        return  c;
    }
}
