package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class boj_14501_퇴사 {
    // 1. 뒤에서 부터 For문을 돌기
    // 2. 해당 배열 순서 + 경과 기간 >= N 이면 넘기기
    // 3. 합의 최댓값 으로 갱신 해두기
    static class Consult {
        int time;
        int profit;

        Consult(int time, int profit) {
            this.time = time;
            this.profit = profit;
        }

    }
    public static void main(String[] args) throws IOException {
//        Scanner br = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int curProfit = 0;
        int N = Integer.parseInt(br.readLine());
        Consult[] consults = new Consult[N];
        int dp[] = new int[N+1];

        for (int i = 0; i < N; i++) {
            String temp[] = br.readLine().split(" ");
            consults[i] = new Consult(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }

        for (int i = N - 1; i >= 0; i--) {
            if(consults[i].time + i <= N){
                curProfit = consults[i].profit + dp[i + consults[i].time];
                max = Math.max(curProfit, max);
                dp[i] = max ;
            } else {
                dp[i] = max;
            }
        }

        System.out.print(max);
    }
}
