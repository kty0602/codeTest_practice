package day241223;

import java.util.Arrays;
import java.util.Scanner;

// 프로그래머스 최대공약수 최소공배수(12940)
/*
[문제 설명]
- 두 수를 입력받아 두 수의 최대 공약수와 최소공배수를 반환하는 함수
*/
public class n12940 {

    private static int[] solution(int n, int m) {
        int max = 0;
        int min  = 0;

        for(int i = 1; i<=n && i<=m; i++) {
            if(n%i==0 && m%i==0) {
                max = i;
            }
        }

        min = (n*m)/max;

        int[] answer = {max, min};

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n입력 : ");
        int n = sc.nextInt();
        System.out.print("m입력 : ");
        int m = sc.nextInt();

        int[] answer = solution(n, m);
        System.out.println("답 : " + Arrays.toString(answer));
    }
}
