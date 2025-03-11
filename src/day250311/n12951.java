package day250311;

import java.util.Scanner;

// 프로그래머스 JadenCase 문자열 만들기(12951)
/*
[문제 설명]
- 모든 단어의 첫 문자가 대문자고 그 외의 알파벳은 소문자인 문자열입니다.
- 문자열이 주어질 때 JadenCase로 바꾼 문자열을 리턴하는 함수를 완성하시오.
*/
public class n12951 {

    private static String solution(String s) {
        StringBuilder result = new StringBuilder();
        boolean check = true;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                result.append(c);
                check = true;
            } else {
                if (check) {
                    result.append(Character.toUpperCase(c));
                } else {
                    result.append(Character.toLowerCase(c));
                }
                check = false;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열을 입력하세요. : ");
        String s = sc.nextLine();

        String result = solution(s);
        System.out.println("답 : " + result);
    }
}
