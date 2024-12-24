package day241224;

import java.util.Scanner;

// 프로그래머스 시저 암호(12926)
/*
[문제 설명]
- 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저암호
- 문자열 s와 거리 n을 입력받아서 나오는 문자열을 return
*/
public class n12926 {

    private static String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)((ch - 'A' + n) % 26 + 'A');
            }
            else if (ch >= 'a' && ch <= 'z') {
                ch = (char)((ch - 'a' + n) % 26 + 'a');
            }
            answer.append(ch);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 s 입력 : ");
        String s = sc.nextLine();
        System.out.print("거리 n 입력 : ");
        int n = sc.nextInt();

        String answer = solution(s, n);
        System.out.println("답 : " + answer);
    }
}
