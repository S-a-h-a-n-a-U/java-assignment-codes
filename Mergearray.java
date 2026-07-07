import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.math.BigDecimal;
public class Main{
    static int nextGap(int gap){
        if(gap<=1)
            return 0;
        return (gap/2)+(gap%2);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        try{
            System.out.print("Enter size of first array: ");
            int n=sc.nextInt();
            System.out.print("Enter size of second array: ");
            int m=sc.nextInt();
            if(n<=0 || m<=0){
                System.out.println("Invalid array size.");
                return;
            }
            BigDecimal[] arr1=new BigDecimal[n];
            BigDecimal[] arr2=new BigDecimal[m];
            System.out.println("Enter "+n+" sorted elements of first array:");
            for(int i=0;i<n;i++)
                arr1[i]=sc.nextBigDecimal();
            System.out.println("Enter "+m+" sorted elements of second array:");
            for(int i=0;i<m;i++)
                arr2[i]=sc.nextBigDecimal();
            for(int i=0;i<n-1;i++){
                if(arr1[i].compareTo(arr1[i+1])>0){
                    System.out.println("First array is not sorted.");
                    return;
                }
            }
            for(int i=0;i<m-1;i++){
                if(arr2[i].compareTo(arr2[i+1])>0){
                    System.out.println("Second array is not sorted.");
                    return;
                }
            }
            int gap=n+m;
            for(gap=nextGap(gap);gap>0;gap=nextGap(gap)){
                int i,j;
                for(i=0;i+gap<n;i++){
                    if(arr1[i].compareTo(arr1[i+gap])>0){
                        BigDecimal temp=arr1[i];
                        arr1[i]=arr1[i+gap];
                        arr1[i+gap]=temp;
                    }
                }
                j=(gap>n)?gap-n:0;
                while(i<n && j<m){
                    if(arr1[i].compareTo(arr2[j])>0){
                        BigDecimal temp=arr1[i];
                        arr1[i]=arr2[j];
                        arr2[j]=temp;
                    }
                    i++;
                    j++;
                }
                if(j<m){
                    for(j=0;j+gap<m;j++){
                        if(arr2[j].compareTo(arr2[j+gap])>0){
                            BigDecimal temp=arr2[j];
                            arr2[j]=arr2[j+gap];
                            arr2[j+gap]=temp;
                        }
                    }
                }
            }
            System.out.println("\nFirst Array");
            for(BigDecimal x:arr1)
                System.out.print(x.stripTrailingZeros().toPlainString()+" ");
            System.out.println("\n\nSecond Array");
            for(BigDecimal x:arr2)
                System.out.print(x.stripTrailingZeros().toPlainString()+" ");
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
