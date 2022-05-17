public class Circle implements  Comparable<Circle>{
   int radius;
    @Override
    public int compareTo(Circle o) {
        int result;
        if (this.equals(o)){//相等时，compareTo应与equal返回一致的结果，不如直接将equal作为自己的实现细节
            result =0;
        }else if (this.radius < o.radius){
            result=-1;
        }else {
            result=1;
        }
        return result;
    }
}
