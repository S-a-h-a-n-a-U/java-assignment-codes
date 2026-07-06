import java.util.Arrays;
public class Mergearray{
    public static void main(String[] args){
        try{
            int[] arr1={1,5,9,10,15,20};
            int[] arr2={2,3,8,13};
            for(int i=arr2.length-1;i>=0;i--){
                int last=arr1[arr1.length-1];
                int j;
                for(j=arr1.length-2;j>=0&&arr1[j]>arr2[i];j--){
                    arr1[j+1]=arr1[j];
                }
                if(j!=arr1.length-2||last>arr2[i]){
                    arr1[j+1]=arr2[i];
                    arr2[i]=last;
                }
            }
            System.out.println("array 1: "+Arrays.toString(arr1));
            System.out.println("array 2: "+Arrays.toString(arr2));
        }catch(Exception e){
            System.out.println("exception: "+e);
        }
    }
}
