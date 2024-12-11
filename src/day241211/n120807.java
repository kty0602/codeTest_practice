package day241211;

import java.util.Scanner;

// 프로그래머스 숫자 비교하기(120807)
public class n120807 {

    private static int solution(int num1, int num2) {
        int answer = 0;
        if (num1 == num2) {
            answer = 1;
        } else {
            answer = -1;
        }
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
