public class Highestneighbour{
    public static void main(String[] args){
        try {
            int[] arr={2,4,9,6,8,27};
            boolean found=false;
            for(int i=1;i<arr.length-1;i++){
                if(arr[i]>arr[i - 1]&&arr[i]>arr[i + 1]){
                    System.out.println("Highest element in the array which is greater than its neighbours is: "+arr[i]);
                    found=true;
                    break;
                }
            }
            if(!found){
                System.out.println("no element is greater than both of its neighbours.");
            }
        } 
        catch(NullPointerException e){
            System.out.println("error: Array is null.");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("error: Array index is out of bounds.");
        } 
        catch (Exception e){
            System.out.println("unexpected error occurred: "+e.getMessage());
        }
    }
}
