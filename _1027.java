import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Total = Integer.parseInt(br.readLine());
        int[] building = new int[Total];
        int[] answer = new int[Total];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 전체 building 배열에 저장
        for (int i = 0; i < Total; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < Total - 1; i++) { // 15
        	answer[i]++;
        	answer[i + 1]++;
        	
        	double slope = building[i + 1] - building[i];
        	
        	for (int j = i + 2; j < Total; j++) {
        		double nextSlope = (double) (building[j] - building[i]) / (j - i);
        		
        		if (nextSlope > slope) {
        			slope = nextSlope;
        			answer[i]++;
        			answer[j]++;
        		}
        	}
        }
        
        // 가장 max을 찾기 위한 변수 선언
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < answer.length; i++) {
        	if (max < Math.max(answer[i], max)) {
        		max = answer[i];
        	}
        }
        
        System.out.println(max);
        
    }
}
