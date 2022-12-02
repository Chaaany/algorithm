package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_15988_123더하기3_야옹스쿨 {
    private static int T, dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp = new int[1000001];

        for (int i = 0; i < 1000001; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < T; i++) {
            System.out.println(recur(Integer.parseInt(br.readLine())));
        }
    }

    private static int recur(int total) {
        if(total < 0) return 0;

        if(total == 0) return 1;

        if(dp[total] != -1) return dp[total];

        int ret = 0;

        for (int i = 1; i <= 3; i++) {
            ret = (ret + recur(total - i)) % 1000000009;
        }
        dp[total] = ret;

        return dp[total];
    }
}