package day250217;

import java.util.Scanner;

// 프로그래머스 콜라 문제(132267)
/*
[문제 설명]
- 콜라 빈 병 2개를 가져다주면 콜라 1병을 주는 마트가 있습니다. 20병을 가져다 주면 최대 몇 병을 받을 수 있는가?
- 콜라 20병을 가져가서 10병을 받습니다. 받은 10병을 모두 마신 뒤, 가져가서 5병을 받습니다. 이후 4병을 주고 2병을 받고
- 2병을 마신 뒤 1병을 받습니다. 이후 받은 1병과 남은 1병을 모두 마신 뒤 가져가면 1병을 다시 받을 수 있습니다.
- 이런 상황 시 총 19병의 콜라를 받을 수 있습니다.
*/
public class n132267 {

    private static int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a) {
            int i = n/a;
            int j = n%a;
            answer += i*b;
            n = i*b+j;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("빈 병 반납 최소 갯수 a : ");
        int a = sc.nextInt();
        System.out.print("다시 주는 갯수 b : ");
        int b = sc.nextInt();
        System.out.print("총 가지고 있는 빈 병 갯수 n : ");
        int n = sc.nextInt();

        int answer = solution(a, b, n);
        System.out.println("답 : " + answer);
    }
}
