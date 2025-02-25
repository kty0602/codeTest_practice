package day250225;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 프로그래머스 로또의 최고 순위와 최저 순위(161989)
/*
[문제 설명]
- 1부터 45까지의 숫자 중 6개를 찍어서 맞히는 복권
- 알아볼 수 없는 번호를 0으로 표기하고 구매한 로또 번호가 44, 1, 0, 0, 31, 25라고 가정
- 당첨 번호가 31, 10, 45, 1, 6, 19라면 가능한 최고 순위와 최저 순위는 3등과 5등이 될 수 있다.
*/
public class n77484 {

    private static int[] solution(int[] lotto, int[] win) {
        int[] answer = new int[2];
        int[] rank = {6, 6, 5, 4, 3, 2, 1}; // 0개 맞춘 경우 6등이 되도록
        int count = 0;
        int zero_count = 0;
        for(int i = 0; i < lotto.length; i++) {
            if (lotto[i] == 0) {
                zero_count++;
                continue;
            }
            for(int y = 0; y < win.length; y++) {
                if (lotto[i] == win[y]) {
                    count++;
                }
            }
        }
        answer[0] = rank[count + zero_count];
        answer[1] = rank[count];

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            System.out.print("로또 번호 입력 : ");
            String input = sc.nextLine();
            int number = Integer.parseInt(input);
            list1.add(number);
        }
        for(int y = 0; y < 6; y++) {
            System.out.print("당첨 번호 입력 : ");
            String input = sc.nextLine();
            int number = Integer.parseInt(input);
            list2.add(number);
        }
        int[] lotto_list = list1.stream().mapToInt(i -> i).toArray();
        int[] win_list = list2.stream().mapToInt(i -> i).toArray();

        int[] answer = solution(lotto_list, win_list);
        System.out.println("답 : " + Arrays.toString(answer));
    }
}
