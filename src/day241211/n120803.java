package day241211;

import java.util.Scanner;

// 프로그래머스 두 수의 차(120803)
public class n120803 {

    private static int solution(int num1, int num2) {
        int answer = num1 - num2;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫번째 값 입력 : ");
        int num1 = sc.nextInt();
        System.out.print("두번째 값 입력 : ");
        int num2 = sc.nextInt();

        int answer = solution(num1, num2);
        System.out.println("답 : " + answer);
    }
}
