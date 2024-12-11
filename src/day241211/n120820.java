package day241211;

import java.time.LocalDate;
import java.util.Scanner;

// 프로그래머스 나이 출력(120820)
public class n120820 {

    private static final int year = LocalDate.now().getYear();

    private static int solution(int age) {
        int answer = year - (age-1);
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("나이 입력 : ");
        int age = sc.nextInt();

        int answer = solution(age);
        System.out.println("답 : " + answer);
    }
}
