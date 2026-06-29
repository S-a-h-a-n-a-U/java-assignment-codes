    import java.util.Scanner;
public class checkonlyoddoreven {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n=sc.nextInt();
        int even=0,odd=0;
        System.out.println("Enter the elements:");
        for (int i=0; i < n; i++) {
            int ele=sc.nextInt();
            if (ele%2==0)
                even++;
            else
                odd++;
        }
        if (even==n)
            System.out.println("Only even numbers");
        else if (odd==n)
            System.out.println("Only odd numbers");
        else
            System.out.println("Contains both odd and even numbers");
        sc.close();
    }
}