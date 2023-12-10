import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        stack = new Stack<Integer>();
        int inputN = sc.nextInt();
        int i = 0;
        while (i++ < inputN) {
            switch (sc.next()) {
                case "push":
                    stack.push(sc.nextInt());
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else sb.append(stack.peek() + "\n");
                    break;
                case "size" :
                    sb.append(stack.size() + "\n");
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else sb.append(stack.pop() + "\n");

                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        sb.append(1 + "\n");
                    } else sb.append(0 + "\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
