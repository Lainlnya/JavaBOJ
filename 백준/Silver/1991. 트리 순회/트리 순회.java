import java.util.*;
import java.io.*;

public class Main {
    public static class Node {
        String value;
        Node left;
        Node right;
        Node(String value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node find(String value) {
            if (this.value.equals(value)) return this;

            if (left != null) {
                Node foundNode = left.find(value);
                if (foundNode != null) return foundNode;
            }

            if (right != null) {
                Node foundNode = right.find(value);
                if (foundNode != null) return foundNode;
            }

            return null;
        }
    }
    public static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public static void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value);
            inOrder(node.right);
        }
    }
    public static void afterOrder(Node node) {
        if (node != null) {
            afterOrder(node.left);
            afterOrder(node.right);
            System.out.print(node.value);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nums = Integer.parseInt(br.readLine());

        StringTokenizer st;

        // 우선 루트 입력
        st = new StringTokenizer(br.readLine());
        Node root = new Node(st.nextToken());
        String left = st.nextToken();
        if (!left.equals(".")) root.left = new Node(left);
        String right = st.nextToken();
        if (!right.equals(".")) root.right = new Node(right);

        // 나머지 입력
        for (int i = 1; i < nums; i++) {
            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();

            Node node = root.find(value);
            String leftN = st.nextToken();
            if (!leftN.equals(".")) node.left = new Node(leftN);
            String rightN = st.nextToken();
            if (!rightN.equals(".")) node.right = new Node(rightN);
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        afterOrder(root);
    }
}
