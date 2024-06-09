import java.util.*;
import java.io.*;

public class Main {

    // 인덱스와 중요도를 저장하기 위한 Document 클래스
    static class Document {
        int index;
        int priority;
        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int totalN = Integer.parseInt(br.readLine());

        for (int i = 0; i < totalN; i++) {
            st = new StringTokenizer(br.readLine());
            int docuNum = Integer.parseInt(st.nextToken()); // 문서의 개수
            int quesNum = Integer.parseInt(st.nextToken()); // 몇 번째 인쇄 ?

            // ArrayDeque의 경우 요소를 순차적으로 추가하거나 제거할 때 성능적으로 LinkedList보다 유리함
            // LinkedList는 null을 허용하고, 리스트 중간에서의 삽입/삭제가 빈번할 경우 유리함
            Queue<Document> queue = new ArrayDeque<>();
            // 중요도 순서를 알기 위한 우선순위 큐
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());


            st = new StringTokenizer(br.readLine());
            // 큐와 우선순위 큐에 해당 데이터 저장
            for (int j = 0; j < docuNum; j++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Document(j, priority));
                pq.add(priority);
            }

            // 인쇄 순서
            int seq = 0;
            while (!queue.isEmpty()) {
                Document current = queue.poll();

                // 첫 요소의 우선 순위와 우선순위 큐 첫 요소가 같다면
                if (current.priority == pq.peek()) {
                    // 순서+
                    seq++;
                    // 우선순위에서도 빼기, 같은 요소가 들어있다 하더라도 우선순위 큐에도 같은 숫자가 여러 개 들어가있기 때문에 상관없다.
                    pq.poll();
                    if (current.index == quesNum) {
                        sb.append(seq + "\n");
                        break;
                    }
                } else {
                    queue.offer(current);
                }
            }
        }
        System.out.println(sb);
    }
}
