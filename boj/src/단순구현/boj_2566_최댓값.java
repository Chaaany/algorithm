package 단순구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2566_최댓값 {
    static int input[][] = new int[10][10]; // 입력 받을 배열 - 패딩
    static int maxValue = -1; // 출력할 최댓값
    static int[] maxValueLoc = new int[2]; // 출력할 최댓값의 배열 행, 열

    public static void main(String[] args) throws IOException {
        // 1. 9 x 9 배열
        // 2. 0 이상 100 이하의 정수
        // 3. 최댓값 찾기
        // 4. 몇 행 몇 열인지 구하기

        // 방법 1(입력 받을 때 최댓값 인식)
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i < 10; i++) {
            String temp[] = br.readLine().split(" ");
            for (int j = 1; j <= temp.length; j++) {
                input[i][j] = Integer.parseInt(temp[j-1]);
                checkMax(i, j);
            }
        }
        // 2. 출력
        System.out.println(maxValue);
        System.out.println(maxValueLoc[0] +" " +maxValueLoc[1]);
    }

    private static void checkMax(int i, int j) {
        if (maxValue <= input[i][j]) {
            maxValue = input[i][j];
            maxValueLoc[0] = i;
            maxValueLoc[1] = j;
        }
    }



}
