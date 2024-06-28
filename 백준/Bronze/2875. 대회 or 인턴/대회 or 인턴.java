import java.util.*;
import java.io.*;

public class Main {
    // 만들 수 있는 팀의 최대 개수
    // 남자가 여자보다 많다 ? => 여자 / 2 return
    // 남자가 여자보다 적다 ? => 그냥 더해서 인턴십 사람 빼고 3으로 나누면 됨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int women = Integer.parseInt(st.nextToken());
        int men = Integer.parseInt(st.nextToken());
        int internship = Integer.parseInt(st.nextToken());
        int team = 0;


        while (true) {
            if (women < 0 || men < 0 || (women + men) < internship) {
                team--;
                break;
            }
            team++;
            women -= 2;
            men -= 1;
        }
        System.out.println(team);
    }
}
