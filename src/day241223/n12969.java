package day241223;

import java.util.Scanner;

// 프로그래머스 직사각형 별찍기(12969)
/*
[문제 설명]
- 정수 n과 m을 입력해서 가로 길이가 n, 세로 길이가 m인 직사각형을 그리시오.
*/
public class n12969 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n의 값 : ");
        int n = sc.nextInt();
        System.out.print("m의 값 : ");
        int m = sc.nextInt();

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
