package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class boj_25305_커트라인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;

        // 커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.
        String temp[] = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        k = Integer.parseInt(temp[1]);

        temp = br.readLine().split(" ");

        Integer scores[] = new Integer[temp.length];

        for (int i = 0; i < temp.length; i++) {
            scores[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(scores, Collections.reverseOrder());

        System.out.println(scores[k-1]);
    }
}
