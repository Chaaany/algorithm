package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// DP
// 1. 템플릿 적용
// 2. 백트래킹
// 3. 메모이제이션 적용

public class boj_14501_퇴사_야옹스쿨 {
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
    private static int dp[], N, max;
    private static Consult[] consults;
    public static void main(String[] args) throws IOException {
//        Scanner br = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        max = -10000000;
        dp= new int[N];

        int curProfit = 0;
        consults = new Consult[N];

        for (int i = 0; i < N; i++) {
            String temp[] = br.readLine().split(" ");
            consults[i] = new Consult(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            dp[i] = -1;
        }

        System.out.print(recur(0));
    }

    private static int recur(int cur) {
        if(cur > N) return Integer.MIN_VALUE;

        if(cur == N) return 0;

        if(dp[cur] != -1) return dp[cur];

        dp[cur] = Math.max(recur(cur + consults[cur].time) + consults[cur].profit, recur(cur + 1));

        return dp[cur];
    }
}
