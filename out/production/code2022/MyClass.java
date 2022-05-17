public class MyClass {
    public static <T extends  Comparable<T>> T arrayMinimun(T[] anArray){
        T Minimun=anArray[0];
        for (T arrayEntry:anArray){
           if (arrayEntry.compareTo(Minimun)<0)
               Minimun = arrayEntry;
       }
        return  Minimun;
    }
}
