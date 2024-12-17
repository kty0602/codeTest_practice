package day241217;

import java.util.Arrays;
import java.util.Scanner;

// 프로그래머스 자연수 뒤집어 배열 만들기(12932)
/*
[문제 설명]
- 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴
*/
public class n12932 {

    private static int[] solution(long n) {
        String number = String.valueOf(n);
        int[] answer = new int[number.length()];
        int[] answer2 = new int[number.length()];
        int len = answer.length;

        for(int i = 0; i < len; i++) {
            answer[i] = number.charAt(i) - '0';
        }

        for(int i = 0; i < len; i++) {
            answer2[len - i - 1] = answer[i];
        }

        return answer2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("자연수 n 입력 : ");
        long n = sc.nextLong();

        int[] answer = solution(n);
        System.out.println("답 : " + Arrays.toString(answer));
    }
}
