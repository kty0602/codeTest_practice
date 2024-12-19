package day241219;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 프로그래머스 음양 더하기(76501)
/*
[문제 해설]
- signs와 absolutes 배열의 길이는 같다.
- signs[i]가 참이면 absolutes[i]는 양수 거짓이면 음수임을 의미한다.
- absolutes 배열 원소의 총 합을 return
*/
public class n76501 {

    private static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i<absolutes.length; i++) {
            if(signs[i] == true) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> inputList1 = new ArrayList<>();
        List<String> inputList2 = new ArrayList<>();
        int x = 1;
        int y = 1;
        System.out.println("absolutes 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(x+"번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            try {
                int number = Integer.parseInt(input);
                inputList1.add(number);
                x++;
            } catch (NumberFormatException e) {
                System.out.println("유효한 정수를 입력하거나 '!'를 입력해 종료하세요.");
            }
        }

        System.out.println("signs 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(y+"번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                inputList2.add(input);
                y++;
            } else {
                System.out.println("유효한 값(true 또는 false)을 입력하거나 '!'를 입력해 종료하세요.");
            }
        }

        int[] absolutes = inputList1.stream().mapToInt(i ->i).toArray();
        boolean[] signs = new boolean[inputList2.size()];
        for (int i = 0; i < inputList2.size(); i++) {
            signs[i] = Boolean.parseBoolean(inputList2.get(i));
        }

        int answer = solution(absolutes, signs);
        System.out.println("답 : " + answer);
    }
}
