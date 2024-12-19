package day241219;

import java.util.Scanner;

// 프로그래머스 가운데 글자 가져오기(12903)
/*
[문제 해설]
- 단어 s의 가운데 글자를 return, 짝수 길이라면 가운데 두 글자를 return
*/
public class n12903 {

    private static String solution(String s) {
        String answer = "";
        int a = s.length();
        if(a % 2 == 0) {
            answer = s.substring(a/2-1, a/2+1);
        } else {
            answer = s.substring(a/2, a/2+1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("단어 입력 : ");
        String s = sc.nextLine();

        String answer = solution(s);
        System.out.println("답 : " + answer);
    }
}
