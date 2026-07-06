import java.util.*;
public class anagram{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        try{
            System.out.println("enter the first string:");
            String s1=sc.next();
            System.out.println("enter the second string:");
            String s2=sc.next();
            char[] a=s1.toLowerCase().toCharArray();
            char[] b=s2.toLowerCase().toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            if(Arrays.equals(a,b)){
                System.out.println("he given strings are Anagrams.");
            }
            else{
                System.out.println("the given strings are not Anagrams.");
            }
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        finally{
            sc.close();
        }
    }
}
