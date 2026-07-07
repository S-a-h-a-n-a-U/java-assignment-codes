import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.math.BigDecimal;
public class Main {
    interface SwapOperation{
        void swap(NumberPair pair);
    }
    static class NumberPair{
        BigDecimal first;
        BigDecimal second;
        NumberPair(BigDecimal first,BigDecimal second){
            this.first=first;
            this.second=second;
        }
    }
    static class SwapUsingTemp implements SwapOperation{
        public void swap(NumberPair pair){
            BigDecimal temp=pair.first;
            pair.first=pair.second;
            pair.second=temp;
        }
    }
    static class SwapWithoutTemp implements SwapOperation{
        public void swap(NumberPair pair){
            pair.first=pair.first.add(pair.second);
            pair.second=pair.first.subtract(pair.second);
            pair.first=pair.first.subtract(pair.second);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        try{
            System.out.print("Enter first number: ");
            BigDecimal first=sc.nextBigDecimal();
            System.out.print("Enter second number: ");
            BigDecimal second=sc.nextBigDecimal();
            NumberPair pair1=new NumberPair(first,second);
            SwapOperation obj1=new SwapUsingTemp();
            obj1.swap(pair1);
            System.out.println("\nAfter Swapping Using Temp Variable");
            System.out.println("First Number : "+pair1.first.stripTrailingZeros().toPlainString());
            System.out.println("Second Number : "+pair1.second.stripTrailingZeros().toPlainString());
            NumberPair pair2=new NumberPair(first,second);
            SwapOperation obj2=new SwapWithoutTemp();
            obj2.swap(pair2);
            System.out.println("\nAfter Swapping Without Temp Variable");
            System.out.println("First Number : "+pair2.first.stripTrailingZeros().toPlainString());
            System.out.println("Second Number : "+pair2.second.stripTrailingZeros().toPlainString());

        }
        catch(InputMismatchException e){
            System.out.println("Invalid input. Please enter a valid number.");
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
