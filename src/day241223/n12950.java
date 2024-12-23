package day241223;

import java.util.Scanner;

// 프로그래머스 행렬의 덧셈(12950)
/*
[문제 설명]
- 행과 열의 크기가 같은 두 행렬의 같은 행, 열의 값을 서로 더한 결과
*/
public class n12950 {

    private static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        answer = arr1;
        for(int i = 0 ; i < arr1.length; i++) {
            for(int j = 0; j < arr1[i].length; j++) {
                answer[i][j] += arr2[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("행렬의 행 개수를 입력하세요: ");
        int rows = sc.nextInt();
        System.out.print("행렬의 열 개수를 입력하세요: ");
        int cols = sc.nextInt();

        int[][] arr1 = new int[rows][cols];
        int[][] arr2 = new int[rows][cols];

        System.out.println("첫 번째 행렬의 값을 입력하세요:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("arr1[" + i + "][" + j + "] = ");
                arr1[i][j] = sc.nextInt();
            }
        }

        System.out.println("두 번째 행렬의 값을 입력하세요:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("arr2[" + i + "][" + j + "] = ");
                arr2[i][j] = sc.nextInt();
            }
        }

        int[][] result = solution(arr1, arr2);

        System.out.println("행렬의 덧셈 결과:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
