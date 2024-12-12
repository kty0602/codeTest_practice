package day241212;

import java.util.Scanner;

// 프로그래머스 두 수의 나눗셈(120806)
/*
[문제 설명]
- 나눈 값에 1,000을 곱한 후 정수 부분을 return
*/
public class n120806 {

    private static final int thousand = 1000;

    private static int solution(int num1, int num2) {
        double answer = (double)num1/num2 * thousand;
        return (int)answer;
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
