package day250224;

import java.util.ArrayList;
import java.util.Scanner;

// 프로그래머스 기사단원의 무기(136798)
/*
[문제 설명]
- 각 기사에게는 1번부터 number까지 번호가 지정되어 있다.
- 무기를 사려면 번호의 약수 개수에 해당하는 무기를 구매해야 한다.
- 단 협약에 의해 공격력 제한 수치를 정하고 제한수치보다 큰 공격력을 가진 무기를 구매해야 하는 기사는 협약 기관에서 정한 무기를 구매해야 한다.
- 예를 들어 15번의 약수는 1, 3, 5, 15로 4개, 공격력이 4다. 협약으로 인한 제한수치가 3이라면 공격력은 2가 된다.
- 이 때 공격력 1당 1kg의 철이 필요하다. 이 때 총 필요한 철의 무게를 구하라.
- 단 number값이 15면 1번 기사부터 15번기사까지의 무기를 만드는데 총 몇 kg의 철이 드는지를 return
[ex]
number limit power result
5      3     2     10
10     3     2     21
*/
public class n136798 {

    private static int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int count = 0;
            int sqrt = (int) Math.sqrt(i);

            for (int z = 1; z <= sqrt; z++) {
                if (i % z == 0) {
                    count++;
                    if (z != i / z) {
                        count++;
                    }
                }
            }
            if (count > limit) {
                count = power;
            }
            answer += count;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("number : ");
        int number = sc.nextInt();
        System.out.print("limit : ");
        int limit = sc.nextInt();
        System.out.print("power : ");
        int power = sc.nextInt();

        int result = solution(number, limit, power);
        System.out.println("답 : " + result);
    }
}
