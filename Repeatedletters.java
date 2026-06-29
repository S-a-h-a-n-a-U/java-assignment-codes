public class Repeatedletters {
    public static void main(String[] args) {

        String str = "Sahana";
        int[] count = new int[256];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (count[ch] > 1) {
                System.out.println(ch + " = " + count[ch]);
                count[ch] = 0;
            }
        }
    }
}
