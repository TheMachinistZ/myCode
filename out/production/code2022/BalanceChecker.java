public class BalanceChecker {
    //设定程序入口
    public static  void main(String[] args){

    }
   public static  boolean checkBalance(String expression){
         StackInterface<Character> openDelimiterStack =new OurStack();
         boolean isBalance =true;
         int index =0;
         while (isBalance && index <expression.length()){
             char character =expression.charAt(index);
             switch(character){
                 case '(': case '{': case '[':
                     openDelimiterStack.push(character);
                     index++;
                     break;
                 case  ')': case '}':case ']':
                     if (openDelimiterStack.isEmpty()){//判空
                         isBalance=false;
                     }else {
//                        第一版实现
//                         if (isPaired(openDelimiterStack.peek(),character)){//判断是否交叉
//                             openDelimiterStack.pop();
//                             index++;
//                         }else {
//                             isBalance =false;
//                         }
//                        第二版实现
                          char openDelimiter =openDelimiterStack.pop();
                          isBalance =isPaired(character,openDelimiter);
                     }

             }
         }

         if (!openDelimiterStack.isEmpty())
             isBalance =false;
         return isBalance;
   }
   public static  boolean isPaired(char open,char close){
       //第一版实现
        //        boolean isPaired =false;
//        switch(close){
//              case ')':
//                  if (open=='('){
//                      isPaired= true;
//                  }else
//                      isPaired=  false;
//                  break;
//              case '}':
//                  if (open=='}'){
//                      isPaired= true;
//                  }else
//                      isPaired=  false;
//                  break;
//              case ']':
//                  if (open==']'){
//                      isPaired= true;
//                  }else
//                      isPaired=  false;
//                  break;
//          }
//          return isPaired;
       //第二版实现
       return (open == '(' && close == ')')||
               (open == '{'&& close == '}')||
               (open == '['&& close == ']');

    }
   public String convertToPostifx(String infix){//中缀表达式转换成后缀
      StackInterface<Character> operatorStack =new OurStack();
      String postFix =new String();
      int index=0;

      while(infix.length()!=0){
          char nextCharacter= infix.charAt(index);
         switch (nextCharacter){
             default:
                 operatorStack.push(nextCharacter);
                 break;
             case '^':
                 operatorStack.push(nextCharacter);
                 break;
             case '+': case '-': case '*': case '/':
                while (!operatorStack.isEmpty() &&
                        checkPriority(nextCharacter) <=
                                checkPriority(operatorStack.peek())//不是我等待的运算结果，前面的符号开始运算
                       ){//如果这运算级比我高，那这个运算符所代表的操作结果一定是我需要等待的结果，我不能贸然开始运算，入栈
                          infix += operatorStack.pop();

                         }
                 operatorStack.push(nextCharacter);
                break;
             case ')':
                char topCharacter=operatorStack.pop();
                 while (topCharacter != '('){
                      infix += operatorStack.pop();
                      topCharacter =operatorStack.pop();
                 }

         }
      }
      return  postFix;
    }
   public static  int checkPriority(char character){
        int  priority=0;//默认为零，没有权限。但是一个忌讳就是用函数返回值来表示问题
        //中间是对priority的操作过程
        return priority;
   }
  //计算一个后缀表达式的数值
   public  static  void evaluatePostFix(String postFix){
      StackInterface<Character> valueStack =new OurStack();
      int index =0;
      while (index < postFix.length()){
          char nextCharacter = postFix.charAt(index);
          switch (nextCharacter){
              //当遇到操作数
                  case '0': case '1': case '2': case '3':
                  valueStack.push(nextCharacter);
                  index++;
                  break;
                  case '+': case '-': case '*': case '/': case '^':
                  char oprandTwo =valueStack.pop();
                  char oprandOne =valueStack.pop();
                  valueStack.push(evaluate(oprandOne,nextCharacter,oprandTwo));
                  index++;
                  break;
                  default:
                      break;
          }
      }
      int result =Character.getNumericValue(valueStack.pop());
      System.out.println("result is"+result);
    }

    private static Character evaluate(char oprandOne, char nextCharacter, char oprandTwo) {
         int result =0;
        int oprandOneInt =CharToInt(oprandOne);
         int oprandTwoInt = CharToInt(oprandTwo);
        switch(nextCharacter){
                      case '+':
                         result= oprandOneInt+oprandTwoInt;
                          break;
                      case '-':
                          result =oprandOneInt-oprandTwoInt;
                          break;
                      case '*':
                          result =oprandOneInt*oprandTwoInt;
                          break;
                       case '/':
                           result =oprandOneInt/oprandTwoInt;
                           break;
                      case '^':
                          result =oprandOneInt^oprandTwoInt;
                          break;
       }

       return IntToChar(result);
    }

    private static int CharToInt(char oprand) {
        return  Character.getNumericValue(oprand);

    }
    private static  char IntToChar(int result){
        return  String.valueOf(result).charAt(0);
    }
}
