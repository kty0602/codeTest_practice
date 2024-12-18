package day241218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 프로그래머스 나누어 떨어지는 숫자 배열(12910)
/*
[문제 해설]
- 배열 arr과 divisor값을 입력받아 arr 중 divisor값으로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 return
*/
public class n12910 {

    private static int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int a : arr){
            if(a % divisor == 0){
                list.add(a);
            }
        }
        if(list.size() == 0) {
            int[] noResult = {-1};
            return noResult;
        }

        Collections.sort(list);

        int[] result = list.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int y = 1;

        System.out.println("배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(y+"번째 값 : ");
            String input = sc.next();
            if (input.equals("!")) {
                break;
            }
            try {
                int number = Integer.parseInt(input);
                list.add(number);
                y++;
            } catch (NumberFormatException e) {
                System.out.println("유효한 정수를 입력하거나 '!'를 입력해 종료하세요.");
            }
        }

        // ArrayList를 int[]로 변환
        int[] arr = list.stream().mapToInt(i -> i).toArray();

        System.out.print("divisor 숫자 입력 : ");
        int divisor = sc.nextInt();

        int[] answer = solution(arr, divisor);
        System.out.println("답 : " + Arrays.toString(answer));
    }
}
