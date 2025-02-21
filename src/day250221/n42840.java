package day250221;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 프로그래머스 모의고사(42840)
/*
[문제 설명]
- 수포자 3인방은 모의고사 수학 무넺를 찍으려고 합니다.
- 1번 수포자 찍는 방식 : 1,2,3,4,5,1,2,3...
- 2번 수포자 찍느 방식 : 2,1,2,3,2,4,2,5,2,1,2...
- 3번 수포자 찍는 방식 : 3,3,1,1,2,2,4,4,5,5,3,3,1,1,...
- 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하시오.
*/
public class n42840 {

    private static List<Integer> solution(int[] numbers) {
        // 각 시험자의 찍는 방식
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 각 시험자 점수를 카운팅 하는 곳
        int[] score = new int[3];

        for (int i = 0; i< numbers.length; i++) {
            if (numbers[i] == first[i%5]) {
                score[0]++;
            }
            if (numbers[i] == second[i%8]) {
                score[1]++;
            }
            if (numbers[i] == third[i%10]) {
                score[2]++;
            }
        }

        // 가장 높은 점수 파악하기
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> list = new ArrayList<>();

        // 높은 점수와 일치하는 시험자 번호를 list에 선언
        for(int i = 0; i<3; i++) {
            if (maxScore == score[i]) {
                list.add(i+1);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = 1;
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("정답 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
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

        int[] numbers = list.stream().mapToInt(i -> i).toArray();

        List<Integer> answer = solution(numbers);
        System.out.println("답 : " + answer);
    }
}
