package day241220;

import java.util.ArrayList;
import java.util.Scanner;

// 프로그래머스 내적 구하기(70128)
/*
[문제 해설]
- 배열 a,b의 각 원소의 곱의 합을 구하여라
*/
public class n70128 {

    private static int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i]*b[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 1;
        int y = 1;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        System.out.println("a 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(x + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list1.add(number);
            x++;
        }

        System.out.println("b 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(y + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list2.add(number);
            y++;
        }

        int[] a = list1.stream().mapToInt(i -> i).toArray();
        int[] b = list2.stream().mapToInt(i -> i).toArray();

        int answer = solution(a, b);
        System.out.println("답 : " + answer);
    }
}
