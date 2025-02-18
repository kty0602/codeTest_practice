package day250218;

import java.time.LocalDate;
import java.util.Scanner;

// 프로그래머스 2016(12901)
/*
[문제 설명]
- 2016년 a월 b일의 요일을 구하시오.
*/
public class n12901 {

    private static String solution(int a, int b) {
        return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("a월 입력 : ");
        int a = sc.nextInt();

        System.out.print("b일 입력 : ");
        int b = sc.nextInt();

        String answer = solution(a, b);
        System.out.println("답 : " + answer);
    }
}
