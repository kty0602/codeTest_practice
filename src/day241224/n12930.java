package day241224;

import java.util.Scanner;

// 프로그래머스 이상한 문자 만들기(12930)
/*
[문제 설명]
- 문자열을 입력받아 짝수번째 알파벳은 대문자, 홀수번째는 소문자로 바꾼 문자열 return
*/
public class n12930 {

    private static String solution(String s) {
        String answer = "";
        int count = 0;
        String array[] = s.split("");

        for(String arr : array) {
            count = arr.contains(" ") ? 0 : count+1;
            answer += count%2 == 0 ? arr.toLowerCase() : arr.toUpperCase();
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String s = sc.nextLine();

        String answer = solution(s);
        System.out.println("답 : " + answer);
    }
}
