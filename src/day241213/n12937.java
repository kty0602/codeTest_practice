package day241213;

import java.util.Scanner;

// 프로그래머스 짝수 홀수(12937)
/*
[문제 설명]
- 홀수인 경우 Odd, 짝수인 경우 Even을 반환
*/
public class n12937 {

    private static String solution(int num) {
        if (num%2==0) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int num = sc.nextInt();

        String answer = solution(num);
        System.out.println("답 : " + answer);
    }
}
