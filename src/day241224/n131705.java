package day241224;

import java.util.ArrayList;
import java.util.Scanner;

// 프로그래머스 삼총사(131705)
/*
[문제 설명]
- 배열 원소들을 입력받고 원소들 중 3가지 합이 0이 되는 삼총사 개수를 return
*/
public class n131705 {

    private static int solution(int[] number) {
        int answer = 0;
        for(int i = 0; i<number.length; i++) {
            for(int j = i+1; j<number.length; j++) {
                for(int z=j+1; z<number.length; z++) {
                    if(number[i]+number[j]+number[z] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = 1;
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("number 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(y + "번재 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list.add(number);
            y++;
        }

        int[] number = list.stream().mapToInt(i ->i).toArray();

        int answer = solution(number);
        System.out.println("답 : " + answer);
    }
}
