package day241213;

import java.util.Scanner;

// 프로그래머스 나이 출력(12931)
/*
[문제 설명]
- 자연수 N의 각 자릿수의 합을 구해서 return
*/
public class n12931 {

    private static int solution(int n) {
        int answer = 0;

        while(n >0) {
            answer += n%10;
            n/=10;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        // 자연수 입력 검사
        while (true) {
            System.out.print("자연수 입력 : ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n > 0) { // 자연수만 허용
                    break;
                } else {
                    System.out.println("자연수만 입력 가능합니다. 1 이상의 숫자를 입력해주세요.");
                }
            } else {
                System.out.println("유효하지 않은 입력입니다. 자연수를 입력해주세요.");
                sc.next();
            }
        }

        int answer = solution(n);
        System.out.println("답 : " + answer);
    }
}
