import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.math.BigDecimal;
public class PeakElement{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            System.out.print("Enter array size: ");
            int n=sc.nextInt();
            if (n<=0) {
                System.out.println("Invalid array size.");
                return;
            }
            BigDecimal[] arr=new BigDecimal[n];
            System.out.println("Enter " +n + "elements:");
            for(int i=0; i<n;i++) {
                arr[i]=sc.nextBigDecimal();
            }
            if(n==1) {
                System.out.println("Peak Element: " +arr[0].stripTrailingZeros().toPlainString() +" at index 0");
                return;
            }
            BigDecimal highestPeak=null;
            int peakIndex=-1;
            for(int i=0;i<n;i++){
                boolean isPeak;
                if(i==0) {
                    isPeak=arr[i].compareTo(arr[i + 1]) > 0;
                } else if(i==n-1) {
                    isPeak=arr[i].compareTo(arr[i - 1]) > 0;
                } else{
                    isPeak=arr[i].compareTo(arr[i - 1]) > 0 &&
                             arr[i].compareTo(arr[i + 1]) > 0;
                }
                if(isPeak) {
                    if(highestPeak==null ||arr[i].compareTo(highestPeak) > 0) {
                        highestPeak = arr[i];
                        peakIndex = i;
                    }
                }
            }
            if(peakIndex==-1) {
                System.out.println("No peak element found.");
            } else{
                System.out.println("Highest Peak Element: " +
                        highestPeak.stripTrailingZeros().toPlainString() +
                        " at index " + peakIndex);
            }
        } catch(InputMismatchException e) {
            System.out.println("Invalid input.");
        } catch(NoSuchElementException e) {
            System.out.println("No input provided.");
        } catch(IllegalStateException e) {
            System.out.println("Scanner is closed.");
        } catch(OutOfMemoryError e) {
            System.out.println("System is out of memory.");
        } catch(Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally{
            sc.close();
        }
    }
}
