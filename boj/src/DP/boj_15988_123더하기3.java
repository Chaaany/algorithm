package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_15988_123더하기3 {
    private static int testcaseNumber, dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcaseNumber = Integer.parseInt(br.readLine());

        calc();

        for (int i = 0; i < testcaseNumber; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }

    private static void calc() {
        dp = new int[1000004];
        dp[0] = 1;

        for(int i = 0; i <= 1000000; i++){
            for(int j = 1; j <= 3; j++){
                dp[i+j] = (dp[i+j] + dp[i]) % 1000000009;
            }
        }
    }
}
