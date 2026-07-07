import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.math.BigDecimal;
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
            System.out.println("Enter "+n+" elements:");
            for(int i=0;i<n;i++)
                arr[i]=sc.nextBigDecimal();
            boolean found=false;
            if(n==1){
                System.out.println("Peak Element : "+arr[0].stripTrailingZeros().toPlainString());
                return;
            }
            if(arr[0].compareTo(arr[1])>0){
                System.out.println("Peak Element : "+arr[0].stripTrailingZeros().toPlainString()+" at index 0");
                found=true;
            }
            for(int i=1;i<n-1;i++){
                if(arr[i].compareTo(arr[i-1])>0 && arr[i].compareTo(arr[i+1])>0){
                    System.out.println("Peak Element : "+arr[i].stripTrailingZeros().toPlainString()+" at index "+i);
                    found=true;
                }
            }
            if(arr[n-1].compareTo(arr[n-2])>0){
                System.out.println("Peak Element : "+arr[n-1].stripTrailingZeros().toPlainString()+" at index "+(n-1));
                found=true;
            }
            if(!found)
                System.out.println("No peak element found.");
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input.");
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
            System.out.println("Unexpected error : "+e.getMessage());
        }
        finally{
            sc.close();
        }
    }
}
