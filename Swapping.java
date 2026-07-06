interface Swap{
    void swap(int a,int b);
}
class Swapwithtemp implements Swap{
    public void swap(int a,int b){
        try{
            if(a==Integer.MAX_VALUE||b==Integer.MAX_VALUE){
                throw new ArithmeticException("value is too large.");
            }
            int temp=a;
            a=b;
            b=temp;
            System.out.println("swapping using temporary variable");
            System.out.println("a = "+a);
            System.out.println("b = "+b);
        }
        catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }
    }
}
class Swapwithouttemp implements Swap{
    public void swap(int a,int b){
        try{
            a=a+b;
            b=a-b;
            a=a-b;
            System.out.println("Swapping without temporary variable");
            System.out.println("a = "+a);
            System.out.println("b = "+b);
        }
        catch(ArithmeticException e){
            System.out.println("arithmetic Error : "+e.getMessage());
        }
        catch(Exception e){
            System.out.println("error : "+e.getMessage());
        }
    }
}
public class Swapping{
    public static void main(String[] args){
        try{
            Swap s1=new Swapwithtemp();
            s1.swap(10,20);
            System.out.println();
            Swap s2=new Swapwithouttemp();
            s2.swap(30,40);
        }
        catch(Exception e){
            System.out.println("Unexpected Error : "+e.getMessage());
        }
    }
}
