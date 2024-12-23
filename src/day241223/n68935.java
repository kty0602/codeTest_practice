package day241223;

import java.util.Scanner;

// 프로그래머스 3진법 뒤집기(68935)
/*
[문제 설명]
- n을 3진법 상에서 앞으로 뒤집은 후, 다시 10진법으로 표현한 수를 return
*/
public class n68935 {

    private static int solution(int n) {
        int answer = 0;
        String str = "";
        while(n!=0) {
            str += n%3;
            n/=3;
        }
        answer = Integer.parseInt(str, 3);
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n의 값 : ");
        int n = sc.nextInt();

        int answer = solution(n);
        System.out.println("답 : " + answer);
    }
}
