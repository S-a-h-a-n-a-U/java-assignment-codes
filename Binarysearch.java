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
            System.out.println("Enter "+n+" sorted numbers:");
            for(int i=0;i<n;i++)
                arr[i]=sc.nextBigDecimal();
            for(int i=0;i<n-1;i++){
                if(arr[i].compareTo(arr[i+1])>0){
                    System.out.println("Array is not sorted. Binary Search requires a sorted array.");
                    return;
                }
            }
            System.out.print("Enter element to search: ");
            BigDecimal key=sc.nextBigDecimal();
            int low=0;
            int high=n-1;
            int found=-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(arr[mid].compareTo(key)==0){
                    found=mid;
                    break;
                }
                else if(arr[mid].compareTo(key)<0){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            if(found==-1){
                System.out.println("Element not found.");
            }
            else{
                int first=found;
                int last=found;
                while(first>0&&arr[first-1].compareTo(key)==0)
                    first--;
                while(last<n-1&&arr[last+1].compareTo(key)==0)
                    last++;
                System.out.print("Element found at index: ");
                for(int i=first;i<=last;i++)
                    System.out.print(i+" ");
                System.out.println();
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
            System.out.println("Array size is too large.");
        }
        catch(Exception e){
            System.out.println("Unexpected error: "+e.getMessage());
        }
        finally{
            sc.close();
        }
    }
}
