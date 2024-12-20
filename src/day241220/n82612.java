package day241220;

import java.util.Scanner;

// 프로그래머스 부족한 금액 계산하기(82612)
/*
[문제 설명]
- 이 놀이기구의 원래 이용료는 price원 인데, 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다.
- 즉, 처음 이용료가 100이었다면 2번째에는 200, 3번째에는 300으로 요금이 인상됩니다.
- 놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return 하도록 solution 함수를 완성하세요.
*/
public class n82612 {

    private static long solution(int price, int money, int count) {
        long answer = 0;
        long t = 0;
        for(int i = 0; i<count; i++) {
            long a = price*(i+1);
            t += a;
        }
        if (t>money) {
            answer = t-money;
        } else {
            answer = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("price 입력 : ");
        int price = sc.nextInt();

        System.out.print("money 입력 : ");
        int money = sc.nextInt();

        System.out.print("count 입력 : ");
        int count = sc.nextInt();

        long answer = solution(price, money, count);
        System.out.println("답 : " + answer);
    }
}
