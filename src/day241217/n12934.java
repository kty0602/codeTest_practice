package day241217;

import java.util.Scanner;

// 프로그래머스 정수 제곱근 판별(12934)
/*
[문제 설명]
- 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱근이라면 x+1의 제복을 리턴
  아니라면 -1을 리턴한다.
*/
public class n12934 {

    private static long solution(long n) {
        long answer = 0;

        long x = (long) Math.sqrt(n);
        if (x*x == n) {
            answer = (x+1)*(x+1);
        } else {
            answer = -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("양의 정수 n 입력 : ");
        long n = sc.nextLong();

        long answer = solution(n);
        System.out.println("답 : " + answer);
    }
}
