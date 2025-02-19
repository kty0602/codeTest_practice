package day250219;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 프로그래머스 카드 뭉치(159994)
/*
[문제 설명]
- 카드 뭉치 2개에서 적힌 단어들을 사용해 원하는 순서의 단어 배열을 만들 수 있는지 알아야 합니다.
- 만들 수 있다면 yes를 없다면 no를 리턴해야 합니다.
- 한 번 사용한 카드는 다시 사용 불가, 카드 뭉치 2개의 순서는 변경 불가
*/
public class n159994 {

    private static String solution(String[] cards1, String[] cards2, String[] goal) {
        int i = 0;
        int y = 0;
        for (String str : goal) {
            if (i<cards1.length && str.equals(cards1[i])) {
                i++;
            } else if (y<cards2.length && str.equals(cards2[y])) {
                y++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> cardList1 = new ArrayList<>();
        List<String> cardList2 = new ArrayList<>();
        List<String> goalList = new ArrayList<>();
        int y = 1;
        int x = 1;
        int z = 1;
        System.out.println("cards1 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(y + "번째 단어 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            cardList1.add(input);
            y++;
        }
        System.out.println("cards2 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(x + "번째 단어 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            cardList2.add(input);
            x++;
        }
        System.out.println("goal 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(z + "번째 단어 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            goalList.add(input);
            z++;
        }

        int cards1Size = cardList1.size();
        int cards2Size = cardList2.size();
        int goalSize = goalList.size();
        String cards1[] = cardList1.toArray(new String[cards1Size]);
        String cards2[] = cardList2.toArray(new String[cards2Size]);
        String goal[] = goalList.toArray(new String[goalSize]);

        String answer = solution(cards1, cards2, goal);
        System.out.println("답 : " + answer);
    }
}
