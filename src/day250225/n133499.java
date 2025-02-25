package day250225;

import java.util.ArrayList;
import java.util.Scanner;

// 프로그래머스 옹알이(133499)
/*
[문제 설명]
- 조카는 아직 "aya", "ye", "woo", "ma" 발음과 조합해서 만들 수 있는 발음만 가능합니다.
- 연속된 발음은 불가합니다.
- 문자열 배열 babbling이 매개변수로 줄 때 발음할 수 있는 단어 갯수를 return 하시오.
*/
public class n133499 {

    private static int solution(String[] babbling) {
        int count = 0;
        String[] list = {"aya", "ye", "woo", "ma"};

        for (int i = 0; i < babbling.length; i++) {
            if(babbling[i].matches("^(aya|ye|woo|ma)+$")) {
                boolean isValid = true;
                for (int j = 0; j < list.length; j++) {
                    if (babbling[i].contains(list[j] + list[j])) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = 1;
        ArrayList<String> list = new ArrayList<>();
        System.out.println("numbers 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(y + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            list.add(input);
            y++;
        }

        String[] babbling = list.stream().toArray(String[]::new);
        int answer = solution(babbling);
        System.out.println("답 : " + answer);

    }
}
