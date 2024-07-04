import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] roomNum = br.readLine().toCharArray();
        int[] rooms = new int[11];
        int answer = 0;
        Arrays.sort(roomNum);

        for (int i = 0; i < roomNum.length; i++) {
            int room = roomNum[i] - '0';
            rooms[room]++;
        }
        // System.out.println(Arrays.toString(rooms));

        rooms[6] = (rooms[9] + rooms[6]) % 2 == 1 ? (rooms[9] + rooms[6]) / 2 + 1 : (rooms[9] + rooms[6]) / 2;
        rooms[9] = 0;

        for (int i = 0; i < rooms.length; i++) {
            answer = Math.max(answer, rooms[i]);
        }

        System.out.println(answer);
    }
}
