package day241212;

import java.util.Scanner;

// 프로그래머스 짝수의 합(120831)
/*
[문제 설명]
- n 이하의 짝수를 모든 더한 값을 return
*/
public class n120831 {

    private static int solution(int n) {
        int answer = 0;
        for(int i = 0; i <= n; i++) {
            if (i%2 == 0) {
                answer += i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int n = sc.nextInt();

        int answer = solution(n);
        System.out.println("답 : " + answer);
    }
}
