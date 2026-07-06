public class Binarysearch {
    public static void main(String[] args) {
        try {
            int[] arr = {2, 4, 6, 8, 10, 12, 14};
            int key = 10;
            int low = 0;
            int high = arr.length - 1;
            int found = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == key) {
                    found = mid;
                    break;
                } else if (arr[mid] < key) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                    }}
            if (found == -1) {
                System.out.println("element not found");
            } else {
                System.out.println("element found at index " + found);
            }}
          catch (NullPointerException e) {
                System.out.println("Error: Array is null.");}
         catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index is out of bounds.");}
        catch (Exception e) {
            System.out.println("unexpected error occurred: " + e.getMessage());
        }
    }
}
