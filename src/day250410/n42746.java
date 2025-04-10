package day250410;

import java.util.*;

// 프로그래머스 가장 큰 수 (42746)
/*
[문제 설명]
- 정수 배열이 담긴 numbers가 있을 때 각 숫자들을 서로 이었을 때 가장 큰 수의 값을 return
*/
public class n42746 {

    private static String solution(int[] numbers) {
        // 숫자 문자열로 변환
        String[] strNums = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // 정렬
        Arrays.sort(strNums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 비교 후 첫번째 값이 0 이라면 나머지도 다 0일 테니 0 리턴
        if (strNums[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String num : strNums) {
            sb.append(num);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("numbers 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            System.out.print("numbers : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list.add(number);
        }

        int[] numbers = list.stream().mapToInt(i -> i).toArray();
        String result = solution(numbers);
        System.out.print("답 : " + result);
    }
}
