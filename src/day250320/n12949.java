package day250320;

import java.util.Arrays;
import java.util.Scanner;

// 프로그래머스 행렬의 곱셈(12949)
/*
[문제 설명]
- 2차원 행렬 arr1과 arr2를 입력받아 arr1에 arr2를 곱한 결과를 반환하는 함수를 완성하시오.
*/
public class n12949 {

    private static int[][] solution(int[][] arr1, int[][] arr2) {
        int row1 = arr1.length;
        int col1 = arr1[0].length;
        int row2 = arr2.length;
        int col2 = arr2[0].length;

        int[][] answer = new int[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 행렬 arr1의 크기 입력
        System.out.print("arr1 행렬의 행 : ");
        int row1 = sc.nextInt();
        System.out.print("arr1 행렬의 열 : ");
        int col1 = sc.nextInt();

        // arr1 행렬 입력
        int[][] arr1 = new int[row1][col1];
        System.out.println("arr1 행렬의 원소들을 입력하세요:");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                System.out.print("arr1["+ i +"]["+ j +"] : ");
                arr1[i][j] = sc.nextInt();
            }
        }

        // 행렬 arr2의 크기 입력
        System.out.print("arr2 행렬의 행 : ");
        int row2 = sc.nextInt();
        System.out.print("arr2 행렬의 열 : ");
        int col2 = sc.nextInt();

        // arr2 행렬 입력
        int[][] arr2 = new int[row2][col2];
        System.out.println("arr2 행렬의 원소들을 입력하세요:");
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                System.out.print("arr2["+ i +"]["+ j +"] : ");
                arr2[i][j] = sc.nextInt();
            }
        }

        int[][] result = solution(arr1, arr2);
        System.out.print("답 : " + Arrays.deepToString(result));
    }
}
