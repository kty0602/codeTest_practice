package day250312;

import java.util.Scanner;

// 프로그래머스 피보나치 수(12945)
/*
[문제 설명]
- 피보나치 수는 F(n) = F(n-1) + F(n-2)가 적용되는 수입니다.
- 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567로 나눈 나머지를 리턴하는 함수를 완성하세요.
*/
public class n12945 {

    private static int solution(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev2 = 0, prev1 = 1, current = 0;

        for (int i = 2; i <= n; i++) {
            current = (prev1 + prev2) % 1234567;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n : ");
        int n = sc.nextInt();
        int result = solution(n);
        System.out.println("답 : " + result);
    }
}
