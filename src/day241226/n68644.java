package day241226;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// 프로그래머스 두 개 뽑아서 더하기(68644)
/*
[문제 설명]
- 정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는
- 모든 수를 배열에 오름차순으로 담아 return
*/
public class n68644 {

    private static int[] solution(int[] numbers) {
        List<Integer> list= new ArrayList<>();
        for(int i = 0; i < numbers.length-1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                list.add(sum);
            }
        }
        List<Integer> newList = list.stream().distinct().sorted().collect(Collectors.toList());

        return newList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = 1;
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("numbers 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
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

        int[] answer = solution(numbers);
        System.out.println("답 : " + Arrays.toString(answer));
    }
}
