import java.util.*;
class add {
    public static void main(String[] args) {
        System.out.println("Enter numbers to be added");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("The sum of number are: " +(a + b));
        System.out.println("The sum is: " +(double)(a + b));
        System.out.println("The sum is: " +(float)(a + b));
        System.out.println("Character value of a: " +(char)a);
        System.out.println("String value of sum: " + String.valueOf(a + b));
sc.close();
    }
}