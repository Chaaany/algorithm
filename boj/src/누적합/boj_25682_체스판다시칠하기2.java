package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_25682_체스판다시칠하기2 {
    private static int N, M, K;
    private static String[][] board;

    public static void main(String[] args) throws IOException {
        // 1. M x N 크기의 2차원 배열 입력
        // 2. 검, 흰 두 가지의 색으로 칠해져 있음
        // 3. 아무 곳을 기준으로 K x K 만큼 자르기
        // 4. 칠해야 하는 정사각형의 갯수 구하기
        // 5. 정사각형 갯수의 최솟값 구하기
        // 입력 제한
        // 1 <= N, M <= 2,000
        // 1 <= K <= min(N, M)

        // 1. 브루트 포스 방식
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputValue[] = br.readLine().split(" ");

        N = Integer.parseInt(inputValue[0]);
        M = Integer.parseInt(inputValue[1]);
        K = Integer.parseInt(inputValue[2]);

        int answer = 4000001;
        board = new String[N][M];

        for (int i = 0; i < N; i++) {
            String temp[] = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = temp[j];
            }
        }

        for (int i = 0; i <= N - K; i++) {
            for (int j = 0; j <= M - K; j++) {
                answer = Math.max(i, j);
//                check(i, j, "W");
            }
        }

    }

    private static void check(int i, int j) {




    }
}
