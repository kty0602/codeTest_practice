package day241218;

import java.util.Scanner;

// 프로그래머스 콜라츠 추측(12943)
/*
[문제 해설]
1-1. 입력된 수가 짝수라면 2로 나눈다.
1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더한다.
2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복한다.

- 1이 되기 위해 몇 번 작업을 반복하는지 return
  500번이상 반복한다면 -1을 return
*/
public class n12943 {

    private static int solution(long num) {
        if(num == 1) {
            return 0;
        }
        int count = 0;
        while(num != 1) {
            if(num%2 == 0) {
                num/=2;
                count++;
            } else {
                num = num*3 + 1;
                count++;
            }
            if(count == 500) {
                count = -1;
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 입력 : ");
        long s = sc.nextLong();

        int answer = solution(s);
        System.out.println("반복 횟수 : " + answer);
    }
}
