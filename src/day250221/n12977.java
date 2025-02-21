package day250221;

import java.util.ArrayList;
import java.util.Scanner;

// 프로그래머스 소수 만들기(12977)
/*
[문제 설명]
- 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
- 경우의 개수를 return 하시오.
*/
public class n12977 {

    private static int solution(int[] nums) {
        int result = 0;

        for(int i = 0; i<nums.length; i++) {
            for(int y = i+1; y<nums.length; y++) {
                for(int z = y+1; z<nums.length; z++) {
                    int sum = nums[i] + nums[y] + nums[z];

                    if (check(sum)) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    private static boolean check(int sum) {
        if (sum<2) {
            return false;
        }
        for(int i=2; i<sum; i++) {
            if(sum%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int y = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("numbers 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(y + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list.add(number);
            y++;
        }

        int[] nums = list.stream().mapToInt(i -> i).toArray();

        int answer = solution(nums);
        System.out.println("답 : " + answer);
    }
}
