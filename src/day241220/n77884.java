package day241220;

import java.util.Scanner;

// 프로그래머스 약수의 개수와 덧셈(77884)
/*
[문제 설명]
- 두 정수 left와 right가 매개변수
- left부터 right 까지의 모든 수 중에서, 약수의 개수가 짝수인 수는 더하고, 홀수인 수는 뺀 값을 return
*/
public class n77884 {

    private static int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i<=right; i++) {
            int count = 0;
            for(int j = 1; j<=i; j++) {
                if(i%j == 0) {
                    count++;
                }
            }
            if(count % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("left 값 입력 : ");
        int left = sc.nextInt();
        System.out.print("right 값 입력 : ");
        int right = sc.nextInt();

        int answer = solution(left, right);
        System.out.println("답 : " + answer);
    }
}
