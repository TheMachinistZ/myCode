import java.awt.peer.SystemTrayPeer;

public class AndOrNotOrExclusiveOrTest {
    //写在前面，这个程序用于测试短路逻辑与，非短路逻辑与和按位与，以及，短路逻辑或，非短路逻辑或和按位或
    //以及 异或和或非
    public static  void main(String args[]){
        //短路逻辑或
        int i=0;
        int j=1;

        if ((i++> -1) || (++j >1)){
            System.out.println(i);
            System.out.println(j);
        }
        //非短路逻辑或
        int k=0;
        int s=1;
        if ((k++> -1) | (++s >1)){
            System.out.println(k);
            System.out.println(s);
        }
        //非短路逻辑与
        int h=0;
        int p=1;
        if ((h++< -1) & (++p >1)){

        }
        System.out.println(h);
        System.out.println(p);
       //短路逻辑与
        int c=0;
        int v=1;
        if ((c++< -1) && (++v >1)){

        }
        System.out.println(c);
        System.out.println(v);


    }

}
