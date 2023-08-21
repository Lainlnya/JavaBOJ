import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1918 {
        public static class Stack {
            List<String> array = new ArrayList<>();

            // 스택에 넣어줌
            public void push(String st) {
                array.add(st);
            }

            // 스택에서 마지막 빼줌
            public String pop() {
                if (!array.isEmpty()) {
                    return array.remove(array.size() - 1);
                }
                return "";
            }

            // 가장 위의 값 반환
            public String peek() {
                return array.get(array.size() - 1);
            }

            // 크기 반환
            public int size() {
                return array.size();
            }

            // 비어있는지 아닌지 확인
            public boolean isEmpty() {
                return array.isEmpty();
            }
        }
        static int priority(String st) {
            switch (st) {
                case "*":
                case "/":
                    return 2;
                case "+":
                case "-":
                    return 1;
                default:
                    return 0;
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            for (int t = 0; t < 1; t++) { // 테케 10개
//                int num = sc.nextInt();
                String[] calcu = sc.next().split("");
                Stack stack = new Stack();
                String answer = "";

                for (int i = 0; i < calcu.length; i++) {
                    int priority = priority(calcu[i]); // 가장 처음 우선순위 기억
                    switch (calcu[i]) {
                        case "(":
                            stack.push(calcu[i]);
                            break;
                        case ")":
                            while(!stack.isEmpty() && !stack.peek().equals("(")) { // "("를 만날 때까지 빼주고
                            	answer += stack.pop();
                            }
                            stack.pop(); // 마지막 "("까지 빼줌
                            break;
                        case "*":
                        case "+":
                        case "-":
                        case "/":
                            while (!stack.isEmpty() && priority(stack.peek()) >= priority) { // 연산자이고 현재 우선순위가 높다면
                                answer += stack.pop();
                            }
                            stack.push(calcu[i]);
                            break;
                        default: // 피연산자는 더하기
                            answer += calcu[i];

                    }
                }
                while (!stack.isEmpty()) {
                    answer += stack.pop();
                }
                System.out.println(answer);
            }

        }
}
