import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int i = 0;

        while (total > 0) {

            if (total >= 3) {
                total -= 3;
            } else {
                total -= 1;
            }

            i++;
        }

        if ((i - 1) == 0 || (i - 1) % 2 == 0) {
            System.out.println("SK");
        } else System.out.println("CY");
    }
}
