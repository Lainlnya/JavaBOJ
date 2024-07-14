import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new ArrayList<>();
        int answer = 0;

        // 입력
        for (int i = 0; i < 4; i++) {
            arr.add(new ArrayList<>());
            char[] temp = br.readLine().toCharArray();

            for (int j = 0; j < temp.length; j++) {
                arr.get(i).add(temp[j] - '0');
            }
        }

        int caseNum = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < caseNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());
            solution(start - 1, position);
        }

        for (int i = 0; i < 4; i++) {
            if (arr.get(i).get(0) == 1) {
                answer += (int) Math.pow(2, i);
            }
        }
        System.out.println(answer);
    }

    public static void solution(int start, int position) {
        int[] getP = new int[4];
        Arrays.fill(getP, -90);

        getP[start] = position;

        switch(start) {
            case 0: {
                for (int i = 1; i < getP.length; i++) {
                    if (arr.get(i - 1).get(2) != arr.get(i).get(6)) {

                        getP[i] = getP[i - 1] == -1 ? 1 : getP[i - 1] == 0 ? 0 : -1;
                    } else {
                        getP[i] = 0;
                    }
                }
                break;
            }

            case 1: {
                if (arr.get(0).get(2) != arr.get(1).get(6)) {
                    getP[0] = getP[1] == -1 ? 1 : getP[1] == 0 ? 0 : -1;
                } else getP[0] = 0;

                for (int i = 2; i < getP.length; i++) {
                    if (arr.get(i - 1).get(2) != arr.get(i).get(6)) {
                        getP[i] = getP[i - 1] == -1 ? 1 : getP[i - 1] == 0 ? 0 : -1;
                    } else {
                        getP[i] = 0;
                    }
                }
                break;
            }
            case 2: {

                if (arr.get(2).get(2) != arr.get(3).get(6)) {
                    getP[3] = getP[2] == -1 ? 1 : getP[2] == 0 ? 0 : -1;
                } else getP[3] = 0;

                for (int i = 1; i >= 0; i--) {
                    if (arr.get(i + 1).get(6) != arr.get(i).get(2)) {
                        getP[i] = getP[i + 1] == -1 ? 1 : getP[i + 1] == 0 ? 0 : -1;
                    } else {
                        getP[i] = 0;
                    }
                }
                break;
            }

            case 3: {
                for (int i = 2; i >= 0; i--) {
                    if (arr.get(i + 1).get(6) != arr.get(i).get(2)) {
                        getP[i] = getP[i + 1] == -1 ? 1 : getP[i + 1] == 0 ? 0 : -1;
                    } else {
                        getP[i] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < getP.length; i++) {
            ArrayList<Integer> temp = arr.get(i);
            if (getP[i] == -1) {
                temp.add(temp.remove(0));
            } else if (getP[i] == 1) {
                temp.add(0, temp.remove(7));
            }
            // System.out.println(temp);
        }
    }
}
