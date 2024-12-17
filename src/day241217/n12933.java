package day241217;

import java.util.Arrays;
import java.util.Scanner;

// 프로그래머스 정수 내림차순으로 배치(12933)
/*
[문제 설명]
- n의 각 자릿수를 큰 것부터 작은 순으로 정렬한 새로운 정수를 리턴
*/
public class n12933 {

    private static long solution(long n) {
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            sb.append(list[i]);
        }

        return Long.parseLong(sb.reverse().toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 n 입력 : ");
        long n = sc.nextLong();

        long answer = solution(n);
        System.out.println("답 : " + answer);
    }
}
