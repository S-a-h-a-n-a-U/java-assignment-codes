import java.util.*;
class add{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        try{
            System.out.println("Enter two numbers:");
            int a=sc.nextInt();
            int b=sc.nextInt();
            int sum=a+b;
            System.out.println("sum of the numbers is: "+sum);
            System.out.println("sum as double: "+(double)sum);
            System.out.println("sum as float: "+(float)sum);
            System.out.println("character value of a: "+(char)a);
            System.out.println("string value of sum: "+String.valueOf(sum));
        }
        catch(InputMismatchException e){
            System.out.println("enter only integer values.");
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        finally{
            sc.close();
        }
    }
}
