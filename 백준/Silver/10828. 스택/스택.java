import java.io.*;
import java.util.*;

// 스택 기본 문제
public class Main {
    static ArrayList<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열을 쪼개기 위한 StringTokenizer
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        stack = new ArrayList<>();

        int totalN = Integer.parseInt(br.readLine());

        for (int i = 0; i < totalN; i++) {
            st = new StringTokenizer(br.readLine());
            String input =  st.nextToken();

            switch (input) {
                // push X: 정수 X를 스택에 넣는 연산
                case "push":
                    stack.add(0, Integer.parseInt(st.nextToken()));
                    break;

                // pop: 가장 위에 있는 숫자를 뺴고 출력, 바어있다면 -1 리턴
                case "pop":
                    sb.append((stack.isEmpty() ? -1 : stack.remove(0)) + "\n");
                    break;

                // size: 스택에 들어있는 정수의 개수
                case "size" :
                    sb.append(stack.size() + "\n");
                    break;

                // empty: 스택이 비어있으면 1 아니면 0
                case "empty":
                    sb.append((stack.isEmpty() ? 1 : 0) + "\n");
                    break;

                // top: 스택의 가장 위에 있는 정수 출력, 없으면 -1 리턴
                case "top":
                    sb.append((stack.isEmpty() ? -1 : stack.get(0)) + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
