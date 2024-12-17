package day241217;

import java.util.Arrays;
import java.util.Scanner;

// 프로그래머스 나머지가 1이 되는 수 찾기(12954)
/*
[문제 설명]
- x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 return
*/
public class n12954 {

    private static long[] solution(int x, int n) {
        long[] answer = new long[n];

        for(int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 x 값 입력 : ");
        int x = sc.nextInt();
        System.out.print("자연수 n 값 입력 : ");
        int n = sc.nextInt();

        long[] answer = solution(x, n);
        System.out.println("답 : " + Arrays.toString(answer));
    }
}
