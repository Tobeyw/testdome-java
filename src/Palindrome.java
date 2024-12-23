public class Palindrome {
    public static boolean isPalindrome(String word) {
       // throw new UnsupportedOperationException("Waiting to be implemented.");
      byte[] chars =  word.toLowerCase().getBytes();
        for (int i = 0; i < chars.length; i++) {
           
                if (chars[i] !=chars[chars.length-i-1]){
                   
                    return false;
                }
           
        }

        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}