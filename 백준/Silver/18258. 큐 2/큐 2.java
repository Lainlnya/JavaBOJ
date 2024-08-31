import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int total = Integer.parseInt(br.readLine());
         Deque<Integer> queue = new ArrayDeque<>();
         StringBuilder sb = new StringBuilder();

         StringTokenizer st;
         for (int i = 0; i < total; i++) {
             st = new StringTokenizer(br.readLine());
             if (st.countTokens() == 1) {
                 String gogo = st.nextToken();

                 switch (gogo) {
                     case "front" : {
                         if (queue.isEmpty())
                             sb.append(-1 + "\n");
                         else sb.append(queue.peekFirst() + "\n");
                         break;
                     }

                     case "back" : {
                         if (queue.isEmpty())
                             sb.append(-1 + "\n");
                         else sb.append(queue.peekLast() + "\n");
                         break;
                     }

                     case "size" :
                         sb.append(queue.size() + "\n");
                        break;

                     case "empty" : {
                         if (queue.isEmpty()) sb.append(1 + "\n");
                         else sb.append(0 + "\n");
                         break;
                     }

                     case "pop" : {
                         if (queue.isEmpty())
                             sb.append(-1 + "\n");
                         else sb.append(queue.pollFirst() + "\n");
                         break;
                     }
                 }
             } else {
                 String gogo = st.nextToken();
                 int num = Integer.parseInt(st.nextToken());

                 if (gogo.equals("push")) {
                     queue.add(num);
                 }

             }
         }

         System.out.println(sb);
    }
}
