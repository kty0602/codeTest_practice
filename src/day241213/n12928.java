package day241213;

import java.util.Scanner;

// 프로그래머스 나이 출력(12928)
/*
[문제 설명]
- n의 약수를 모두 더한 값을 return
*/
public class n12928 {

    private static int solution(int n) {
        int answer = 0;
        if (n>=0 && n<=3000) {
            for(int i=1; i<=n; i++) {
                if(n%i==0) {
                    answer+=i;
                }
            }
        } else {
            System.out.printf("범위를 벗어났습니다.");
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 입력 : ");
        int n = sc.nextInt();

        int answer = solution(n);
        System.out.println("답 : " + answer);
    }
}
