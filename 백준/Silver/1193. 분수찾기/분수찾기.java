import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = Integer.parseInt(br.readLine());

        int son = 1;
        int mom = 1;
        boolean isIncreasing = true;

        for (int i = 2; i <= answer; i++) {
            if (isIncreasing) {
                if (son == 1) {
                    isIncreasing = false;
                    mom++;
                } else {
                    son--;
                    mom++;
                }
            } else {
                if (mom == 1) {
                    isIncreasing = true;
                    son++;
                } else {
                    son++;
                    mom--;
                }
            }
        }

        System.out.println(son + "/" + mom);

    }
}