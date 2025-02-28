package day250228;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 프로그래머스 대충 만든 자판(160586)
/*
[문제 설명]
- 1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 문자열배열 keympa과 입력하려는 문자열들이 담긴 문자열 배열 targets가 주어질 때
- 각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아 return하는 solution을 완성하시오.
*/
public class n160586 {

    private static int[] solution(String[] keymap, String[] targets) {
        int[] keyCount = new int[26]; // A-Z의 최소 입력 횟수 저장
        Arrays.fill(keyCount, Integer.MAX_VALUE);

        // keymap을 순회하며 각 문자에 대한 최소 입력 횟수 저장
        for (String keys : keymap) {
            for (int i = 0; i < keys.length(); i++) {
                char c = keys.charAt(i);
                keyCount[c - 'A'] = Math.min(keyCount[c - 'A'], i + 1);
            }
        }

        // 각 단어를 입력할 때 필요한 최소 횟수 계산
        int[] result = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            boolean impossible = false;
            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                if (keyCount[c - 'A'] == Integer.MAX_VALUE) {
                    impossible = true;
                    break;
                }
                sum += keyCount[c - 'A'];
            }
            result[i] = impossible ? -1 : sum;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = 1;
        int y = 1;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        System.out.println("keymap 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(x + "번째 문자열 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            list1.add(input);
            x++;
        }

        System.out.println("targets 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(y + "번째 문자열 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            list2.add(input);
            y++;
        }

        String[] keymap = list1.stream().toArray(String[]::new);
        String[] targets = list2.stream().toArray(String[]::new);

        int[] result = solution(keymap, targets);
        System.out.println("답 : " + Arrays.toString(result));
    }
}
