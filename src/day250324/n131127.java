package day250324;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// 프로그래머스 할인 행사(131127)
/*
[문제 설명]
- XYZ 마트는 일정한 금액을 지불하면 10일 동안 회원 자격을 부여한다. XYZ 마트는 매일 한 가지 제품을 할인하는 행사를 한다.
- 정현이는 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입을 하려고 한다.
- 원하는 제품을 나타내는 문자열 배열 want와 원하는 제품의 수량을 나타내는 정수 배열 number, 할인하는 제품을 나타내는 문자열 배열 discount
- 가 주어질 때, 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수를 return 하시오.
*/
public class n131127 {

    private static int solution(String[] want, int[] number, String[] discount) {
        int result = 0;

        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        int size = 10; // 회원 자격이 있는 기간

        for (int i = 0; i <= discount.length - size; i++) {
            HashMap<String, Integer> map = new HashMap<>();

            // discount 배열 시작 부분부터 10일동안 할인 제품 목록, 갯수
            for (int j = 0; j < size; j++) {
                map.put(discount[i + j], map.getOrDefault(discount[i + j], 0) + 1);
            }

            boolean valid = true;

            for (String product : wantMap.keySet()) {
                // map의 해당 제품 개수가 원하는 개수보다 작으면 거짓
                if (map.getOrDefault(product, 0) < wantMap.get(product)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("want 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        int y = 1;
        ArrayList<String> list1 = new ArrayList<>();
        while (true) {
            System.out.print("want 배열의 " + y + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            list1.add(input);
            y++;
        }

        System.out.println("number 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        int x = 1;
        ArrayList<Integer> list2 = new ArrayList<>();
        while (true) {
            System.out.print("number 배열의 " + x + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int count = Integer.parseInt(input);
            list2.add(count);
            x++;
        }

        System.out.println("discount 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        int z = 1;
        ArrayList<String> list3 = new ArrayList<>();
        while (true) {
            System.out.print("discount 배열의 " + z + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            list3.add(input);
            z++;
        }

        String[] want = list1.stream().toArray(String[]::new);
        int[] number = list2.stream().mapToInt(i -> i).toArray();
        String[] discount = list3.stream().toArray(String[]::new);
        int result = solution(want, number, discount);
        System.out.print("답 : " + result);
    }
}
