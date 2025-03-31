package day250331;

import java.util.Scanner;

// 프로그래머스 k진수에서 소수 개수 구하기(92335)
/*
[문제 설명]
- 숫자 n을 k진수로 바꾸고 그 숫자에서 소수가 될 수 있는 숫자 개수를 return
*/
public class n92335 {

    private static int solution(int n, int k) {
        int answer = 0;
        String p = Integer.toString(n, k);
        String[] arr = p.split("0");

        for (String data : arr) {
            if (data.equals("")) continue;
            long num = Long.parseLong(data);
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean isPrime(long a) {
        if (a < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(a); i++){
            if (a % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n값 입력 : ");
        int n = sc.nextInt();

        System.out.print("k값 입력 : ");
        int k = sc.nextInt();

        int result = solution(n, k);
        System.out.print("답 : " + result);
    }
}
