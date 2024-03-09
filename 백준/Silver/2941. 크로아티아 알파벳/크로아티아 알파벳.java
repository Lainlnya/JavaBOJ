import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> alpha = Arrays.asList("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String croa = br.readLine();

        for (int i = 0; i < alpha.size(); i++) {
            if (croa.contains(alpha.get(i))) {
                croa = croa.replaceAll(alpha.get(i), "+");
            }
        }
        System.out.println(croa.length());
    }
}
