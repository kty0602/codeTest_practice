package day241220;

import java.util.Arrays;
import java.util.Scanner;

// 프로그래머스 문자열 내림차순 배치(12917)
/*
[문제 설명]
- 문자열 s에 나타나는 문자를 큰 것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수
- 대문자는 소문자보다 작은 것으로 간주
*/
public class n12917 {

    private static String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        Arrays.sort(str);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        answer = sb.reverse().toString();

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 s 입력 : ");
        String s = sc.nextLine();

        String answer = solution(s);
        System.out.println("답 : " + answer);
    }
}
