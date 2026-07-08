import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.math.BigDecimal;

public class Main{

    static int nextGap(int gap){
        if(gap<=1)
            return 0;
        return gap/2+gap%2;
    }

    static void swap(BigDecimal[] a,int i,BigDecimal[] b,int j){
        BigDecimal temp=a[i];
        a[i]=b[j];
        b[j]=temp;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        try{

            System.out.print("Enter size of first array: ");
            int n=sc.nextInt();

            System.out.print("Enter size of second array: ");
            int m=sc.nextInt();

            if(n<=0||m<=0){
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

            for(int gap=nextGap(n+m);gap>0;gap=nextGap(gap)){

                int i,j;

                for(i=0;i+gap<n;i++){
                    if(arr1[i].compareTo(arr1[i+gap])>0)
                        swap(arr1,i,arr1,i+gap);
                }

                j=gap>n?gap-n:0;

                while(i<n&&j<m){
                    if(arr1[i].compareTo(arr2[j])>0)
                        swap(arr1,i,arr2,j);
                    i++;
                    j++;
                }

                if(gap<m){
                    for(j=0;j+gap<m;j++){
                        if(arr2[j].compareTo(arr2[j+gap])>0)
                            swap(arr2,j,arr2,j+gap);
                    }
                }
            }

            System.out.println("\nFirst Array:");
            for(BigDecimal x:arr1)
                System.out.print(x.stripTrailingZeros().toPlainString()+" ");

            System.out.println("\n\nSecond Array:");
            for(BigDecimal x:arr2)
                System.out.print(x.stripTrailingZeros().toPlainString()+" ");

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
