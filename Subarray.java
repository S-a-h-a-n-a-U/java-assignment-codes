public class Subarray{
    public static void main(String[] args){
        try{
            int[] arr={1,2,3,7,5};
            int sum=12;
            for(int i=0;i<arr.length;i++){
                int current=0;
                for(int j=i;j<arr.length;j++){
                    current+=arr[j];
                    if(current==sum){
                        System.out.println("subarray found from index "+i+" to "+j);
                        return;
                    }
                }
            }
            System.out.println("no subarray found");
        }
        catch(Exception e){
            System.out.println("unexpected error occurred: "+e.getMessage());
        }
    }
}
