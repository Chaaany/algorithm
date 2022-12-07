package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_25682_체스판다시칠하기2 {
    private static int N, M, K, answer;
    private static String[][] board;

    private static int[][][] accSum;

    public static void main(String[] args) throws IOException {
        // 1. M x N 크기의 2차원 배열 입력
        // 2. 검, 흰 두 가지의 색으로 칠해져 있음
        // 3. 아무 곳을 기준으로 K x K 만큼 자르기
        // 4. 칠해야 하는 정사각형의 갯수 구하기
        // 5. 정사각형 갯수의 최솟값 구하기
        // 입력 제한
        // 1 <= N, M <= 2,000
        // 1 <= K <= min(N, M)

        /*
        * 풀이
        * - 입력
        * - 출력
        * - B로 칠했을 때 바꿔야할 갯수 Count
        * - W로 칠했을 때 바꿔야할 갯수 Count
        * - (a + b + d + e) - (a + b) - ( a + d ) + a => e
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputValue[] = br.readLine().split(" ");

        N = Integer.parseInt(inputValue[0]);
        M = Integer.parseInt(inputValue[1]);
        K = Integer.parseInt(inputValue[2]);

        answer = 4000001;

        board = new String[N+1][M+1];
        accSum = new int[N+1][M+1][2]; // 0 => 1,1 이 B로 시작, 1 = 1,1이 W로 시작
//      입력
        for (int i = 0; i < N; i++) {
            String temp[] = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i+1][j+1] = temp[j];
                countColor(i+1, j+1);
            }
        }

        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = 1; j <= M - K + 1; j++) {
                findMin(i, j, i + K - 1, j + K -1); // i ~ i + K - 1
            }
        }

//        출력
        System.out.print(answer);

    }

//    (a + b + d + e) - (a + b) - ( a + d ) + a => e
    private static void findMin(int r1, int c1, int r2, int c2) {
        int tempMin = 4000001;
        int withBStartBoard = accSum[r2][c2][0] - accSum[r1-1][c2][0] - accSum[r2][c1 -1][0] + accSum[r1-1][c1-1][0];
        int withWStartBoard = accSum[r2][c2][1] - accSum[r1-1][c2][1] - accSum[r2][c1 -1][1] + accSum[r1-1][c1-1][1];
        tempMin = Math.min(withBStartBoard, withWStartBoard);
        answer = Math.min(tempMin, answer);
    }

//    - B로 칠했을 때 바꿔야할 갯수 Count
//    - W로 칠했을 때 바꿔야할 갯수 Count
    private static void countColor(int r, int c) {
        accSum[r][c][0] = accSum[r-1][c][0] + accSum[r][c - 1][0] - accSum[r-1][c-1][0];
        accSum[r][c][1] = accSum[r-1][c][1] + accSum[r][c - 1][1] - accSum[r-1][c-1][1];

        if(r % 2 == c % 2) {
            if(board[r][c].equals("W")) accSum[r][c][0]++;
            if(board[r][c].equals("B")) accSum[r][c][1]++;
        } else {
            if(board[r][c].equals("B")) accSum[r][c][0]++;
            if(board[r][c].equals("W")) accSum[r][c][1]++;
        }
    }
}
