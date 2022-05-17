public class RecursiveCallTest1 {
    public static  void main (String[] args){
        recursive(10);
        System.out.println(recursive2(10));
        System.out.println(sumOf(10));
        System.out.println(sumOf(22));
        //测试递归处理数组
        int a[]=new int[]{1,2,3,4,5,6};
        displayArray(a,2,4);
        System.out.print("\n");
        displayArray3(a,2,4);
        System.out.print("\n");
        displayArray4(a,1,5);
    }
    public static void recursive(int integer){
        System.out.println(integer);
        if (integer > 1){//递归过程内部总是含一个判断是否进入了最小问题的语句,来决定过程是否继续递归还是最小情况直接求解，或者说，是决定继续在内存中继续创建栈帧，还是开始从最啊小情况返回
             //设法让问题规模变小一个规模，进入过程
             recursive(integer-1);
         }
    }
    public static int recursive2(int integer){
        if (integer >1){
            return recursive2(integer - 1) +integer;//得承认,这里是难点，比较拗的一点
            //不仅决定了进入下一个过程的方式，而且决定了过程的返回方式
        }else {
            return 1;
        }
    }
    public void drawCircleByRecursive(double diameter) {
         if (diameter == 16){
             drawCircle(diameter);
         }else {
             drawCircleByRecursive(diameter / (4/3));
             drawCircle(diameter);
         }
    }
    public void drawCircle(double diameter){

    }
    public static  int sumOf(int n){
        int sum;
        if (n==1){
            sum=1;

        }else {
           sum=sumOf(n-1)+n;
        }
        return  sum;
    }
    public static  int  factorial(int n){
       int product;
       if (n ==1){
           product =1;
       }else {
           product = factorial(n-1) * n;
       }
       return  product;
    }
    public  static  void displayArray(int array[],int first,int last){
        //第一版实现
        //        System.out.print(array[first]+"\t");
//        if (first < last){
//             displayArray(array,first+1,last);
//        }
       //第二版实现
     if (last >first)
          displayArray(array,first,last-1);
      System.out.print(array[last]+"\t");
    }
   //分开实现方便测试
    //第三版实现
    public static  void displayArray3(int array[],int first,int last){
        if (first == last){
             System.out.print(array[first]+"\t");
        }else {
            int mid =(first + last)/2;
            displayArray3(array,first,mid);
            displayArray3(array,mid+1,last);
        }
    }
    //第四版实现  自测题5  注意答案有bug
    public static  void displayArray4(int array[],int first,int last){
        if (first <= last){
            if (first == last){
                System.out.print(array[first]+"\t");
            }else {
                int mid=(first +last)/2;
            //    System.out.print("这是第"+mid);
                displayArray4(array,mid+1,last);
                System.out.print(array[mid]+"\t");
                displayArray4(array,first,mid-1);

            }
        }else {
            return;//进入错误情况的栈帧直接返回
        }
       //在含有多种情况的递归的函数中，它的栈帧是在反复增长的，根据进入不同的递归情况。直到最后为0
    }
    //自测题8 幂函数求值的朴素实现
    public static  int  powerFunction(int x,int n){
        //如果一段代码的执行没有在，做事到条件判断的情况下执行，那这段代码就是不可信任的，不可信任的代码更适合作为内部实现细节，
        // 因为内部实现细节，彼此按照某种约定协同工作，可以称作是彼此信任的
        int value;
        if (n == 0){
            value=1;
        }else {
            value=x*powerFunction(x,n-1);
        }
        return value;
    }
    //汉诺塔的两个版本
    public static void solvesTowers(int numberOfDisk,int startPole,int endPole,int tempPole){
       if (numberOfDisk == 1){
           move(startPole,endPole);
       }else {
           solvesTowers(numberOfDisk-1,startPole,tempPole,endPole);
           move(startPole,endPole);
           solvesTowers(numberOfDisk-1,tempPole,startPole,endPole);
       }
    }
    private static void move(int startPole, int endPole) {
    }
    public static  void solvesTowers2(int numberOfDisk,int startPole,int endPole,int tempPole){
        if (numberOfDisk >0){
            
        }
    }
    public void GenerateFibonacci(int n){
         fibonacci(n);
    }

    private int fibonacci(int n) {
          if (n == 1){
              return 1;
          }else {
              return  fibonacci(n-1)+fibonacci(n-2);//某一层的斐波那契数，一定是它上一层和上两层的斐波那契数的和
              //而上一层和上两层的斐波那契数都是以同样的方式得到的
          }
    }
    private  void  railRecursiveForCountDown(int integer){
         while (integer >=1){
             System.out.print(integer--);
         }
    }
}
