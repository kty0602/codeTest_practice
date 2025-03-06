package day250306;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// 프로그래머스 달리기 경주(178871)
/*
[문제 설명]
- 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 불립니다.
- 경주가 끝났을 때 1등부터 등수 순서대로 배열에 담아 return하시오.
*/
public class n178871 {

    private static String[] solution(String[] players, String[] callings) {

        HashMap<String, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }

        for (String name : callings) {
            int rank = rankMap.get(name);

            if (rank > 0) {
                String front = players[rank - 1];
                players[rank - 1] = name;
                players[rank] = front;

                rankMap.put(name, rank - 1);
                rankMap.put(front, rank);
            }
        }
        return players;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("players 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        ArrayList<String> list1 = new ArrayList<>();
        while (true) {
            System.out.print("플레이어 이름을 입력하세요. : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            list1.add(input);
        }
        ArrayList<String> list2 = new ArrayList<>();
        while (true) {
            System.out.print("이름이 불린 선수의 이름 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            list2.add(input);
        }

        String[] players = list1.stream().toArray(String[]::new);
        String[] callings = list2.stream().toArray(String[]::new);
        String[] result = solution(players, callings);
        System.out.println("답 : " + Arrays.toString(result));

    }
}
