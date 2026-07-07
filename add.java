import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
public class AddTwoNumbers{
    static Map<String,Integer> small=new HashMap<>();
    static Map<String,Long> scale=new HashMap<>();
    static{
        small.put("zero",0);
        small.put("one",1);
        small.put("two",2);
        small.put("three",3);
        small.put("four",4);
        small.put("five",5);
        small.put("six",6);
        small.put("seven",7);
        small.put("eight",8);
        small.put("nine",9);
        small.put("ten",10);
        small.put("eleven",11);
        small.put("twelve",12);
        small.put("thirteen",13);
        small.put("fourteen",14);
        small.put("fifteen",15);
        small.put("sixteen",16);
        small.put("seventeen",17);
        small.put("eighteen",18);
        small.put("nineteen",19);
        small.put("twenty",20);
        small.put("thirty",30);
        small.put("forty",40);
        small.put("fifty",50);
        small.put("sixty",60);
        small.put("seventy",70);
        small.put("eighty",80);
        small.put("ninety",90);
        scale.put("hundred",100L);
        scale.put("thousand",1000L);
        scale.put("million",1000000L);
        scale.put("billion",1000000000L);
        scale.put("trillion",1000000000000L);
        scale.put("lakh",100000L);
        scale.put("crore",10000000L);
    }
    static BigDecimal parseNumber(String input){
        input=input.trim().toLowerCase();
        try{
            return new BigDecimal(input);
        }
        catch(Exception e){}
        boolean negative=false;
        if(input.startsWith("negative ")){
            negative=true;
            input=input.substring(9);
        }
        if(input.startsWith("minus ")){
            negative=true;
            input=input.substring(6);
        }
        input=input.replaceAll(" and "," ");
        String[] parts=input.split(" point ");
        BigInteger integer=parseInteger(parts[0]);
        BigDecimal result=new BigDecimal(integer);
        if(parts.length==2){
            StringBuilder dec=new StringBuilder();
            for(String s:parts[1].split(" ")){
                if(!small.containsKey(s) || small.get(s)>9)
                    throw new NumberFormatException("Invalid decimal part");
                dec.append(small.get(s));
            }
            result=result.add(new BigDecimal("0."+dec));
        }
        if(negative)
            result=result.negate();
        return result;
    }
    static BigInteger parseInteger(String text){
        BigInteger total=BigInteger.ZERO;
        BigInteger current=BigInteger.ZERO;
        for(String word:text.split("\\s+")){
            if(word.isEmpty())
                continue;
            if(small.containsKey(word)){
                current=current.add(BigInteger.valueOf(small.get(word)));
            }
            else if(word.equals("hundred")){
                if(current.equals(BigInteger.ZERO))
                    current=BigInteger.ONE;
                current=current.multiply(BigInteger.valueOf(100));
            }
            else if(scale.containsKey(word)){
                BigInteger mult=BigInteger.valueOf(scale.get(word));
                if(word.equals("hundred"))
                    continue;
                if(current.equals(BigInteger.ZERO))
                    current=BigInteger.ONE;
                total=total.add(current.multiply(mult));
                current=BigInteger.ZERO;
            }
            else{
                throw new NumberFormatException("Invalid word: "+word);
            }
        }
        return total.add(current);
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
            BigDecimal n1=parseNumber(s1);
            BigDecimal n2=parseNumber(s2);
            BigDecimal sum=n1.add(n2);
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
            System.out.println("System memory is insufficient.");
        }
        catch(Exception e){
            System.out.println("Unexpected error: "+e.getMessage());
        }
        finally{
            sc.close();
        }
    }
}
