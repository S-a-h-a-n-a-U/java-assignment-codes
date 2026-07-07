import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;
public class AnagramCheck{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        try{
            System.out.print("enter first string: ");
            String str1=sc.nextLine();
            System.out.print("enter second string: ");
            String str2=sc.nextLine();
            if(str1.trim().isEmpty() || str2.trim().isEmpty()){
                System.out.println("Input cant be empty.");
                return;
            }
            str1=str1.toLowerCase().replaceAll("[^a-z0-9]","");
            str2=str2.toLowerCase().replaceAll("[^a-z0-9]","");
            if(str1.length()!=str2.length()){
                System.out.println("strings are not anagrams.");
                return;
            }
            char[] a=str1.toCharArray();
            char[] b=str2.toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            if(Arrays.equals(a,b))
                System.out.println("Strings are anagrams.");
            else
                System.out.println("Strings are not anagrams.");
        }
        catch(NoSuchElementException e){
            System.out.println("No input provided.");
        }
        catch(IllegalStateException e){
            System.out.println("Scanner is closed.");
        }
        catch(OutOfMemoryError e){
            System.out.println("System is out of memory.");
        }
        catch(Exception e){
            System.out.println("Unexpected error: "+e.getMessage());
        }
        finally{
            sc.close();
        }
    }
}
