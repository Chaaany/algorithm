package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2587_대표값2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int midValue, averageValue = 0, inputCount = 5, input[] = new int[inputCount];

        for (int i = 0; i < inputCount; i++) {
            int temp = Integer.parseInt(br.readLine());
            input[i] = temp;
            averageValue += input[i];
        }
        Arrays.sort(input);
        midValue = input[2];

        System.out.println(averageValue / 5 + "\n" + midValue);
    }
}
