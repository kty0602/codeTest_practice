package day250217;


import java.util.ArrayList;
import java.util.Scanner;

// 프로그래머스 푸드 파이트 대회(134240)
/*
[문제 설명]
- 주어진 음식을 일렬로 배치한 뒤, 한 선수는 왼쪽에서 다른 선수는 오른쪽에서 순서대로 먹는 방식입니다.
- 중앙에는 물이 배치되고 물을 먼저 먹는 선수가 승리합니다.
- 정수 배열 food가 주어졌을 때 음식의 배치를 나타내는 문자열을 return 하시오.
[제한 조건]
- food[i] 는 i번 음식의 수
- food[0] 은 물 -> 늘 항상 1이다.
*/
public class n134240 {

    private static String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        for(int i = 1; i<food.length; i++) {
            int count = food[i]/2;
            for(int j = 0; j<count; j++) {
                answer.append(i);
            }
        }
        String reverse = new StringBuilder(answer).reverse().toString();
        answer.append("0");
        answer.append(reverse);
        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = 0;
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("food 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        System.out.println("food 배열의 0번째 값은 자동으로 1이 주어집니다.");
        while(true) {
            if (y==0) {
                int food = 1;
                list.add(food);
                y++;
            }
            System.out.println("배열 " + y + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int food = Integer.parseInt(input);
            list.add(food);
            y++;
        }

        int[] food = list.stream().mapToInt(i -> i).toArray();

        String answer = solution(food);
        System.out.println("답 : " + answer);
    }
}
