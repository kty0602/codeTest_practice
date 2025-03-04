package day250304;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 프로그래머스 햄버거 만들기(133502)
/*
[문제 설명]
- 직원들이 햄버거 재료를 조리해 주면 조리된 순서대로 앞에 아래서부터 위로 쌓이게 되고, 순서에 맞게 햄버거를 완성하면 됩니다.
- 아래서부터 빵-야채-고기-빵 으로 쌓여야 합니다.
*/
public class n133502 {

    private static int solution(int[] ingredient) {
        List<Integer> stack = new ArrayList<>();
        int count = 0;

        for (int i : ingredient) {
            stack.add(i);

            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size - 4) == 1 &&
                        stack.get(size - 3) == 2 &&
                        stack.get(size - 2) == 3 &&
                        stack.get(size - 1) == 1) {
                    for (int j = 0; j < 4; j++) {
                        stack.remove(stack.size() - 1);
                    }
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("reserve 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        int y = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            System.out.print(y + "번째 재료 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list.add(number);
            y++;
        }

        int[] ingredient = list.stream().mapToInt(i -> i).toArray();

        int result = solution(ingredient);
        System.out.println("답 : " + result);
    }
}
