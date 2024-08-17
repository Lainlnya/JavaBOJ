import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("\\d+|[+\\-]");
        Matcher matcher = pattern.matcher(br.readLine());

        ArrayList<String> parsing = new ArrayList<>();

        while(matcher.find()) {
            parsing.add(matcher.group());
        }

        ArrayList<Integer> words = new ArrayList<>();

        for (int i = 0; i < parsing.size(); i++) {
            if (parsing.get(i).equals("+")) {
                words.add(words.remove(words.size() - 1) + Integer.parseInt(parsing.get(i + 1)));
                i++;
            } else if (parsing.get(i).equals("-")) {

            } else {
                words.add(Integer.parseInt(parsing.get(i)));
            }
        }

        int answer = words.get(0);

        for (int i = 1; i < words.size(); i++) {
            answer -= words.get(i);
        }

        System.out.println(answer);
    }
}
