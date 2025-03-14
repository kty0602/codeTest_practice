package day250314;

import java.util.Scanner;

// 프로그래머스 멀리 뛰기(12914)
/*
[문제 설명]
- 효진이는 한번에 1칸 또는 2칸을 뜁니다.
- 칸이 총 4개 있을 때, 효진이는 총 5가지 방법으로 끝 칸까지 도달할 수 있습니다. n이 주어질 때 끝에 도달하는 방법이 몇 가지인지 리턴 하시오.
*/
public class n12914 {

    private static long solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        long a = 1;
        long b = 2;
        long result = 0 ;

        for (int i = 3; i <= n; i++) {
            result = (a+b) % 1234567;
            a = b;
            b = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n : ");
        int n = sc.nextInt();
        long result = solution(n);
        System.out.println("답 : " + result);
    }
}
