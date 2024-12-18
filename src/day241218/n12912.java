package day241218;

import java.util.Scanner;

// 프로그래머스 두 정수 사이의 합(12912)
/*
[문제 해설]
- 두 정수 a,b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴
*/
public class n12912 {

    private static long solution(int a, int b) {
        long answer = 0;
        if(a<b) {
            for (int i = a; i<=b; i++) {
                answer += i;
            }
        } else if (a>b) {
            for (int i = b; i<=a; i++) {
                answer += i;
            }
        } else {
            answer = a;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫번째 숫자를 입력하세요. : ");
        int a = sc.nextInt();
        System.out.print("두번째 숫자를 입력하세요. : ");
        int b = sc.nextInt();

        long answer = solution(a, b);
        System.out.println("답 : " + answer);
    }
}
