import sun.rmi.runtime.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MemoryLeakTest {
    //设定程序入口
    public static  void main(String[] args){
          new MemoryLeakTest().addMethod();
    }
    //设计测试方法
    public static List<Double> list =new ArrayList<>();

    public void addMethod(){
        for (int i =0;i<100000000;i++){
            list.add(Math.random());
        }


    }
}
