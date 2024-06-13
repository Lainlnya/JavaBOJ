import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> success = new LinkedList<>();
        
        int gone = 0; // 지나간 트럭 개수
        int time = 0; // 걸리는 시간
        int truck_weight = 0;
        
        // 이미 지나간 트럭과 기다리는 트럭 배열의 길이가 같지 않을 때까지
        while (success.size() != truck_weights.length) {
            // 큐 크기가 다리 길이보다 적을 때
            if (queue.size() < bridge_length) {
                // 대기열에서 하나 빼서 옮기고, 다음 타겟으로 이동
                if (gone < truck_weights.length &&
                    (truck_weight + truck_weights[gone] <= weight)
                   ) {
                    truck_weight += truck_weights[gone];
                    queue.offer(truck_weights[gone]);
                    gone++;
                } else {
                    queue.offer(0);
                }
            } else {
                // queue에서 가장 앞에 있는 요소를 빼고, 다리 위의 무게에서도 빼주기
                int pass = queue.poll();
                truck_weight -= pass;
                if (pass != 0) success.offer(pass);
                
                // 대기열에서 하나 빼서 옮기고, 다음 타겟으로 이동
                if (gone < truck_weights.length &&
                    (truck_weight + truck_weights[gone] <= weight)
                   ) {
                    truck_weight += truck_weights[gone];
                    queue.offer(truck_weights[gone]);
                    gone++;
                } else {
                    queue.offer(0);
                }
            }
            time++;
        }
        
        return time;
    }
}