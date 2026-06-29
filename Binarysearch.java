public class Binarysearch {
    public static void main(String[] args) {

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
            }
            else if (arr[mid] < key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        if (found == -1) {
            System.out.println("Element not found");
        }
        else {
            System.out.println("Element found at index " + found);
        }
    }
}