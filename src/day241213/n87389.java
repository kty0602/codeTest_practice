package day241213;

import java.util.Scanner;

// 프로그래머스 평균 구하기(87389)
/*
[문제 설명]
- 자연수 N을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 X를 return
*/
public class n87389 {

    private static int solution(int n) {
        int answer = 0;
        if(n>=3 && n<=1000000) {
            for(int i = 1 ; i<n; i++) {
                if(n%i==1) {
                    answer = i;
                    break;
                }
            }
        } else {
            System.out.println("범위에서 벗어났습니다.");
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("자연수 입력 : ");
        int n = sc.nextInt();

        int answer = solution(n);
        System.out.println("답 : " + answer);
    }
}
