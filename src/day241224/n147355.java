package day241224;

import java.util.Scanner;

// 프로그래머스 크기가 작은 부분 문자열(147355)
/*
[문제 설명]
- 문자열 t와 p를 입력받고 t에서 p의 길이와 같은 부분 문자열 중에서 p보다 더 작은 수의 횟수를 return
*/
public class n147355 {

    private static int solution(String t, String p) {
        int len = p.length();
        long num = Long.parseLong(p);
        int answer = 0;

        for (int i = 0; i < t.length() - len + 1; i++) {
            long diff = Long.parseLong(t.substring(i, i + len));
            if (diff <= num) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 t를 입력하시오. : ");
        String t = sc.nextLine();

        System.out.print("문자열 p를 입력하시오. : ");
        String p = sc.nextLine();

        int answer = solution(t, p);
        System.out.println("답 : " + answer);
    }
}
