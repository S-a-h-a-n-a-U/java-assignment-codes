import java.util.*;
public class anagram {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1st string");
        String s1=sc.next();
 System.out.println("Enter 2nd string");
 String s2=sc.next();
 char[] a=s1.toCharArray();
 char[] b=s2.toCharArray();
 Arrays.sort(a);
 Arrays.sort(b);
 {if(Arrays.equals(a,b))
 System.out.println("Anagram");
 else
  System.out.println(" Not Anagram");}
sc.close();
    }
    
}
