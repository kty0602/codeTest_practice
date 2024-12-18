package day241218;

import java.util.Scanner;

// 프로그래머스 하샤드 수(12947)
/*
[문제 해설]
- x가 하샤드 수라면 x의 자릿수 합으로 x가 나눠저야 한다.
  하샤드 수라면 true를 아니라면 false를 리턴
*/
public class n12947 {

    private static boolean solution(int x) {
        int sum = 0;
        int num = x;
        while(num > 0) {
            sum += num%10;
            num/=10;
        }
        if(x%sum == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 입력 : ");
        int x = sc.nextInt();

        boolean answer = solution(x);
        System.out.println("답 : " + answer);
    }
}
