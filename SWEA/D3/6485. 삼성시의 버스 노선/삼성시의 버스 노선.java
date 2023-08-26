//package SWEA_6485_삼성시의_버스_노선;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static int[] busStop = new int[5001];

    public static void main(String[] args) throws FileNotFoundException {
//        System.setIn(new FileInputStream("src/SWEA_6485_삼성시의_버스_노선/s_input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            busStop = new int[5001];
            //버스노선 개수
            int N = sc.nextInt();

            for(int i = 0; i < N; i++) {
                //지나가는 버스정류장의 최소 번호
                int A = sc.nextInt();
                //지나가는 버스정류장의 최대 번호
                int B = sc.nextInt();
                //해당 범위를 지나가므로 busStop의 인덱스를 이용하여 지나가는 버스 수 증가
                for(int j = A; j <= B; j++) {
                    busStop[j]++;
                }
            }

            int P = sc.nextInt();
            System.out.print("#" + tc + " ");
            for(int i = 1; i <= P; i++) {
                int C = sc.nextInt();
                System.out.print(busStop[C] + " ");
            }
            System.out.println();

        }//tc
    }//main
}//class