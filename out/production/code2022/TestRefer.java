public class TestRefer {


    public static  void main(String[] args){
      String[] a= new String[3];
      String[] b=a;//此时传递的是引用

      a[0]="a";
      b[1]="b";
      for (String c:a){//使用元素c遍历数组a
          System.out.println("\n"+c);
      }

      Bundle bundle1 =new Bundle();
      bundle1.setFlag(11111111);
      bundle1.disPlayFlag();
      System.out.println("before:"+bundle1);
      Bundle bundle2=bundle1;
        bundle2.setFlag(2222222);
        bundle1.disPlayFlag();//检测源数据有没有被改变
        bundle2=null;//
      System.out.println("after:"+bundle1);

      System.out.println("CurrentBundle2:"+bundle2);
      //
        int A=1;
        System.out.println("这个数值为"+A);
        int B=A;
        B=0;
        System.out.println("这个数值为"+A);
        Bundle bundle3=new Bundle();
        bundle3.setFlag(333333);
        Bundle.setNull(bundle3);
        System.out.println("bundle3为："+bundle3);
        bundle3.disPlayFlag();
        Bundle.setObjectByRefer(bundle3,444444);
        bundle3.disPlayFlag();

  }

}
class Bundle{
    private  int flag;
    public   void setFlag(int flag){
        this.flag =flag;
    }
    public   int getFlag(){
        return this.flag;
    }
    public   void disPlayFlag(){
        System.out.println("这是哪个bundle"+this+"打印flag："+this.flag);
    }

public static  void setNull(Bundle bundle){
        bundle=null;
}
public static  void setObjectByRefer(Bundle bundle,int flag){
        bundle.setFlag(flag);
}
}