package day250219;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 프로그래머스 과일 장수(135808)
/*
[문제 설명]
- 사과는 상태에 따라 1점부터 k점까지의 점수로 분류하며 k점이 최상, 1점이 최하품의 사과입니다.
- 한 상자에 m개씩 담아 포장, 상자에 담긴 사과 중 가장 낮은 점수가 p (1 ≤ p ≤ k)점인 경우, 사과 한 상자의 가격은 p * m 입니다.
- 과일 장수가 가능한 많은 사과를 팔았을 때, 얻을 수 있는 최대 이익을 계산하고자 합니다.
- 사과의 최대 점수 k, 한 상자에 들어가는 사과의 수 m, 사과들의 점수 score가 주어졌을 때,
- 과일 장수가 얻을 수 있는 최대 이익을 반환하는 solution 함수를 완성해주세요.
*/
public class n135808 {

    private static int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        for(int i = score.length; i>=m; i-=m) {
            answer += score[i-m]*m;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> scoresList = new ArrayList<>();
        int y = 1;
        int k = 0;
        int m = 0;
        while (true) {
            System.out.print("k값 입력 : ");
            k = sc.nextInt();
            if (k >= 3 && k <= 9) {
                break;
            } else {
                System.out.println("k값은 3보다 크거나 같고 9보다 작거나 같아야 합니다.");
            }
        }
        while (true) {
            System.out.print("m값 입력 : ");
            m = sc.nextInt();
            if (m >= 3 && m <= 10) {
                break;
            } else {
                System.out.println("m값은 3보다 크거나 같고 10보다 작거나 같아야 합니다.");
            }
        }
        System.out.println("score 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        sc.nextLine();
        while (true) {
            System.out.print(y + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int score = Integer.parseInt(input);
            scoresList.add(score);
            y++;
        }

        int[] score = scoresList.stream().mapToInt(i -> i).toArray();
        int answer = solution(k, m, score);

        System.out.println("답 : " + answer);
    }
}
