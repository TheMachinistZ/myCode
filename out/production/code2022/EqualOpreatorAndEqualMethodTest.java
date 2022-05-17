import java.util.Objects;

public class EqualOpreatorAndEqualMethodTest {
    public static  void main(String[] args){
        TestClass  A =new TestClass(1);
        TestClass  B =new TestClass(1);
        int C =1;
        int D =1;
        String E =new String("123");
        String F =new String("123");
        System.out.println(A.equals(B));
        System.out.println(A == B);
        System.out.println(E == F);
        System.out.println(E.equals(F));

    }

}
class  TestClass {
    int classId ;
    public TestClass(int classId){
        this.classId =classId;
    }
    //重写equals方法
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;//首先判断传递进来的对象与当前对象是不是同一个堆内存的对象，如果是必然相等，从地址到内容  //情况a
        if (o == null || getClass() != o.getClass()) return false;//如果传进来的对象不是这个类，或者为空的情况下，必然不相等 //情况b和情况c
        //因此实际上引用类型对象的比较实际上面对着四种情况，
        // a，是他本身，堆内存的同一个对象，b，空的c，不空但不是同一种类型，d不是堆内存的同一个对象，也不控，是同一个类，
        // 这四种情况对应的不同语句已经标出//情况d
        TestClass testClass = (TestClass) o;//向下转型
        return classId == testClass.classId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId);
    }
}