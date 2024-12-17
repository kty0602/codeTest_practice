package day241217;

import java.util.Scanner;

// 프로그래머스 문자열을 정수로 바꾸기(12925)
/*
[문제 해설]
- 문자열 s를 숫자로 변환한 결과를 반환
*/
public class n12925 {

    private static int solution(String s) {
        int answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열로 이뤄진 숫자 입력 : ");
        String s = sc.nextLine();

        int answer = solution(s);
        System.out.println("답 : " + answer);
    }
}
