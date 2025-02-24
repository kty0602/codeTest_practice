package day250224;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 프로그래머스 덧칠하기(161989)
/*
[문제 설명]
- n미터인 벽이 있다. 벽에 칠하는 롤러의 길이는 m미터, 다시 칠하기로 저안 구역들의 번호가 담긴 정수 배열 section이 매개변수로
- 주어질 때 롤러로 페인트칠해야 하는 최소 횟수를 return 하시오.
[ex]
n m section   result
8 4 [2,3,6]   2
5 4 [1, 3]    1
4 1 [1,2,3,4] 4
*/
public class n161989 {

    private static int solution(int n, int m, int[] section) {
        int temp = 0;
        int count = 0;

        for(int i = 0; i<section.length; i++) {
            if (section[i] < temp) {
                continue;
            }
            count++;
            temp = section[i]+m;
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n값을 입력하시오. : ");
        int n = sc.nextInt();
        System.out.print("m값을 입력하시오. : ");
        int m = sc.nextInt();
        sc.nextLine();

        int y = 1;
        List<Integer> list = new ArrayList<>();
        System.out.println("section 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while(true) {
            System.out.print(y + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int section = Integer.parseInt(input);
            list.add(section);
            y++;
        }

        int[] section = list.stream().mapToInt(i->i).toArray();
        int result = solution(n, m, section);
        System.out.println("답 : " + result);
    }
}
