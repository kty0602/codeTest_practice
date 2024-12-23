package day241223;

import java.util.Scanner;

// 프로그래머스 문자열 다루기(12918)
/*
[문제 설명]
- 문자열 s의 길이가 4 혹은 6이고 숫자로만 구성되어 있는지 확인해주는 함수
- 맞다면 true 아니면 false를 return
*/
public class n12918 {

    private static boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6) {
            try {
                int i = Integer.parseInt(s);
                return true;
            } catch(Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 s를 입력하시오. : ");
        String s = sc.nextLine();

        boolean answer = solution(s);
        System.out.println("답 : " + answer);
    }
}
