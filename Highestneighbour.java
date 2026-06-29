public class Highestneighbour {
    public static void main(String[] args) {
        int[] arr = {2,4,9,6,8,27};
        for(int i=1;i< arr.length-1;i++){
            if(arr[i]>arr[i-1]&& arr[i]>arr[i+1]){
                System.out.println("highest element in an array which is greater than its Neighbours is :"+arr[i]);
          break;  
        }
        }
    }
    
}
