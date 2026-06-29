public class Subarray {
    public static void main(String[] args) {
        int[] arr={1,2,3,7,5};
       int  sum=12;
        for(int i=1;i<arr.length-1;i++){
            int current=0;
            
                for(int j=1;j<arr.length;j++){
                current+=arr[j];
                if(current==sum){
                    System.out.println("Subarray is from:"+i+"to"+j);
                    return;
                }
            }
        }
        System.out.println("No subarray found");
    }
    
}
