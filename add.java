import java.util.*;
import java.math.*;

public class AddTwoNumbers {

    static Map<String,Integer> map=new HashMap<>();

    static{
        map.put("zero",0);      map.put("one",1);
        map.put("two",2);       map.put("three",3);
        map.put("four",4);      map.put("five",5);
        map.put("six",6);       map.put("seven",7);
        map.put("eight",8);     map.put("nine",9);
        map.put("ten",10);      map.put("eleven",11);
        map.put("twelve",12);   map.put("thirteen",13);
        map.put("fourteen",14); map.put("fifteen",15);
        map.put("sixteen",16);  map.put("seventeen",17);
        map.put("eighteen",18); map.put("nineteen",19);
        map.put("twenty",20);   map.put("thirty",30);
        map.put("forty",40);    map.put("fifty",50);
        map.put("sixty",60);    map.put("seventy",70);
        map.put("eighty",80);   map.put("ninety",90);
    }

    static BigDecimal parse(String input){

        input=input.trim().toLowerCase();

        try{
            return new BigDecimal(input);
        }
        catch(Exception e){}

        boolean neg=false;

        if(input.startsWith("minus ")){
            neg=true;
            input=input.substring(6);
        }
        else if(input.startsWith("negative ")){
            neg=true;
            input=input.substring(9);
        }

        String[] words=input.split("\\s+");

        long total=0;
        long current=0;

        for(String w:words){

            if(map.containsKey(w)){

                int val=map.get(w);

                if(val>=20)
                    current+=val;
                else
                    current+=val;
            }

            else if(w.equals("hundred")){

                if(current==0)
                    current=1;

                current*=100;
            }

            else if(w.equals("thousand")){

                total+=current*1000;
                current=0;
            }

            else if(w.equals("lakh")){

                total+=current*100000;
                current=0;
            }

            else if(w.equals("crore")){

                total+=current*10000000;
                current=0;
            }

            else{

                throw new NumberFormatException("Invalid number word");
            }
        }

        total+=current;

        BigDecimal ans=BigDecimal.valueOf(total);

        if(neg)
            ans=ans.negate();

        return ans;
    }
        public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        try{

            System.out.print("Enter first number: ");
            String s1=sc.nextLine();

            if(s1.trim().isEmpty()){
                System.out.println("First number cannot be empty.");
                return;
            }

            System.out.print("Enter second number: ");
            String s2=sc.nextLine();

            if(s2.trim().isEmpty()){
                System.out.println("Second number cannot be empty.");
                return;
            }

            BigDecimal num1=parse(s1);
            BigDecimal num2=parse(s2);

            BigDecimal sum=num1.add(num2);

            System.out.println("Sum = "+sum.stripTrailingZeros().toPlainString());

        }
        catch(NumberFormatException e){
            System.out.println("Invalid number or number words.");
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
