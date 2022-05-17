public  class HashCodeLearn {
    public static void main(String[] args){
       System.out.println("Java :"+getHashCodeOfString("Java",31));
    }
    private static int getHashCodeOfString(String specifiedString,int g){
        int hashCode = 0;
        int n =specifiedString.length();
        for (int i=0;i<n;i++){
             hashCode=g * hashCode+specifiedString.charAt(i)+hashCode;
        }
        return hashCode;
    }
}
