import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int starNum; // 별의 개수
    static Star[] stars; // 별의 집합
    static ArrayList<Edge> starCloud;
    static int[] parent; // 대표를 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        starNum = Integer.parseInt(br.readLine());
        stars = new Star[starNum];
        parent = new int[starNum + 1];
        starCloud = new ArrayList<>();

        for (int i = 0; i < starNum; i++) {
            st = new StringTokenizer(br.readLine());
            double xPoint = Double.parseDouble(st.nextToken());
            double yPoint = Double.parseDouble(st.nextToken());
            stars[i] = new Star(i, xPoint, yPoint);
        }

        // 모든 간선들 저장하기
        for (int i = 0; i < starNum; i++) {
            for (int j = i + 1; j < starNum; j++) {
                double edgeDistance = distance(stars[i], stars[j]);
                starCloud.add(new Edge(i, j, edgeDistance));
            }
        }

        // weight 따라 정렬
        Collections.sort(starCloud);

        // 1단계: 초기화
        for (int i = 1; i < starNum; i++) {
            makeSet(i);
        }

        // findSet
        double ans = 0;
        for (int i = 0; i < starCloud.size(); i++) {
            Edge edge = starCloud.get(i);

            if (findSet(edge.start) != findSet(edge.end)) {
                union(edge.start, edge.end);
                ans += edge.weight;
            }
        }

        ans = Math.round(ans * 100) / 100.0;
        System.out.println(ans);
    }

    public static double distance(Star one, Star two) {
        return Math.sqrt(Math.pow(one.x - two.x, 2) + Math.pow(one.y - two.y, 2));
    }

    public static void makeSet(int x) {
        parent[x] = x;
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

    public static class Star {
        int seq; // 순서
        double x, y; // x, y 좌표

        public Star (int seq, double x, double y){
            this.seq = seq;
            this.x = x;
            this.y = y;
        }
    }

    public static class Edge implements Comparable<Edge>{
        int start, end;
        double weight;

        public Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge o) {
            if (weight - o.weight > 0)
                return 1;

            return -1;
        }
    }
}