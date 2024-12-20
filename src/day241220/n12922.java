package day241220;

import java.util.Scanner;

// 프로그래머스 수박수박수박(12922)
/*
[문제 해설]
- 길이가 n이고 "수박수박..." 패턴을 유지하는 문자열을 리턴하시오.
- 홀수면 "수박수", 짝수면 "수박수박"을 return
*/
public class n12922 {

    private static String solution(int n) {
        String answer = "";
        for(int i = 0; i<n; i++) {
            if(i%2 == 0) {
                answer += "수";
            } else {
                answer += "박";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("자연수 n을 입력하시오 : ");
        int n = sc.nextInt();

        String answer = solution(n);
        System.out.println("답 : " + answer);
    }
}
