package day241224;

import java.util.Scanner;

// 프로그래머스 최소직사각형(147355)
/*
[문제 설명]
- 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어질 때 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때
- 지갑의 크기를 return하시오.
*/
public class n86491 {

    private static int solution(int[][] sizes) {
        int max1 = 0;
        int max2 = 0;

        for(int i = 0; i<sizes.length; i++) {
            int x = Math.max(sizes[i][0], sizes[i][1]);
            int n = Math.min(sizes[i][0], sizes[i][1]);

            max1 = Math.max(max1, x);
            max2 = Math.max(max2, n);
        }
        return max1*max2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("행렬의 행 개수를 입력하세요: ");
        int rows = sc.nextInt();
        System.out.print("행렬의 열 개수를 입력하세요: ");
        int cols = sc.nextInt();

        int[][] sizes = new int[rows][cols];

        System.out.println("행렬의 값을 입력하세요:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("sizes[" + i + "][" + j + "] = ");
                sizes[i][j] = sc.nextInt();
            }
        }

        int answer = solution(sizes);
        System.out.println("답 : " + answer);
    }
}
