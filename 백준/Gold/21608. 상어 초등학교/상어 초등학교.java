import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer;
    static int seatNum;
    static Seat[][] seatPlace;
    static ArrayList<Student> students;
    static int[][] resultSeat;
    static int[] dr = {0, 0, -1, 1}; // 하 상 좌 우
    static int[] dc = {1, -1, 0, 0};
    static class Student implements Comparable<Student> {
        int num; // 학생 번호
        List<Integer> favoriteStudent; // 좋아하는 학생 수

        Student(int num, List<Integer> favoriteStudent) {
            this.num = num;
            this.favoriteStudent = favoriteStudent;
        }


        @Override
        public int compareTo(Student o) {
            return num - o.num;
        }
    }

    static class Seat implements Comparable<Seat> {
        int x, y, favoriteStudent, emptySpace;

        Seat(int x, int y, int favoriteStudent, int emptySpace) {
            this.x = x;
            this.y = y;
            this.favoriteStudent = favoriteStudent;
            this.emptySpace = emptySpace;
        }

        @Override
        public int compareTo(Seat other) {
            if (favoriteStudent != other.favoriteStudent) {
                return -(favoriteStudent - other.favoriteStudent);
            }

            if (emptySpace != other.emptySpace) {
                return -(emptySpace - other.emptySpace);
            }

            if (x != other.x) {
                return x - other.x;
            }

            return y - other.y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        seatNum = Integer.parseInt(br.readLine());
        seatPlace = new Seat[seatNum][seatNum];
        students = new ArrayList<>();
        resultSeat = new int[seatNum][seatNum];
        answer = 0;

        for (int i = 0; i < seatNum * seatNum; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            ArrayList<Integer> favorite = new ArrayList<>();

            // 좋아하는 학생 연결
            for (int j = 0; j < 4; j++) {
                favorite.add(Integer.parseInt(st.nextToken()));
            }
            students.add(i, new Student(num, favorite));
        }

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            Seat seat = getSeat(student);
            resultSeat[seat.x][seat.y] = student.num;
        }
        
        Collections.sort(students);
        for (int i = 0; i < seatNum; i++) {
            for (int j = 0; j < seatNum; j++) {
                answer += getScore(i, j);
            }
        }

        System.out.println(answer);
    }

    public static Seat getSeat(Student student) {
        Seat curSeat = null;
        for (int i = 0; i < seatNum; i++) {
            for (int j = 0; j < seatNum; j++) {
                // 이미 앉아있으면 skip
                if (resultSeat[i][j] != 0) continue;
                // x, y, 인접한 좋아하는 사람, 비어있는 자리
                int adjustFav = calculateAdjacentFavorites(i, j, student);
                int emptySeats = calculateEmptySeats(i, j);

                Seat nxtSeat = new Seat(i, j, adjustFav, emptySeats);

                // 현재 좌석과 다음 좌석 비교
                if (curSeat == null || curSeat.compareTo(nxtSeat) > 0) {
                    curSeat = nxtSeat;
                }
            }
        }
        return curSeat;
    }

    // 비어있는 학생 수 계산
    public static int calculateEmptySeats(int row, int col) {
        int possibleCount = 0;
        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            if (nr >= 0 && nr < seatNum && nc >= 0 && nc < seatNum) {
                if (resultSeat[nr][nc] == 0) {
                    possibleCount++;
                }
            }
        }
        return possibleCount;
    }


    // 인접에 좋아하는 학생 수 계산
    public static int calculateAdjacentFavorites(int row, int col, Student student) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr >= 0 && nr < seatNum && nc >= 0 && nc < seatNum) {
                if (resultSeat[nr][nc] != 0 && student.favoriteStudent.contains(resultSeat[nr][nc])) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int getScore(int row, int col) {
        int currentStudent = resultSeat[row][col];
        Student student = students.get(currentStudent - 1);

        int score = 0;
        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            if (nr >= 0 && nr < seatNum && nc >= 0 && nc < seatNum) {
                int neighborStudent = resultSeat[nr][nc];
                if(neighborStudent != 0 && student.favoriteStudent.contains(neighborStudent)) {
                    score++;
                }
            }
        }
        if (score == 0) return 0;
        if (score == 1) return 1;

        return (int)Math.pow(10, score - 1);
    }
}
