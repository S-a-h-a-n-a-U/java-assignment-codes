import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.LinkedHashMap;
import java.util.Map;
public class RepeatedLetters{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        try{
            System.out.print("Enter a string: ");
            String str=sc.nextLine();
            if(str.trim().isEmpty()){
                System.out.println("Input cannot be empty.");
                return;
            }
            str=str.toLowerCase();
            LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
            for(char ch:str.toCharArray()){
                if(ch==' ')
                    continue;
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            boolean found=false;
            System.out.println("Repeated characters and their occurrences:");
            for(Map.Entry<Character,Integer> entry:map.entrySet()){
                if(entry.getValue()>1){
                    System.out.println(entry.getKey()+" : "+entry.getValue());
                    found=true;
                }
            }
            if(!found)
                System.out.println("No repeated characters found.");
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
