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
            System.out.print("Enter target sum: ");
            BigDecimal target=sc.nextBigDecimal();
            boolean found=false;
            for(int i=0;i<n;i++){
                BigDecimal sum=BigDecimal.ZERO;
                for(int j=i;j<n;j++){
                    sum=sum.add(arr[j]);
                    if(sum.compareTo(target)==0){
                        found=true;
                        System.out.print("Subarray found from index "+i+" to "+j+" : ");
                        for(int k=i;k<=j;k++)
                            System.out.print(arr[k].stripTrailingZeros().toPlainString()+" ");
                        System.out.println();
                    }
                }
            }
            if(!found)
              System.out.println("No subarray found.");
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
