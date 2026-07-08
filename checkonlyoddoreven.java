import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.math.BigDecimal;
import java.math.BigInteger;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        try{
            System.out.print("Enter array size: ");
            int n=sc.nextInt();
            if(n<=0){
                System.out.println("Invalid array size.");
                return;
            }
            BigDecimal[] arr=new BigDecimal[n];
            int odd=0,even=0,decimal=0;
            System.out.println("Enter "+n+" numbers:");
            for(int i=0;i<n;i++){
                arr[i]=sc.nextBigDecimal();

                if(arr[i].stripTrailingZeros().scale()>0){
                    decimal++;
                }else{
                    BigInteger num=arr[i].toBigInteger();

                    if(num.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO))
                        even++;
                    else
                        odd++;
                }
            }
            if(decimal==n){
                System.out.println("The list contains only decimal numbers. Decimal numbers are neither odd nor even.");
            }
            else if(decimal>0){
                System.out.println("The list contains decimal numbers, which are neither odd nor even.");

                if(odd>0&&even>0)
                    System.out.println("Among the integer values, both odd and even numbers are present.");
                else if(odd>0)
                    System.out.println("Among the integer values, only odd numbers are present.");
                else if(even>0)
                    System.out.println("Among the integer values, only even numbers are present.");
            }
            else{
                if(even==n)
                    System.out.println("The list contains only even numbers.");
                else if(odd==n)
                    System.out.println("The list contains only odd numbers.");
                else
                    System.out.println("The list contains both odd and even numbers.");
            }
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input. Please enter valid numbers.");
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
