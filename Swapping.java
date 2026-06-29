interface Swap {
    void swap(int a, int b);
}
class Swapwithtemp implements Swap {
    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After Swap:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
class Swapwithouttemp implements Swap {
    public void swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
       System.out.println("After Swap:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
public class Swapping {
public static void main(String[] args) {
 Swap s1 = new Swapwithtemp();
        s1.swap(10, 20);
   Swap s2 = new Swapwithouttemp();
        s2.swap(30, 40);
    }
}