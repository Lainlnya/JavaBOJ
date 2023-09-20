import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static Point[] land;
    public static double weightM;
    public static List<Land> weightList;
    public static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // 테케

        for (int t = 1; t <= tc; t++) {
            // 섬의 개수
            int nodeNum = sc.nextInt();
            land = new Point[nodeNum];

            // x좌표 입력
            for (int i = 0; i < nodeNum; i++) {
                land[i] = new Point(0, 0);
                land[i].x = sc.nextInt();
            }

            // y좌표 입력
            for (int i = 0; i < nodeNum; i++) {
                land[i].y = sc.nextInt();
            }

            weightM = sc.nextDouble(); // 세율

            // 이제 가중치
            weightList = new ArrayList<>();

            for (int i = 0; i < nodeNum; i++) {
                for (int j = i + 1; j < nodeNum; j++) {
                    long distX = Math.abs(land[i].x - land[j].x);
                    long distY = Math.abs(land[i].y - land[j].y);
                    weightList.add(new Land(i, j, distX * distX + distY * distY));
                }
            } // 가중치

            // 1단계: weight에 따라 간선 오름차순 정렬
            weightList.sort(new Comparator<Land>() {
                @Override
                public int compare(Land o1, Land o2) {
                   if (o1.weight < o2.weight) {
                       return -1;
                   } else if (o1.weight > o2.weight) return 1;
                   else return 0;
                }
            }); // 오름차순

            // 2단계: weightList -1개의 간선을 뽑아야 하는데, 사이클이 발생하지 않도록
            parent = new int[nodeNum];

            // 정점 초기화
            for (int i = 0; i < nodeNum; i++) {
                parent[i] = i;
            }

            double ans = 0; // 최소비용을 저장할 아이
            int pick = 0; // 뽑은 간선의 수를 저장할 아이
            for (Land land : weightList) {
                int x = land.from;
                int y = land.to;

                int px = findSet(x);
                int py = findSet(y);

                // 사이클 형성이 안된다.
                if (px != py) {
                    union(px, py);
                    ans += land.weight;
                    pick++;
                }

                if (pick == (nodeNum - 1)) break;
            }

            System.out.println("#" + t + " " + Math.round(ans * weightM));
        } // 테케
    } // 메인

    public static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // point 클래스

    public static class Land {
        int from, to;
        double weight;

        Land(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static int findSet(int x) {
        if (x != parent[x]) {
            parent[x] = findSet(parent[x]);
        }

        return parent[x];
    }

    public static void union(int x, int y) {
        parent[findSet(y)] = findSet(x);
    }
}
