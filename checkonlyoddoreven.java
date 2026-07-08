import java.util.Scanner;
import java.util.NoSuchElementException;
import java.math.BigInteger;
public class OddEvenCheck{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        try{
            System.out.print("Enter array size: ");
            int n=sc.nextInt();
            if(n<=0){
                System.out.println("Invalid array size.");
                return;
            }
            int odd=0;
            int even=0;
            System.out.println("Enter "+n+" integers:");
            for(int i=0;i<n;i++){
                BigInteger num=sc.nextBigInteger();
                if(num.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO))
                    even++;
                else
                    odd++;
            }
            if(odd==n)
                System.out.println("The list contains only odd numbers.");
            else if(even==n)
                System.out.println("The list contains only even numbers.");
            else
                System.out.println("The list contains both odd and even numbers.");
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input. Please enter valid integers.");
        }
        catch(NoSuchElementException e){
            System.out.println("invalid input provided.");
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
